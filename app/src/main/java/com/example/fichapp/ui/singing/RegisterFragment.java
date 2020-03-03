package com.example.fichapp.ui.singing;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fichapp.R;
import com.example.fichapp.databinding.FragmentSingInBinding;
import com.example.fichapp.model.RegisterHistoryModel;

public class RegisterFragment extends Fragment {

    private RegisterViewModel viewModel;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        FragmentSingInBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sing_in, container, false);
        binding.setLifecycleOwner(this);
        viewModel = new RegisterViewModel(getActivity().getApplication());
        binding.setViewModel(viewModel);
        viewModel.lastRegister.observe(this, new Observer<RegisterHistoryModel>() {
            @Override
            public void onChanged(RegisterHistoryModel registerHistoryModel) {
                viewModel.setTime();
            }
        });
        return binding.getRoot();
    }
}
