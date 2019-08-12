package app.weather.task.weatherapp.data.rest;
 ;
import app.weather.task.weatherapp.data.model.ForecastResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;



public interface ApiCallInterface {

    @GET(ApiUrls.REPO)
    Call<ForecastResponse> getForecast(@Query("key") String key, @Query("q") String city, @Query("days") int days);
}
