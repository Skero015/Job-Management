package com.example.jobmanagement.db_repositories.job_advert;

import android.content.Context;
import android.os.AsyncTask;

import com.example.jobmanagement.data_models.JobAdvert;
import com.example.jobmanagement.data_models.JobProfile;
import com.example.jobmanagement.db_operations.Connections;
import com.example.jobmanagement.db_repositories.AsyncTaskCallback;

import java.util.List;

public class GetAllJobAdvertsAsync extends AsyncTask<Integer, Void, List<JobAdvert>>
{
    private Context context;
    private AsyncTaskCallback<List<JobAdvert>> callback;
    private Exception exception;
    private JobAdvert jobAdvert;

    public GetAllJobAdvertsAsync (JobAdvert jobAdvert, Context context, AsyncTaskCallback<List<JobAdvert>> callback)
    {
        this.context = context;
        this.callback = callback;
        this.jobAdvert = jobAdvert;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<JobAdvert> doInBackground(Integer... integers) {

        exception = null;
        List<JobAdvert> jobAdverts = null;

        try
        {
            jobAdverts = Connections.getInstance(this.context).getDatabase().getJobAdvertDAO().getAllJobAdverts();

            if(jobAdverts.size() == 0)
            {
                throw  new Exception("No data found");
            }
        }
        catch (Exception e)
        {
            exception = e;
        }

        return jobAdverts;
    }

    @Override
    protected void onPostExecute(List<JobAdvert> jobAdverts) {
        super.onPostExecute(jobAdverts);

        if (callback != null)
        {
            if (exception == null)
            {
                callback.onSuccess(jobAdverts);
            }
            else
            {
                callback.onException(exception);
            }
        }
    }
}

