package com.mpssdi.test.ui;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import com.google.gson.Gson;
import com.mpssdi.test.repository.local.entity.MachineResult;
import com.mpssdi.test.repository.local.entity.MachineWatch;
import com.mpssdi.test.repository.local.entity.Watch;
import com.mpssdi.test.repository.local.model.BaseWatch;
import com.mpssdi.test.repository.local.model.MainObject;
import com.mpssdi.test.repository.WearMachineRepository;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MainActivityViewmodel extends AndroidViewModel {

    private WearMachineRepository repository;

    private final static String JSON_FILE_ANDROID_WEAR = "androidwear.json";
    private final static String JSON_FILE_MACHINE ="machine.json";

    MainActivityViewmodel(@NonNull Application application) {
        super(application);
        repository = new WearMachineRepository(application);

    }

    void insertWatch() {
        repository.insert(getWatchData());
        repository.insertMachine(getMatchineTestData());
    }


    List<MachineWatch> getMachineWatchInfo() {
        return repository.fetchMachineWatch();
    }

    private List<Watch> getWatchData() {
        String jsonString = getAssetsJSON(JSON_FILE_ANDROID_WEAR);
        Gson gson = new Gson();
        BaseWatch baseWatch = gson.fromJson(jsonString, BaseWatch.class);
        return baseWatch.getWatches();
    }

    private List<MachineResult> getMatchineTestData() {
        String jsonString = getAssetsJSON(JSON_FILE_MACHINE);
        Gson gson = new Gson();
        MainObject mainObject = gson.fromJson(jsonString, MainObject.class);
        return mainObject.getResults();
    }

    private String getAssetsJSON(String fileName) {
        String json = null;
        try {
            InputStream inputStream = getApplication().getAssets().open(fileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }


}
