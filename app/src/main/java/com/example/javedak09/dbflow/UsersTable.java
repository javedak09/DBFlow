package com.example.javedak09.dbflow;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ConflictAction;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.annotation.Unique;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = TestDBFlow.class, insertConflict = ConflictAction.REPLACE)
public class UsersTable extends BaseModel {

    @Column
    @PrimaryKey(autoincrement = true)
    int id;

    @Column
    String UserName;

    @Column
    String UserStatus;

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getUserName() {
        return this.UserName;
    }

    public void setUserStatus(String UserStatus) {
        this.UserStatus = UserStatus;
    }
}