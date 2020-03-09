package com.example.fichapp.ui.chat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fichapp.R;
import com.example.fichapp.model.MessageModel;
import com.example.fichapp.repository.Constants;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatListViewHolder> {
    private List<MessageModel> messageModel;

    static class ChatListViewHolder extends RecyclerView.ViewHolder {

        TextView firstText;

        ChatListViewHolder(View v) {
            super(v);
            this.firstText = v.getRootView().findViewById(R.id.thirdText);
        }
    }

    @NonNull
    @Override
    public ChatListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == 1){
            View layoutInflater = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.received_message, parent, false);
            return new ChatListViewHolder(layoutInflater);
        } else {
            View layoutInflater = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.sended_message, parent, false);
            return new ChatListViewHolder(layoutInflater);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(messageModel.get(position).getSender().equals(""/*TODO MI EMAIL*/)) {
            //TODO hacer
        }
        return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatListViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

}
