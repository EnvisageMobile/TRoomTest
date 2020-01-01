package com.mpssdi.test.repository.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.mpssdi.test.repository.local.entity.MachineResult;
import com.mpssdi.test.repository.local.dao.MachineDao;
import com.mpssdi.test.repository.local.dao.WatchDao;
import com.mpssdi.test.repository.local.entity.Watch;

@Database(entities = {MachineResult.class, Watch.class}, version = 1,exportSchema = false)
public abstract class WearMachineDatabase extends RoomDatabase {

    private static WearMachineDatabase instance;

    public abstract MachineDao machineDao();
    public abstract WatchDao watchDao();

    public static synchronized WearMachineDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    WearMachineDatabase.class, "wear_machine")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
