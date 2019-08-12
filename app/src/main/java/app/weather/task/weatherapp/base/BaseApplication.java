package app.weather.task.weatherapp.base;


import android.app.Application;

import app.weather.task.weatherapp.dagger.component.AppComponent;
import app.weather.task.weatherapp.dagger.component.DaggerAppComponent;
import app.weather.task.weatherapp.dagger.module.AppModule;



public class BaseApplication  extends Application {
    private AppComponent appComponent;

    /*@Inject
    ForecastDao forecastDao;*/
/*.roomModule(new RoomModule(this))*/
    @Override
    public void onCreate() {
        super.onCreate();
        this.appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))

                .build();

        appComponent.inject(this);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

}
