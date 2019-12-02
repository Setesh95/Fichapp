package com.example.fichapp.ui.singing;


import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.fichapp.R;
import com.example.fichapp.databinding.FragmentSingInBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

public class SingInFragment extends Fragment {

    private SingInViewModel viewModel;
    FloatingActionButton signInOut, stopWork;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        FragmentSingInBinding binding = DataBindingUtil.inflate(inflater,R.layout.fragment_sing_in, container,false);
        binding.setLifecycleOwner(this);
        viewModel = new SingInViewModel(getContext());
        binding.setViewModel(viewModel);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        signInOut = getView().findViewById(R.id.signInOut);
        stopWork = getView().findViewById(R.id.stopWork);
        signInOut.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                signInOut.setImageResource(R.drawable.ic_simbolo_de_pausa);
            }
        });
    }

}
