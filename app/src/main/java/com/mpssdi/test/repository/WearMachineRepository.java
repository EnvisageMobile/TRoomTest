package com.mpssdi.test.repository;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.mpssdi.test.repository.local.entity.MachineResult;
import com.mpssdi.test.repository.local.entity.MachineWatch;
import com.mpssdi.test.repository.local.WearMachineDatabase;
import com.mpssdi.test.repository.local.dao.MachineDao;
import com.mpssdi.test.repository.local.dao.WatchDao;
import com.mpssdi.test.repository.local.entity.Watch;

import java.util.List;

public class WearMachineRepository {

    private WatchDao watchDao;
    private MachineDao machineDao;


    public WearMachineRepository(Application application) {
        WearMachineDatabase database = WearMachineDatabase.getInstance(application);
        watchDao = database.watchDao();
        machineDao = database.machineDao();

    }
    // insert watch data
    public void insert(List<Watch> watch) {
        new InsertWatch(watchDao).execute(watch);
    }

    private static class InsertWatch extends AsyncTask<List<Watch>, Void, Void> {
        private WatchDao watchDao;

        private InsertWatch(WatchDao watchDao) {
            this.watchDao = watchDao;
        }

        @Override
        protected Void doInBackground(List<Watch>... watches) {
            watchDao.insert(watches[0]);
            return null;
        }


    }



    //insert machine data
    public void insertMachine(List<MachineResult> machineResults) {
        new InsertMachineTask(machineDao).execute(machineResults);
    }
    private static class InsertMachineTask extends AsyncTask<List<MachineResult>, Void, Void> {
        private MachineDao machineDao;

        private InsertMachineTask(MachineDao machineDao) {
            this.machineDao = machineDao;
        }

        @Override
        protected Void doInBackground(List<MachineResult>... machine) {
            machineDao.insert(machine[0]);
            return null;
        }


    }


    //fetch machine and watch data
    public List<MachineWatch> fetchMachineWatch() {
        try {
            return new FetchMachineDataTask(machineDao).execute().get();
        } catch (Exception e) {
            return null;
        }

    }

    private class FetchMachineDataTask extends AsyncTask<Void, Void, List<MachineWatch>> {
        private MachineDao machineDao;



        public FetchMachineDataTask(MachineDao machineDao) {
            this.machineDao = machineDao;
        }


        @Override
        protected List<MachineWatch> doInBackground(Void... voids) {

            return machineDao.findAllGroupAndField();
        }


    }
}
