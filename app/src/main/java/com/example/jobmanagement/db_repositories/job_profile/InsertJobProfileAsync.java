package com.example.jobmanagement.db_repositories.job_profile;

import android.content.Context;
import android.os.AsyncTask;

import com.example.jobmanagement.data_models.JobProfile;
import com.example.jobmanagement.db_operations.Connections;
import com.example.jobmanagement.db_repositories.AsyncTaskCallback;

public class InsertJobProfileAsync extends AsyncTask<Integer, Void, JobProfile>
{
    private Context context;
    private AsyncTaskCallback<JobProfile> callback;
    private Exception exception;
    private JobProfile jobProfile;

    public InsertJobProfileAsync (JobProfile jobProfile, Context context, AsyncTaskCallback<JobProfile> callback)
    {
        this.context = context;
        this.callback = callback;
        this.jobProfile = jobProfile;
    }

    @Override
    protected JobProfile doInBackground(Integer... integers) {

        exception = null;

        try
        {
            JobProfile jobProfile = Connections.getInstance(context).getDatabase().getJobProfileDAO().getJobProfileById(this.jobProfile.getId());

            if(jobProfile == null)
            {
                Connections.getInstance(context).getDatabase().getJobProfileDAO().insert(this.jobProfile);
            }
            else
            {
                throw new Exception("Job Profile already exists");
            }
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
