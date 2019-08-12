package app.weather.task.weatherapp.data.repository.callInterface;

import android.arch.lifecycle.LiveData;

import app.weather.task.weatherapp.data.model.ForecastResponse;


public interface ForecastLocalCallInterface {
    LiveData<ForecastResponse> searchForecast(String city);
}
