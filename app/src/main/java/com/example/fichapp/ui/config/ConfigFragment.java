package com.example.fichapp.ui.config;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.fichapp.R;

public class ConfigFragment extends Fragment {

    private ConfigViewModel viewModel;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {

        View root = inflater.inflate(R.layout.config_fragment, container, false);
        viewModel = ViewModelProviders.of(this).get(ConfigViewModel.class);

        final WebView webView = root.findViewById(R.id.web_view_pager);

        CustomThread thread = new CustomThread();
        thread.execute("https://agora.xtec.cat/insjoandaustria/");

        viewModel.getWeb().observe(this, html ->
                webView.loadDataWithBaseURL(
                        "",
                        html,
                        "text/html",
                        "UTF-8",
                        ""
                ));
        return root;
    }

    public class CustomThread extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            viewModel.downloadURL((strings[0]));
            return null;
        }
    }
}