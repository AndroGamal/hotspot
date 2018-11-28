package com.example.andro.hotspotandro;


import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {
    WifiManager m;
    WifiConfiguration myConfig = new WifiConfiguration();
    Method method=null;
    EditText g;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        m = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        Button r=findViewById(R.id.button);
        Button button=findViewById(R.id.button2);
        g=findViewById(R.id.editText);
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m.setWifiEnabled(false);

                myConfig.SSID = g.getText().toString();
                myConfig.preSharedKey="jojojojo";
                myConfig.allowedKeyManagement.set(4);
                myConfig.allowedAuthAlgorithms.set(WifiConfiguration.AuthAlgorithm.SHARED);
                try {
                    method = m.getClass().getMethod("setWifiApEnabled", WifiConfiguration.class, boolean.class);
                method.invoke(m, myConfig, true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,myConfig.preSharedKey  , Toast.LENGTH_SHORT).show();
            }
        });
    }
}