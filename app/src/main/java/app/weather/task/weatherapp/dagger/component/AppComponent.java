package app.weather.task.weatherapp.dagger.component;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import app.weather.task.weatherapp.base.BaseApplication;
import app.weather.task.weatherapp.dagger.module.AppModule;
import app.weather.task.weatherapp.ui.forecast.ForecastFragment;
import app.weather.task.weatherapp.ui.forecast.ForecastViewModel;
import dagger.Component;



@Component(modules = AppModule.class)
@Singleton
public abstract class AppComponent {

    public static AppComponent from(@NonNull Context context){
        return ((BaseApplication) context.getApplicationContext()).getAppComponent();
    }

    public abstract void inject(ForecastFragment forecastFragment);

    public abstract void inject(ForecastViewModel forecastViewModel);


    public abstract void inject(BaseApplication baseApplication);
}
