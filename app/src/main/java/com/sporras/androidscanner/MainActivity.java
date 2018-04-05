package com.sporras.androidscanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public void onPostResume() {
        super.onPostResume();
        // Add observers
        ObservableObject.getInstance().addObserver(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Remove observers
        ObservableObject.getInstance().deleteObserver(this);

    }

    @Override
    public void update(Observable observable, Object data) {
        // Use the data coming from the scanner here:
        // (prefix and suffix in the barcode are helpful for if statements)
        Toast.makeText(this, String.valueOf("" + data), Toast.LENGTH_SHORT).show();

        TextView loginText = findViewById(R.id.textView);
        loginText.setText(String.valueOf("" + data));
    }

    ///////////////////////////////////////For testing purposes //////////////////////////////////////////////
    public void sendMessage(View view) {
        // This function simulates an intent wedge that is created by the android scanners.
        Intent intent = new Intent();
        intent.setAction("com.datalogic.decodewedge.decode_action");
        intent.putExtra("com.datalogic.decode.intentwedge.barcode_string","BarCode123!");
        sendBroadcast(intent);
    }

}
