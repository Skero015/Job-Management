package com.example.jobmanagement.db_operations;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Query;

import com.example.jobmanagement.data_models.JobAdvert;
import com.example.jobmanagement.data_models.JobApplication;
import com.example.jobmanagement.data_models.JobProfile;

import java.util.List;

@Dao
public interface JobApplicationDao extends GenericDao{

    @Query("DELETE FROM `Job Application` WHERE jobId = :id")
    void delete(long id, long applicationId);

    @Query("SELECT * FROM `Job Application`")
    List<JobApplication> getAllJobApplications();
    @Query("SELECT * FROM `Job Application` WHERE profileId = :profileId")
    List<JobApplication> getUserApplications(long profileId);
    @Query("SELECT * FROM `Job Application` WHERE jobId = :jobId AND profileId = :profileId")
    JobApplication findByJobIdAndUserId(long jobId, long profileId);
    @Query("SELECT * FROM `Job Advert` WHERE id = :profileId")
    List<JobAdvert> getUserAppliedJobAdverts(long profileId);
}
