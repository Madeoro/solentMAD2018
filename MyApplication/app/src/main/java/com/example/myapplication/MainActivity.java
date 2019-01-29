package com.example.myapplication;

import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MapView mv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // This line sets the user agent, a requirement to download OSM maps
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));

        setContentView(R.layout.activity_main);

        mv = findViewById(R.id.map1);


        mv.setBuiltInZoomControls(true);
        mv.getController().setZoom(16);
       // mv.getController().setCenter(new GeoPoint(51.05,-0.72));

        Button b = findViewById(R.id.btn1);
        b.setOnClickListener(this);

        mv.setClickable(true);
    }
    public void onClick(View view)
    {
        TextView tv = findViewById(R.id.tv);
        TextView tvv = findViewById(R.id.tv1);
        EditText et = findViewById(R.id.et);
        EditText et1 = findViewById(R.id.et1);


        double lati = 0.0;
        double longi = 0.0;
        String value = et.getText().toString();
        String value2 = et1.getText().toString();




        if(Double.parseDouble(value) > 90 || Double.parseDouble(value) < -90 || Double.parseDouble(value2) > 180 || Double.parseDouble(value2) < -180)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Error")
                    .setMessage("ERROR!")
                    .setNeutralButton("OK", null);

            AlertDialog dialog = builder.create();
            dialog.show();
        }

        else if(value == "" || value2 == "" )
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Error")
                    .setMessage("ERROR!")
                    .setNeutralButton("OK", null);

            AlertDialog dialog = builder.create();
            dialog.show();
        }

        else
        {
            lati = Double.parseDouble(value);

            longi = Double.parseDouble(value2);


            mv.getController().setCenter(new GeoPoint(lati,longi));
        }

    }

}
