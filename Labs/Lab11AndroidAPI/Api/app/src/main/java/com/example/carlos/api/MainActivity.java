package com.example.carlos.api;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText txtId;
    TextView txtL;
    TextView txtI;
    Button btnS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtId = (EditText)  findViewById(R.id.txtId);
        txtL = (TextView)  findViewById(R.id.txtLastName);
        txtI = (TextView)  findViewById(R.id.txtIde);

        btnS = (Button)  findViewById(R.id.btnBusc);

        btnS.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String sql = "http://10.40.76.143:8085/Servigruas/service/operator/getOperator/" + txtId.getText().toString();
                getData(sql);

            }
        });

    }

    public void getData(String sql){


        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        URL url = null;
        HttpURLConnection conn;

        try {
            url = new URL(sql);
            conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            conn.connect();
            //Obtiene los datos
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String inputLine;

            StringBuffer response = new StringBuffer();

            String json = "";

            //Recorre datos que obtiene
            while((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }

            json = response.toString();

            JSONObject jsonObject =  new JSONObject(json);
            Log.e("SALIDA",json);

            if(json.equals("{}")) {
                Toast.makeText(getApplicationContext(), "NOT FOUND :(", Toast.LENGTH_SHORT).show();
                txtL.setText("");
                txtI.setText("");
            } else {
                txtL.setText("LAST NAME: " + jsonObject.optString("operatorname"));
                txtI.setText("ID: " + jsonObject.optString("operatorid"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
