package com.example.jobmanagement.db_repositories.job_advert;

import android.content.Context;
import android.os.AsyncTask;

import com.example.jobmanagement.data_models.JobAdvert;
import com.example.jobmanagement.data_models.JobProfile;
import com.example.jobmanagement.db_operations.Connections;
import com.example.jobmanagement.db_repositories.AsyncTaskCallback;

public class FindJobAdvertAsync extends AsyncTask<Integer, Void, JobAdvert>
{
    private Context context;
    private AsyncTaskCallback<JobAdvert> callback;
    private Exception exception;
    private Long id;

    public FindJobAdvertAsync (Long id, Context context, AsyncTaskCallback<JobAdvert> callback)
    {
        this.context = context;
        this.callback = callback;
        this.id = id;
    }

    @Override
    protected JobAdvert doInBackground(Integer... integers) {

        exception = null;

        JobAdvert jobAdvert = null;

        try
        {
            jobAdvert = Connections.getInstance(context).getDatabase().getJobAdvertDAO().getJobAdvertById(this.id);

            if(jobAdvert == null)
            {
                throw new Exception("Job Advert does not exists");
            }
        }
        catch (Exception e)
        {
            exception = e;
        }

        return jobAdvert;
    }

    @Override
    protected void onPostExecute(JobAdvert jobAdvert) {
        super.onPostExecute(jobAdvert);

        if (callback != null)
        {
            if (exception == null)
            {
                callback.onSuccess(jobAdvert);
            }
            else
            {
                callback.onException(exception);
            }
        }
    }
}