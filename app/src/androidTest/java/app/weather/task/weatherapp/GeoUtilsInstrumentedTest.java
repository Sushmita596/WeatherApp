package app.weather.task.weatherapp;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import app.weather.task.weatherapp.util.GeoCodeUtils;

import static junit.framework.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class GeoUtilsInstrumentedTest {


    private GeoCodeUtils geoCodeUtils;

    @Before
    public void setUp(){
        Context context = InstrumentationRegistry.getContext();
        geoCodeUtils = new GeoCodeUtils(context);
    }

    @Test
    public void testAddressCodeShouldFail() throws Exception{

        String city= geoCodeUtils.getCity("0","0");
        assertEquals("0",city);

    }
}
