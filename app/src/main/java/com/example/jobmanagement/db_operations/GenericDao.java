package com.example.jobmanagement.db_operations;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


//yes, all else has
@Dao
public interface GenericDao<T> {
    @Insert
    void insert (T object);

    @Delete
    void delete (T object);

    @Update
    void update (T object);

}
