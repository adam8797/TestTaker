package Models.Response;

import Repository.Entity;

public abstract class Response<TResponse> extends Entity
{
    public int QuestionId;

    public int ResponseSet;

    public TResponse UserResponse;

    public abstract boolean Equals(Response response);
}
