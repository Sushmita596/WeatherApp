package app.weather.task.weatherapp.data.localDB;/*

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;


@Dao
public interface ForecastDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Forecast forecastResponse);

    @Query("DELETE FROM forecast_table")
    void deleteAll();

    @Query("SELECT * from forecast_table WHERE date LIKE :date")
    LiveData<Forecast> getForecast(String date);
}
*/
