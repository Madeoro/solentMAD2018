package uk.ac.solent.myapplication;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.MenuItem;

import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

public class MainActivity extends AppCompatActivity {
    MapView mv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));

        setContentView(R.layout.activity_main);

        mv = findViewById(R.id.map1);


        mv.setBuiltInZoomControls(true);
        mv.getController().setZoom(16);
        mv.getController().setCenter(new GeoPoint(51.05,-0.72));

        Button b = findViewById(R.id.btn1);
        mv.setClickable(true);
    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId() == R.id.setlocation) {
            Intent intent = new Intent(this, SetLocation.class);
            startActivityIfNeeded(intent, 1);
            return true;
        }

        return false;
    }

    protected  void onActivityResult (int requestCode, int resultCode, Intent intent){

      if (requestCode == 1 ){

            if (resultCode == RESULT_OK){
                Bundle extras = intent.getExtras();
                double lati = extras.getDouble("lati");
                double longi = extras.getDouble("longi");
                mv.getController().setCenter(new GeoPoint(lati,longi));
            }
        }


    }

}
