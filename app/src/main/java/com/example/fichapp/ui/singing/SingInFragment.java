package com.example.fichapp.ui.singing;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fichapp.R;
import com.example.fichapp.databinding.FragmentSingInBinding;

public class SingInFragment extends Fragment {

    private SingInViewModel viewModel;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        FragmentSingInBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sing_in, container, false);
        binding.setLifecycleOwner(this);
        viewModel = new SingInViewModel(getActivity().getApplication());
        binding.setViewModel(viewModel);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
