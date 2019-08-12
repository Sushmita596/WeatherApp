package app.weather.task.weatherapp.ui.forecast;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import app.weather.task.weatherapp.base.BaseApplication;
import app.weather.task.weatherapp.data.model.ApiInput;
import app.weather.task.weatherapp.data.model.ForecastResponse;
import app.weather.task.weatherapp.data.repository.callInterface.ForecastNetworkCallInterface;

/**
 * Created by ${Shiraz}
 */

public class ForecastViewModel extends AndroidViewModel {
    @Inject
    ForecastNetworkCallInterface forecastNetworkCallInterface;


    private MediatorLiveData<ForecastResponse> forecastNetworkLiveData = new MediatorLiveData<>();


    public ForecastViewModel(@NonNull Application application) {
        super(application);
        ((BaseApplication) application).getAppComponent().inject(this);
    }




    public void loadForecast(ApiInput forecast_input_details) {

        String latLong= forecast_input_details.latitude+","+forecast_input_details.longitude;
        final LiveData<ForecastResponse> forecastLiveData = forecastNetworkCallInterface.getForecast(forecast_input_details.key, latLong,forecast_input_details.days);
        forecastNetworkLiveData.addSource(forecastLiveData, new Observer<ForecastResponse>() {

            @Override
            public void onChanged(@Nullable ForecastResponse forecastResponse) {

                forecastNetworkLiveData.setValue(forecastResponse);
                forecastNetworkLiveData.removeSource(forecastLiveData);
            }
        });




    }

    public LiveData<ForecastResponse> getForecastLiveData() {
        return forecastNetworkLiveData;
    }
}
