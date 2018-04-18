package com.example.javedak09.dbflow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

public class MainActivity extends Activity {

    Button btnAddRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FlowManager.init(new FlowConfig.Builder(this).build());

        btnAddRecord = (Button) findViewById(R.id.btnAddRecord);

        btnAddRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, UserEntry.class);
                startActivity(intent);
            }
        });

    }
}