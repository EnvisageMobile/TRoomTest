package com.mpssdi.test.repository.local.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mpssdi.test.repository.local.entity.Watch;

import java.util.ArrayList;
import java.util.List;



public class BaseWatch {

    @SerializedName("watches")
    @Expose
    private List<Watch> watches = new ArrayList<>();

    public List<Watch> getWatches() {
        return watches;
    }

    public void setWatches(List<Watch> watches) {
        this.watches = watches;
    }
}
