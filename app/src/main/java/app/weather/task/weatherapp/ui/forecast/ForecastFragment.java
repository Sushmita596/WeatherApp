package app.weather.task.weatherapp.ui.forecast;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.text.DecimalFormat;

import app.weather.task.weatherapp.R;
import app.weather.task.weatherapp.base.BaseFragment;
import app.weather.task.weatherapp.data.model.ApiInput;
import app.weather.task.weatherapp.data.model.ForecastResponse;
import app.weather.task.weatherapp.data.rest.ApiUrls;
import app.weather.task.weatherapp.data.rest.response.ApiResponse;
import app.weather.task.weatherapp.util.Constants;
import butterknife.BindView;


public class ForecastFragment extends BaseFragment {


    ForecastViewModel forecastViewModel;

    @BindView(R.id.tv_avg_temperature)
    TextView tv_avg_temperature;

    @BindView(R.id.tv_city)
    TextView tv_city;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.rl_recyclerView)
    RelativeLayout rl_recyclerView;

    @BindView(R.id.ll_placeholder)
    LinearLayout ll_placeholder;

    @BindView(R.id.btn_retry)
    Button btn_retry;

    String latitude , longitude ,city;

    @Override
    protected int layoutRes() {
        return R.layout.screen_details;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        latitude=getArguments().getString(Constants.LATITUDE);
        longitude=getArguments().getString(Constants.LONGITUDE);
        city=getArguments().getString(Constants.CITY);
        forecastViewModel = ViewModelProviders.of(this).get(ForecastViewModel.class);

        showProgressbar(getActivity());
        forecastViewModel.loadForecast(new ApiInput(ApiUrls.API_KEY , latitude,longitude,4));
        forecastViewModel.getForecastLiveData().observe(this, (ForecastResponse response) -> {
            dissmissProgressbar();
            if(response != null) {

                ll_placeholder.setVisibility(View.GONE);

                renderData(response);

            }
            else{
                ll_placeholder.setVisibility(View.VISIBLE);
            }
        });

        btn_retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                showProgressbar(getActivity());
                forecastViewModel.loadForecast(new ApiInput(ApiUrls.API_KEY , latitude,longitude,4));
            }
        });


    }

    private void renderData(ForecastResponse response) {
        Log.d("response=", "Temperature in Celcius "+ response.getCurrent().getTempC());
        String temp = new DecimalFormat("#").format(response.getCurrent().getTempC());
        String tempC =temp+(char) 0x00B0;
        tv_avg_temperature.setText(tempC + " C");

        tv_city.setText(city);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new ForecastListAdapter(forecastViewModel, this));

        layoutAnimation();
    }

    public void layoutAnimation() {
        rl_recyclerView.setVisibility(View.VISIBLE);
        Animation animate = AnimationUtils.loadAnimation(getContext(), R.anim.move);
        animate.setDuration(1500);
        animate.setFillAfter(true);
        rl_recyclerView.startAnimation(animate);
    }








}
