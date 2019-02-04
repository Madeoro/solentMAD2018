package uk.ac.solent.mapping;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

public class SetLocation extends AppCompatActivity implements View.OnClickListener{
    MapView mv;
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_location);
        Button change = findViewById(R.id.btngo);
        change.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        Intent intent = new Intent();
        Bundle bundle = new Bundle();


       // TextView tv = findViewById(R.id.etgo);
       // TextView tvv = findViewById(R.id.tvgo);
        EditText et = findViewById(R.id.etgo);
        EditText et1 = findViewById(R.id.etgo1);


        double lati = 0.0;
        double longi = 0.0;
        String value = et.getText().toString();
        String value2 = et1.getText().toString();

        if (view.getId() == R.id.btngo) {


            if (Double.parseDouble(value) > 90 || Double.parseDouble(value) < -90 || Double.parseDouble(value2) > 180 || Double.parseDouble(value2) < -180) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Error")
                        .setMessage("ERROR!")
                        .setNeutralButton("OK", null);

                AlertDialog dialog = builder.create();
                dialog.show();
            } else if (value == "" || value2 == "") {
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

            }
            bundle.putDouble("lati", lati);
            bundle.putDouble("longi",longi);
            intent.putExtras(bundle);
            setResult(RESULT_OK,intent);
            finish();

        }
    }
}
