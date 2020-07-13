package com.example.jobmanagement.db_operations;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.jobmanagement.data_models.JobAdvert;
import com.example.jobmanagement.data_models.JobProfile;

import java.util.List;

@Dao
public interface JobAdvertDao extends  GenericDao{

    @Query("DELETE FROM `Job Advert` WHERE id = :id")
    void delete(long id);
    @Query("SELECT * FROM `Job Advert`")
    List<JobAdvert> getAllJobAdverts();
    @Query("SELECT * FROM `Job Advert` WHERE id = :id")
    JobAdvert getJobAdvertById(long id);
}
