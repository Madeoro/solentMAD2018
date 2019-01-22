package com.fran.feettometersactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;



public class MainActivity extends AppCompatActivity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = (Button)findViewById(R.id.btn1);
        b.setOnClickListener(this);
    }

    public void onClick(View view)
    {
        TextView tv = (TextView)findViewById(R.id.tv1);
        TextView tvv = (TextView)findViewById(R.id.tv2);
        TextView tvvv = (TextView)findViewById(R.id.tv3);
        EditText et = (EditText)findViewById(R.id.et1);
        double feet = Double.parseDouble(et.getText().toString());
        double metres = feet*0.305;
        tvvv.setText(String.valueOf(metres));
    }
}
