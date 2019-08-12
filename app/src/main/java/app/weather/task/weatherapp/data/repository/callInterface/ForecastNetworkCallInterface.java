package app.weather.task.weatherapp.data.repository.callInterface;

import android.arch.lifecycle.LiveData;

import app.weather.task.weatherapp.data.model.ForecastResponse;


public interface ForecastNetworkCallInterface {
    LiveData<ForecastResponse> getForecast(String apiKey, String latitudelongitude, int days);
}
