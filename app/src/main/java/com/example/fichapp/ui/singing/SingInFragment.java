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
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

public class SingInFragment extends Fragment {

    private SingInViewModel viewModel;
    private FloatingActionButton signInOut;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        FragmentSingInBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sing_in, container, false);
        binding.setLifecycleOwner(this);
        viewModel = new SingInViewModel(getContext());
        binding.setViewModel(viewModel);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        signInOut = Objects.requireNonNull(getView()).findViewById(R.id.signInOut);
        setObserver();
    }

    private void setObserver() {
        viewModel.pausedStatus.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    signInOut.setImageResource(R.drawable.ic_detener);
                } else {
                    signInOut.setImageResource(R.drawable.ic_boton_de_reproduccion_punta_de_flecha);
                }
            }
        });
    }
}
