package com.example.fichapp.ui.history;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.fichapp.R;
import com.example.fichapp.model.RegisterHistoryModel;
import com.example.fichapp.utils.DateUtils;

import java.util.Date;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemListViewHolder> {

    private List<RegisterHistoryModel> registerHistoryModelList;

    static class ItemListViewHolder extends RecyclerView.ViewHolder {

        TextView firstText, secondText, thirdText;

        ItemListViewHolder(View v) {
            super(v);
            this.firstText = v.getRootView().findViewById(R.id.firstText);
            this.secondText = v.getRootView().findViewById(R.id.secondText);
            this.thirdText = v.getRootView().findViewById(R.id.thirdText);
        }
    }

    ItemListAdapter(List<RegisterHistoryModel> registerHistoryModelList) {
        this.registerHistoryModelList = registerHistoryModelList;
    }

    @NonNull
    @Override
    public ItemListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutInflater = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);
        return new ItemListViewHolder(layoutInflater);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemListViewHolder holder, int position) {
        if(registerHistoryModelList != null) {
            Date date = registerHistoryModelList.get(position).getDay();
            holder.firstText.setText(DateUtils.completeDateToString(date));
            holder.secondText.setText(registerHistoryModelList.get(position).getAction());
        }
    }

    @Override
    public int getItemCount() {
        if(registerHistoryModelList != null) {
            return registerHistoryModelList.size();
        }
        return 0;
    }
}