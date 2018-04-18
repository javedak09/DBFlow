package com.example.javedak09.dbflow;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.widget.Toast;

import com.example.javedak09.dbflow.databinding.ActivityUserEntryBinding;

public class UserEntry extends Activity {

    ActivityUserEntryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_user_entry);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_entry);
        binding.setCallback(this);
    }

    public void SaveData() {
        UsersTable user = new UsersTable();
        user.setUserName(binding.UserName.getText().toString());
        user.save();

        Toast.makeText(this, "Record saved", Toast.LENGTH_LONG).show();
    }
}