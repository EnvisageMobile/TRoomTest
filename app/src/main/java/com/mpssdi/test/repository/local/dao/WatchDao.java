package com.mpssdi.test.repository.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.mpssdi.test.repository.local.entity.Watch;

import java.util.List;
@Dao
public interface WatchDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Watch> watch);


    @Query("DELETE FROM watch")
    void deleteAll();


    @Query("SELECT * FROM watch")
   List<Watch> getAllWatch();





}
