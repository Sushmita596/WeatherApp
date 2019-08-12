package app.weather.task.weatherapp.data.rest.response;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.io.Serializable;

import app.weather.task.weatherapp.data.model.ForecastResponse;

import static app.weather.task.weatherapp.data.rest.response.Status.ERROR;
import static app.weather.task.weatherapp.data.rest.response.Status.LOADING;
import static app.weather.task.weatherapp.data.rest.response.Status.SUCCESS;


public class ApiResponse implements Serializable {

    public final Status status;

    @Nullable
    public final ForecastResponse data;

    @Nullable
    public final Throwable error;

    private ApiResponse(Status status, @Nullable ForecastResponse data, @Nullable Throwable error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public static ApiResponse loading() {
        return new ApiResponse(LOADING, null, null);
    }

    public static ApiResponse success(@NonNull ForecastResponse data) {
        return new ApiResponse(SUCCESS, data, null);
    }

    public static ApiResponse error(@NonNull Throwable error) {
        return new ApiResponse(ERROR, null, error);
    }

}
