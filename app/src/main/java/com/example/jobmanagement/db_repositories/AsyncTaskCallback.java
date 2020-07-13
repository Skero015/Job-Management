package com.example.jobmanagement.db_repositories;

public interface AsyncTaskCallback<T> {

    void onSuccess(T object);
    void onException(Exception exception);
}
