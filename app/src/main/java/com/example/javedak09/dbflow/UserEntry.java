package com.example.javedak09.dbflow;

import android.app.Activity;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.example.javedak09.dbflow.databinding.ActivityUserEntryBinding;
import com.raizlabs.android.dbflow.config.DatabaseConfig;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.QueryBuilder;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.Where;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;

import java.util.List;

import static android.content.ContentValues.TAG;

public class UserEntry extends Activity {

    int count = 0;

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
        user.insert();

        Toast.makeText(this, "Record saved", Toast.LENGTH_LONG).show();
    }

    public void GetData() {

        binding.UserName.setText("");

        List<UsersTable> lst = SQLite.select().from(UsersTable.class).queryList();

        if (count < lst.size()) {
            binding.UserName.setText(lst.get(count).UserName);
            Log.d(TAG, "GetData: " + lst.get(count).UserName);
            count++;
        }

    }

}