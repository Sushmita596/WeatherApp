package app.weather.task.weatherapp.data.model.typeconvertor;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import app.weather.task.weatherapp.data.model.Forecastday;


public class ForecastdayTypeConvertor {


    private static Gson gson = new Gson();

    @TypeConverter
    public static List<Forecastday> stringToSomeObjectList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<Forecastday>>() {}.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String someObjectListToString(List<Forecastday> someObjects) {
        return gson.toJson(someObjects);
    }
}
