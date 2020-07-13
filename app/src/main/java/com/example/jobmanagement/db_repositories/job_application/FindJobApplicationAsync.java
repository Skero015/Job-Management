package com.example.jobmanagement.db_repositories.job_application;

import android.content.Context;
import android.os.AsyncTask;

import com.example.jobmanagement.data_models.JobApplication;
import com.example.jobmanagement.data_models.JobProfile;
import com.example.jobmanagement.db_operations.Connections;
import com.example.jobmanagement.db_repositories.AsyncTaskCallback;

public class FindJobApplicationAsync extends AsyncTask<Integer, Void, JobApplication>
{
    private Context context;
    private AsyncTaskCallback<JobApplication> callback;
    private Exception exception;
    private Long jobId;
    private Long userId;

    public FindJobApplicationAsync (Long jobId, Long profileId,Context context, AsyncTaskCallback<JobApplication> callback)
    {
        this.context = context;
        this.callback = callback;
        this.jobId = jobId;
        this.userId = profileId;
    }

    @Override
    protected JobApplication doInBackground(Integer... integers) {

        exception = null;

        JobApplication jobApplication = null;

        try
        {
            jobApplication = Connections.getInstance(context).getDatabase().getJobApplicationDAO().findByJobIdAndUserId(this.jobId, this.userId);

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