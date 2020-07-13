package com.example.jobmanagement.db_repositories.job_application;

import android.content.Context;
import android.os.AsyncTask;

import com.example.jobmanagement.data_models.JobApplication;
import com.example.jobmanagement.data_models.JobProfile;
import com.example.jobmanagement.db_operations.Connections;
import com.example.jobmanagement.db_repositories.AsyncTaskCallback;

import java.util.List;

public class GetAllApplicationsAsync extends AsyncTask<Integer, Void, List<JobApplication>>
{
    private Context context;
    private AsyncTaskCallback<List<JobApplication>> callback;
    private Exception exception;
    private JobApplication jobApplication;

    public GetAllApplicationsAsync (JobApplication jobApplication, Context context, AsyncTaskCallback<List<JobApplication>> callback)
    {
        this.context = context;
        this.callback = callback;
        this.jobApplication = jobApplication;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<JobApplication> doInBackground(Integer... integers) {

        exception = null;
        List<JobApplication> jobApplications = null;

        try
        {
            jobApplications = Connections.getInstance(this.context).getDatabase().getJobApplicationDAO().getAllJobApplications();

            if(jobApplications.size() == 0)
            {
                throw  new Exception("No data found");
            }
        }
        catch (Exception e)
        {
            exception = e;
        }

        return jobApplications;
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