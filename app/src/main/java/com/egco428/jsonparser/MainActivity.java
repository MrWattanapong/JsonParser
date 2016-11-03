package com.egco428.jsonparser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private String url1 = "http://api.openweathermap.org/data/2.5/weather?q=";
    private String url2 = "&appid=08c759e9e3650bd2832ba355547a18f0";
    private EditText location,country,temperature,humidity,pressure;
    private JsonParser obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        location = (EditText)findViewById(R.id.locInput);
        country = (EditText)findViewById(R.id.countryTxt);
        temperature = (EditText)findViewById(R.id.tempTxt);
        humidity = (EditText)findViewById(R.id.humidityTxt);
        pressure = (EditText)findViewById(R.id.pressureTxt);

    }

    public void openWeatherMethod(View view){
        String url = location.getText().toString();
        String finalUrl = url1 + url + url2;
        

        obj = new JsonParser(finalUrl);
        obj.fetchJSON();
        while (obj.parsingComplete);
        country.setText(obj.getCountry());
        temperature.setText(obj.getTemperature());
        humidity.setText(obj.getHumidity());
        pressure.setText(obj.getPressure());

    }
}
