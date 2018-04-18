package com.example.javedak09.dbflow;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = TestDBFlow.class)
public class UsersTable extends BaseModel {

    @Column
    @PrimaryKey(autoincrement = true)
    long id;

    @Column
    String UserName;

    @Column
    String UserStatus;

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public void setUserStatus(String UserStatus) {
        this.UserStatus = UserStatus;
    }
}