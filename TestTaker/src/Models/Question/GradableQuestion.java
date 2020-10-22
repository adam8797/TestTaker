package Models.Question;

import Models.Response.Response;

public abstract class GradableQuestion<TResponse extends Response> extends Question
{
    public TResponse CorrectAnswer;
}
