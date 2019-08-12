
package app.weather.task.weatherapp.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ProgressBar;

import app.weather.task.weatherapp.R;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {
    private Unbinder unbinder;
    private AppCompatActivity activity;
    public Dialog progressDialog;
    private ProgressBar progressBar;

    @LayoutRes
    protected abstract int layoutRes();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(layoutRes(), container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (AppCompatActivity) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        activity = null;
    }


    public void showProgressbar(Activity activity) {
        // popup..
        try {
            if (progressDialog == null) {
                progressDialog = new Dialog(getContext(), android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
            }
            progressDialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            progressDialog.setContentView(getLayoutInflater().inflate(
                    R.layout.dialog_progressbar, null));
            progressDialog.setCancelable(false);
            progressDialog.show();
            progressBar = (ProgressBar) progressDialog.findViewById(R.id.progressBarTwo);
            progressDialog.show();

        } catch (Exception e) {

        }
    }


    public void dissmissProgressbar() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }
    public AppCompatActivity getBaseActivity() {
        return activity;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(unbinder != null) {
            unbinder.unbind();
            unbinder = null;
        }
    }
}
