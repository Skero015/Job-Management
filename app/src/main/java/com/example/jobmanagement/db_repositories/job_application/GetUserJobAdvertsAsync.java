package com.example.jobmanagement.db_repositories.job_application;

import android.content.Context;
import android.os.AsyncTask;

import com.example.jobmanagement.data_models.JobAdvert;
import com.example.jobmanagement.data_models.JobApplication;
import com.example.jobmanagement.db_operations.Connections;
import com.example.jobmanagement.db_repositories.AsyncTaskCallback;

import java.util.List;

public class GetUserJobAdvertsAsync extends AsyncTask<Integer, Void, List<JobAdvert>>
{
    private Context context;
    private AsyncTaskCallback<List<JobAdvert>> callback;
    private Exception exception;
    private Long profileId;

    public GetUserJobAdvertsAsync (Long profileId,Context context, AsyncTaskCallback<List<JobAdvert>> callback)
    {
        this.context = context;
        this.callback = callback;
        this.profileId = profileId;
    }

    @Override
    protected List<JobAdvert> doInBackground(Integer... integers) {

        exception = null;

        List<JobAdvert> jobApplication = null;

        try
        {
            jobApplication = Connections.getInstance(context).getDatabase().getJobApplicationDAO().getUserAppliedJobAdverts(this.profileId);

            if(jobApplication == null)
            {
                throw new Exception("Job Advert does not exists");
            }
        }
        catch (Exception e)
        {
            exception = e;
        }

        return jobApplication;
    }

    @Override
    protected void onPostExecute(List<JobAdvert> jobApplications) {
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