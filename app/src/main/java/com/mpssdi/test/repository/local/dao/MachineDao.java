package com.mpssdi.test.repository.local.dao;

import androidx.room.Dao;

import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.mpssdi.test.repository.local.entity.MachineResult;
import com.mpssdi.test.repository.local.entity.MachineWatch;

import java.util.List;

@Dao
public interface MachineDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<MachineResult> machineResult);

    @Query("SELECT watch.*, machine_table.* FROM machine_table INNER JOIN Watch ON Watch.Wid = machine_table.id")
    List<MachineWatch> findAllGroupAndField();


}
