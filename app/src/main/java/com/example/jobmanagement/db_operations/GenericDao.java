package com.example.jobmanagement.db_operations;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface GenericDao<T> {
    @Insert
    void insert (T id);

    @Delete
    void delete (T id);

    @Update
    void update (T id);

}
