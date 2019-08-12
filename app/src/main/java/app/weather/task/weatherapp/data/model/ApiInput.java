package app.weather.task.weatherapp.data.model;

public class ApiInput {

    public final String key;
    public final String latitude;
    public final String longitude;
    public final int days;

    public ApiInput(String key, String latitude, String longitude, int days) {
        this.key = key;
        this.latitude = latitude;
        this.longitude=longitude;
        this.days =days;
    }
}
