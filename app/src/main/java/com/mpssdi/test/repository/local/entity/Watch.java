package com.mpssdi.test.repository.local.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "watch")
public class Watch {
    @PrimaryKey(autoGenerate = true)
    private int Wid;

    @SerializedName("Wname")
    @Expose
    private String Wname;
    @SerializedName("price")
    @Expose
    private String price;

    public int getId() {
        return Wid;
    }

    public void setId(int id) {
        this.Wid = id;
    }

    public int getWid() {
        return Wid;
    }

    public void setWid(int wid) {
        Wid = wid;
    }

    public String getName() {
        return Wname;
    }

    public void setName(String name) {
        this.Wname = name;
    }

    public String getWname() {
        return Wname;
    }

    public void setWname(String wname) {
        Wname = wname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
