package com.example.jobmanagement.db_repositories.job_advert;

import android.content.Context;
import android.os.AsyncTask;

import com.example.jobmanagement.data_models.JobAdvert;
import com.example.jobmanagement.data_models.JobProfile;
import com.example.jobmanagement.db_operations.Connections;
import com.example.jobmanagement.db_repositories.AsyncTaskCallback;

public class InsertJobAdvertAsync extends AsyncTask<Integer, Void, JobAdvert>
{
    private Context context;
    private AsyncTaskCallback<JobAdvert> callback;
    private Exception exception;
    private JobAdvert jobAdvert;

    public InsertJobAdvertAsync (JobAdvert jobAdvert, Context context, AsyncTaskCallback<JobAdvert> callback)
    {
        this.context = context;
        this.callback = callback;
        this.jobAdvert = jobAdvert;
    }

    @Override
    protected JobAdvert doInBackground(Integer... integers) {

        exception = null;

        try
        {
            JobProfile jobProfile = Connections.getInstance(context).getDatabase().getJobProfileDAO().getJobProfileById(this.jobAdvert.getId());

            if(jobProfile == null)
            {
                Connections.getInstance(context).getDatabase().getJobAdvertDAO().insert(this.jobAdvert);
            }
            else
            {
                throw new Exception("Job Advert already exists");
            }
        }
        catch (Exception e)
        {
            exception = e;
        }

        return this.jobAdvert;
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