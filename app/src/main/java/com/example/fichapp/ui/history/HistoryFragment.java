package com.example.fichapp.ui.history;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.fichapp.R;
import com.example.fichapp.databinding.FragmentHistoryBinding;

import java.util.ArrayList;
import java.util.Objects;

public class HistoryFragment extends Fragment {

    private HistoryViewModel viewModel;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        FragmentHistoryBinding binding = DataBindingUtil.inflate(inflater,R.layout.fragment_history, container,false);
        binding.setLifecycleOwner(this);
        viewModel = new HistoryViewModel(getContext());
        binding.setViewModel(viewModel);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        RecyclerView recyclerView = Objects.requireNonNull(getView()).findViewById(R.id.history_list);
        recyclerView.setLayoutManager(manager);
        inflateList();
        RecyclerView.Adapter adapter = new ItemListAdapter(viewModel.getHistoryList());
        recyclerView.setAdapter(adapter);
    }

    private void inflateList(){
        ArrayList<RegisterHistoryModel> dataList = new ArrayList<>();
        dataList.add(new RegisterHistoryModel("01/12/2019","08:00:21","18:01:22"));
        dataList.add(new RegisterHistoryModel("02/12/2019","08:01:13","18:00:15"));
    }
}
