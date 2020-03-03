package com.example.fichapp.ui;

import android.content.res.Resources;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.fichapp.R;
import com.example.fichapp.ui.config.ConfigFragment;
import com.example.fichapp.ui.history.HistoryFragment;
import com.example.fichapp.ui.singing.SingInFragment;

public class Navigator {
    private FragmentManager fragmentManager;
    private Resources resources;
    private static Navigator navigator = null;

    private Navigator(FragmentActivity activity) {
        fragmentManager = activity.getSupportFragmentManager();
    }

    public static Navigator getInstance(FragmentActivity activity) {
        if (navigator == null) {
            navigator = new Navigator(activity);
        }
        return navigator;
    }

    public void navigateTo(Fragment fragment, Boolean isBackStack) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment, fragment);
        if (isBackStack) {
            transaction.addToBackStack(fragment.getTag());
        }
        transaction.commit();
    }

    public void navigateMenu(Integer id, Boolean isBackStack) {
        switch (id) {
            case R.id.register_control_menu:
                navigateTo(new SingInFragment(), isBackStack);
                break;
            case R.id.history_menu:
                navigateTo(new HistoryFragment(), isBackStack);
                break;
            case R.id.global_menu:
                navigateTo(new ConfigFragment(), isBackStack);
                break;
            default:
                break;
        }
    }
}