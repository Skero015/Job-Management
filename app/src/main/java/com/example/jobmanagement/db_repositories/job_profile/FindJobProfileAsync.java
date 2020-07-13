package com.example.jobmanagement.db_repositories.job_profile;

import android.content.Context;
import android.os.AsyncTask;

import com.example.jobmanagement.data_models.JobProfile;
import com.example.jobmanagement.db_operations.Connections;
import com.example.jobmanagement.db_repositories.AsyncTaskCallback;

public class FindJobProfileAsync extends AsyncTask<Integer, Void, JobProfile>
{
    private Context context;
    private AsyncTaskCallback<JobProfile> callback;
    private Exception exception;
    private Long id;

    public FindJobProfileAsync (Long id, Context context, AsyncTaskCallback<JobProfile> callback)
    {
        this.context = context;
        this.callback = callback;
        this.id = id;
    }

    @Override
    protected JobProfile doInBackground(Integer... integers) {

        exception = null;

        JobProfile jobProfile = null;

        try
        {
            jobProfile = Connections.getInstance(context).getDatabase().getJobProfileDAO().getJobProfileById(this.id);

            if(jobProfile == null)
            {
                throw new Exception("Job Profile does not exists");
            }
        }
        catch (Exception e)
        {
            exception = e;
        }

        return jobProfile;
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
