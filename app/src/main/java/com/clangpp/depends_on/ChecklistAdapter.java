package com.clangpp.depends_on;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Adapter for checklist items.
 */
public class ChecklistAdapter extends RecyclerView.Adapter<ChecklistAdapter.ViewHolder> {

    private String[] mItems;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public CheckBox mItemCheckbox;
        public TextView mItemTextView;
        public Button mItemDepends;
        public Button mItemTriggers;

        public ViewHolder(View itemView) {
            super(itemView);
            mItemCheckbox = (CheckBox) itemView.findViewById(R.id.item_checkbox);
            mItemTextView = (TextView) itemView.findViewById(R.id.item_textview);
            mItemDepends = (Button) itemView.findViewById(R.id.item_depends);
            mItemTriggers = (Button) itemView.findViewById(R.id.item_triggers);
        }
    }

    public ChecklistAdapter(String[] items) {
        mItems = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View checklistItemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.checklist_item, viewGroup, false);
        return new ViewHolder(checklistItemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.mItemTextView.setText(mItems[i]);
    }

    @Override
    public int getItemCount() {
        return mItems.length;
    }
}
