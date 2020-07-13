package com.example.jobmanagement.db_repositories.job_profile;

import android.content.Context;
import android.os.AsyncTask;

import com.example.jobmanagement.data_models.JobProfile;
import com.example.jobmanagement.db_operations.Connections;
import com.example.jobmanagement.db_repositories.AsyncTaskCallback;

public class DeleteJobProfileAsync extends AsyncTask<Integer, Void, JobProfile>
{
    private Context context;
    private AsyncTaskCallback<JobProfile> callback;
    private Exception exception;
    private JobProfile jobProfile;
    private long id;

    public DeleteJobProfileAsync (long id, Context context, AsyncTaskCallback<JobProfile> callback)
    {
        this.context = context;
        this.callback = callback;
        this.id = id;
    }

    @Override
    protected JobProfile doInBackground(Integer... integers) {

        exception = null;

        try
        {
            Connections.getInstance(context).getDatabase().getJobProfileDAO().delete(this.id);
        }
        catch (Exception e)
        {
            exception = e;
        }

        return this.jobProfile;
    }

    @Override
    protected void onPostExecute(JobProfile jobProfile) {
        super.onPostExecute(jobProfile);

        if (callback != null)
        {
            if (exception == null)
            {
                callback.onSuccess(jobProfile);
            }
            else
            {
                callback.onException(exception);
            }
        }
    }
}