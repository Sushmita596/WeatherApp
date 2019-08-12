package app.weather.task.weatherapp.dagger.module;/*
package apixu.weather.location.weatherapixu.dagger.module;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import javax.inject.Singleton;

import apixu.weather.location.weatherapixu.data.localDB.ForecastDao;
import apixu.weather.location.weatherapixu.data.localDB.ForecastRoomDatabase;
import dagger.Module;
import dagger.Provides;
@Module
public class RoomModule {

    private final ForecastRoomDatabase database;

    public RoomModule(Application application) {
        database = Room.databaseBuilder(application, ForecastRoomDatabase.class, "forecast_database")
                .build();
    }

    @Provides
    @Singleton
    public ForecastRoomDatabase providesForecastRoomDatabase(Context context) {
        return database;
    }

    @Singleton
    @Provides
    public ForecastDao providesForecastDao(ForecastRoomDatabase  forecastRoomDatabase) {
        return forecastRoomDatabase.forecastDao();
    }
}
*/
