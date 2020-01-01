package com.mpssdi.test.repository.local.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;


@Entity(tableName = "machine_table",
        foreignKeys = @ForeignKey(entity = Watch.class,
                parentColumns = "Wid",
                childColumns = "id",
                onDelete = CASCADE))

public class MachineResult {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String description ;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
