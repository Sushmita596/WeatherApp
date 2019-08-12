package app.weather.task.weatherapp.dagger.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import app.weather.task.weatherapp.data.repository.callInterface.ForecastNetworkCallInterface;
import app.weather.task.weatherapp.data.rest.ApiCallInterface;
import app.weather.task.weatherapp.data.rest.ApiUrls;
import app.weather.task.weatherapp.repository.ForecastRepositoryNetwork;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



@Module
public class AppModule {

    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    public Context providesAppContext() {
        return application;
    }

    @Provides
    @Singleton
    public ApiCallInterface providesRetrofitApi() {
        return new Retrofit.Builder()
                .baseUrl(ApiUrls.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiCallInterface.class);
    }

    @Provides
    @Singleton
    public ForecastNetworkCallInterface providesForecastNetworkCallInterface(ApiCallInterface  apiCallInterface) {
        return new ForecastRepositoryNetwork(apiCallInterface);
    }
}
