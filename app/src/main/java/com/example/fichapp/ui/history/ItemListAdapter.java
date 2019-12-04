package com.example.fichapp.ui.history;

import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemListViewHolder> {

    private String[] dateList;

    public static class ItemListViewHolder extends RecyclerView.ViewHolder{

        TextView firstText, secondText, thirdText;

        public ItemListViewHolder( TextView firstText, TextView secondText, TextView thirdText) {
            super(firstText);
            this.firstText = firstText;
            this.secondText = secondText;
            this.thirdText = thirdText;
        }
    }

    public ItemListAdapter(String[] dateList) {
        this.dateList = dateList;
    }

    @NonNull
    @Override
    public ItemListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemListViewHolder holder, int position) {
        holder.firstText.setText(dateList[position]);
        holder.secondText.setText(dateList[position]);
        holder.thirdText.setText(dateList[position]);
    }

    @Override
    public int getItemCount() {
        return dateList.length;
    }
}