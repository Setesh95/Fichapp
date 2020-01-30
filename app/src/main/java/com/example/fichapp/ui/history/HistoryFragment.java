package com.example.fichapp.ui.history;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.fichapp.R;
import com.example.fichapp.databinding.FragmentHistoryBinding;
import com.example.fichapp.repository.Constants;

import java.util.List;
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
        viewModel = new HistoryViewModel(getActivity().getApplication());
        binding.setViewModel(viewModel);
        setObserver();
        return binding.getRoot();
    }

    private void setObserver() {
        Constants.REGISTER_LIST.observe(this, (Observer<List>) list -> {
            if(list.size() != 0){
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
                RecyclerView recyclerView = Objects.requireNonNull(getView()).findViewById(R.id.history_list);
                recyclerView.setLayoutManager(layoutManager);
                RecyclerView.Adapter adapter = new ItemListAdapter(Constants.REGISTER_LIST);
                recyclerView.setAdapter(adapter);
            }
        });
    }
}
