package app.weather.task.weatherapp.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import app.weather.task.weatherapp.data.model.ForecastResponse;
import app.weather.task.weatherapp.data.repository.callInterface.ForecastNetworkCallInterface;
import app.weather.task.weatherapp.data.rest.ApiCallInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class ForecastRepositoryNetwork implements ForecastNetworkCallInterface {

    private final ApiCallInterface apiCallInterface;

    public ForecastRepositoryNetwork(ApiCallInterface apiCallInterface) {
        this.apiCallInterface = apiCallInterface;
    }



    @Override
    public LiveData<ForecastResponse> getForecast(String key, String latLong, int days) {

        final MutableLiveData<ForecastResponse> liveData = new MutableLiveData<>();
        apiCallInterface.getForecast(key, latLong,days).enqueue(new Callback<ForecastResponse>() {
            @Override
            public void onResponse(Call<ForecastResponse> call, Response<ForecastResponse> response) {
                if(response.isSuccessful()){
                    liveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ForecastResponse> call, Throwable t) {
                liveData.setValue(null);

            }
        });
        return liveData;
    }
}
