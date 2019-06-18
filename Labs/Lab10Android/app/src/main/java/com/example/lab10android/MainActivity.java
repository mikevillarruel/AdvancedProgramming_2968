package com.example.lab10android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText num;
    EditText exp;
    TextView resul;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num = (EditText) findViewById(R.id.num);
        exp = (EditText) findViewById(R.id.exp);
        resul = (TextView) findViewById(R.id.res);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(num.getText().toString() != null && exp.getText().toString()!=null){
                    Float nu = Float.parseFloat(num.getText().toString());
                    Float ex = Float.parseFloat(exp.getText().toString());
                    Double res = Math.pow(nu,ex);
                    resul.setText("Result: " + res);

                }
                else {
                    Toast.makeText(getApplicationContext(),"ERROR :(",Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}
