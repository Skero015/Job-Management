package com.example.jobmanagement.db_repositories.job_application;

import android.content.Context;
import android.os.AsyncTask;

import com.example.jobmanagement.data_models.JobApplication;
import com.example.jobmanagement.data_models.JobProfile;
import com.example.jobmanagement.db_operations.Connections;
import com.example.jobmanagement.db_repositories.AsyncTaskCallback;

public class InsertJobApplicationAsync extends AsyncTask<Integer, Void, JobApplication>
{
    private Context context;
    private AsyncTaskCallback<JobApplication> callback;
    private Exception exception;
    private JobApplication jobApplication;

    public InsertJobApplicationAsync (JobApplication jobApplication, Context context, AsyncTaskCallback<JobApplication> callback)
    {
        this.context = context;
        this.callback = callback;
        this.jobApplication = jobApplication;
    }

    @Override
    protected JobApplication doInBackground(Integer... integers) {

        exception = null;

        try
        {
            JobProfile jobProfile = Connections.getInstance(context).getDatabase().getJobProfileDAO().getJobProfileById(this.jobApplication.getProfileId());

            if(jobApplication == null)
            {
                Connections.getInstance(context).getDatabase().getJobApplicationDAO().insert(this.jobApplication);
            }
            else
            {
                throw new Exception("Job Application already exists");
            }
        }
        catch (Exception e)
        {
            exception = e;
        }

        return this.jobApplication;
    }

    @Override
    protected void onPostExecute(JobApplication jobApplication) {
        super.onPostExecute(jobApplication);

        if (callback != null)
        {
            if (exception == null)
            {
                callback.onSuccess(jobApplication);
            }
            else
            {
                callback.onException(exception);
            }
        }
    }
}