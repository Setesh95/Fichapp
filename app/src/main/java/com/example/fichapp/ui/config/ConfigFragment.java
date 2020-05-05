package com.example.fichapp.ui.config;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.fichapp.R;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConfigFragment extends Fragment {

    private WebViewViewModel webViewViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.config_fragment, container, false);

        webViewViewModel =
                ViewModelProviders.of(this).get(WebViewViewModel.class);
        final WebView webView = root.findViewById(R.id.web_view_pager);
        webView.getSettings().setJavaScriptEnabled(true);

        MiHilo miHilo = new MiHilo();
        miHilo.execute("https://agora.xtec.cat/insjoandaustria/");


        webViewViewModel.getWeb().observe(
                this,
                new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        webView.loadData(s, "text/html", "utf-8");
                    }
                }
        );

        return root;
    }

    public class MiHilo extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            webViewViewModel.downloadURL(strings[0]);
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }
}
