package com.example.jobmanagement.db_operations;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Query;

import com.example.jobmanagement.data_models.JobProfile;

import java.util.List;

@Dao
public interface JobProfileDao extends GenericDao<JobProfile>{

    @Query("DELETE FROM `Job Profile` WHERE id = :id")
    void delete(long id);

    @Query("SELECT * FROM `Job Profile`")
    List<JobProfile> getAllJobProfiles();

    @Query("SELECT * FROM `Job Profile` WHERE id = :id")
    JobProfile getJobProfileById(long id);

    @Query("SELECT * FROM `Job Profile` WHERE email = :email")
    JobProfile getJobProfileByEmail(String email);
}
