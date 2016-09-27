package com.jash.touchdemo;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> implements View.OnTouchListener, View.OnClickListener, SwipeDismissBehavior.OnDismissListener, SlidingPaneLayout.PanelSlideListener {
    private Context context;
    private List<String> list;
    private RecyclerView recyclerView;

    public Adapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
//        view.setOnTouchListener(this);
//        view.setOnClickListener(this);
        ViewHolder holder = new ViewHolder(view);
//        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) holder.text.getLayoutParams();
//        SwipeDismissBehavior behavior = new SwipeDismissBehavior();
//        behavior.setListener(this);
//        params.setBehavior(behavior);
        holder.delete.setOnClickListener(this);
        ((SlidingPaneLayout) holder.itemView).setPanelSlideListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.text.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        CardView card = (CardView) v;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                card.setCardElevation(50);
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                card.setCardElevation(card.getResources().getDimension(R.dimen.cardview_default_elevation));
                break;
        }
        v.onTouchEvent(event);
        return true;
    }

    @Override
    public void onClick(View v) {
//        Toast.makeText(context, "点击事件", Toast.LENGTH_SHORT).show();
        SlidingPaneLayout parent = (SlidingPaneLayout) v.getParent();
        parent.closePane();
        int position = recyclerView.getChildAdapterPosition(parent);
        list.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public void onDismiss(View view) {
        int position = recyclerView.getChildAdapterPosition((View) view.getParent());
        list.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public void onDragStateChanged(int state) {

    }

    @Override
    public void onViewDetachedFromWindow(ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        ((SlidingPaneLayout) holder.itemView).closePane();
    }

    @Override
    public void onPanelSlide(View panel, float slideOffset) {
        View view = ((View) panel.getParent()).findViewById(R.id.delete);
        ViewCompat.setTranslationX(view, view.getWidth() * (slideOffset - 1));
    }

    @Override
    public void onPanelOpened(View panel) {

    }

    @Override
    public void onPanelClosed(View panel) {

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView text;
        private View delete;

        public ViewHolder(View itemView) {
            super(itemView);
            text = ((TextView) itemView.findViewById(R.id.item_text));
            delete = itemView.findViewById(R.id.delete);
        }
    }
}
