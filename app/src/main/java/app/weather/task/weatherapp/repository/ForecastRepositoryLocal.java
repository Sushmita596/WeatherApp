package app.weather.task.weatherapp.repository;/*
package apixu.weather.location.weatherapixu.data.repository;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Transformations;

import javax.inject.Inject;

import apixu.weather.location.weatherapixu.data.model.ForecastResponse;
import apixu.weather.location.weatherapixu.data.repository.callInterface.ForecastLocalCallInterface;


public class ForecastRepositoryLocal implements ForecastLocalCallInterface {

    private final ForecastDao forecastDao;

    @Inject
    public ForecastRepositoryLocal(ForecastDao forecastDao) {
        this.forecastDao = forecastDao;
    }



    @Override
    public LiveData<ForecastResponse> searchForecast(String city) {
        return Transformations.map(forecastDao.getForecast(city), new Function<ForecastResponse, ForecastResponse>() {
            @Override
            public ForecastResponse apply(ForecastResponse input) {
                if (input != null) {
                    return input;
                } else {
                    return null;
                }
            }
        });
    }
}
*/
