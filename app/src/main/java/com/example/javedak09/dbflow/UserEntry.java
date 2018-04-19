package com.example.javedak09.dbflow;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.widget.Toast;

import com.example.javedak09.dbflow.databinding.ActivityUserEntryBinding;
import com.raizlabs.android.dbflow.config.DatabaseConfig;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

public class UserEntry extends Activity {

    ActivityUserEntryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_user_entry);

        //FlowManager.init(new FlowConfig.Builder(this).build());

        FlowManager.init(FlowConfig.builder(this)
                .addDatabaseConfig(DatabaseConfig.builder(TestDBFlow.class)
                        .databaseName("AppDatabase")
                        .build())
                .build());


        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_entry);
        binding.setCallback(this);
    }

    public void SaveData() {
        UsersTable user = new UsersTable();
        user.setUserName(binding.UserName.getText().toString());
        user.save();

        FlowManager.getModelAdapter(UsersTable.class).insert(user);

        Toast.makeText(this, "Record saved", Toast.LENGTH_LONG).show();
    }
}