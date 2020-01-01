package com.mpssdi.test.repository.local.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mpssdi.test.repository.local.entity.MachineResult;

import java.util.ArrayList;
import java.util.List;


public class MainObject {
    @SerializedName("results")
    @Expose
    private List<MachineResult> results = new ArrayList<>();
   // private  MachineResult[] results;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<MachineResult> getResults() {
        return results;
    }

    public void setResults(List<MachineResult> results) {
        this.results = results;
    }
}
