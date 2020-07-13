package com.example.jobmanagement.db_repositories.job_application;

import android.content.Context;
import android.os.AsyncTask;

import com.example.jobmanagement.data_models.JobApplication;
import com.example.jobmanagement.db_operations.Connections;
import com.example.jobmanagement.db_repositories.AsyncTaskCallback;

import java.util.List;

public class GetUserApplicationsAsync extends AsyncTask<Integer, Void, List<JobApplication>>
{
    private Context context;
    private AsyncTaskCallback<List<JobApplication>> callback;
    private Exception exception;
    private Long profileId;

    public GetUserApplicationsAsync (Long profileId,Context context, AsyncTaskCallback<List<JobApplication>> callback)
    {
        this.context = context;
        this.callback = callback;
        this.profileId = profileId;
    }

    @Override
    protected List<JobApplication> doInBackground(Integer... integers) {

        exception = null;

        List<JobApplication> jobApplication = null;

        try
        {
            jobApplication = Connections.getInstance(context).getDatabase().getJobApplicationDAO().getUserApplications(this.profileId);

            if(jobApplication == null)
            {
                throw new Exception("Job Application does not exists");
            }
        }
        catch (Exception e)
        {
            exception = e;
        }

        return jobApplication;
    }

    @Override
    protected void onPostExecute(List<JobApplication> jobApplications) {
        super.onPostExecute(jobApplications);

        if (callback != null)
        {
            if (exception == null)
            {
                callback.onSuccess(jobApplications);
            }
            else
            {
                callback.onException(exception);
            }
        }
    }
}