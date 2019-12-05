package com.example.fichapp.ui.history;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.fichapp.R;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemListViewHolder> {

    private ArrayList<RegisterHistoryModel> dateList;

    public static class ItemListViewHolder extends RecyclerView.ViewHolder {

        TextView firstText, secondText, thirdText;

        public ItemListViewHolder(View v) {
            super(v);
            this.firstText = v.getRootView().findViewById(R.id.firstText);
            this.secondText = v.getRootView().findViewById(R.id.secondText);
            this.thirdText = v.getRootView().findViewById(R.id.thirdText);
        }
    }

    public ItemListAdapter(ArrayList<RegisterHistoryModel> dateList) {
        this.dateList = dateList;
    }

    @NonNull
    @Override
    public ItemListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vl  = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);
        return new ItemListViewHolder(vl);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemListViewHolder holder, int position) {

        holder.firstText.setText(dateList.get(position).getDay());
        holder.secondText.setText(dateList.get(position).getTimeCheckIn());
        holder.thirdText.setText(dateList.get(position).getTimeCheckOut());
    }

    @Override
    public int getItemCount() {
        return dateList.size();
    }
}