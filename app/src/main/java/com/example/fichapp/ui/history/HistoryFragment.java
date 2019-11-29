package com.example.fichapp.ui.history;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.fichapp.R;
import com.example.fichapp.databinding.FragmentHistoryBinding;

public class HistoryFragment extends Fragment {

    private HistoryViewModel viewModel;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        viewModel = new HistoryViewModel();
        FragmentHistoryBinding binding = DataBindingUtil.inflate(inflater,R.layout.fragment_history, container,false);
        binding.setLifecycleOwner(this);
        viewModel = new HistoryViewModel();
        binding.setViewModel(viewModel);
        return binding.getRoot();
    }
}
