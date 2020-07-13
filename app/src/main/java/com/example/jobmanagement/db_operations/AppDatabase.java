package com.example.jobmanagement.db_operations;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.jobmanagement.data_models.JobAdvert;
import com.example.jobmanagement.data_models.JobApplication;
import com.example.jobmanagement.data_models.JobProfile;

@Database(entities = {JobAdvert.class, JobProfile.class, JobApplication.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract JobAdvertDao getJobAdvertDAO();
    public abstract JobApplicationDao getJobApplicationDAO();
    public abstract JobProfileDao getJobProfileDAO();
}
