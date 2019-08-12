package app.weather.task.weatherapp.util;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class GeoCodeUtils {

    private Geocoder geocoder_;

    public GeoCodeUtils(Context context){ geocoder_ = new Geocoder(context, Locale.getDefault());}

    public String getCity(String latitude, String longitude) throws IOException{
        List<Address> addressList = geocoder_.getFromLocation(Double.valueOf(latitude),Double.valueOf(longitude),1);
        return addressList.get(0).getLocality();
    }


}
