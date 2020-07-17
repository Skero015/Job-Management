package com.example.jobmanagement.data_models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity (tableName = "Job Application", primaryKeys = {"jobId","profileId"})
public class JobApplication {

    @ForeignKey(entity = JobAdvert.class ,
        parentColumns = "jobId",
            childColumns = "jobId",
            onDelete = ForeignKey.CASCADE)
    @ColumnInfo(name = "jobId")
    @NonNull
    private Long jobId;

    @ForeignKey(entity = JobAdvert.class ,
            parentColumns = "profileId",
            childColumns = "profileId",
            onDelete = ForeignKey.CASCADE)
    @ColumnInfo(name = "profileId")
    @NonNull
    private Long profileId;

    @NonNull
    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long advertId) {
        this.jobId = advertId;
    }

    @NonNull
    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }
}
