package Models.Response;

public class BooleanResponse extends Response<Boolean>
{
    public BooleanResponse()
    {
    }

    public BooleanResponse(boolean b)
    {
        UserResponse = b;
    }

    @Override
    public boolean Equals(Response response) {
        if (!(response instanceof BooleanResponse))
            return false;

        BooleanResponse b = (BooleanResponse)response;

        if (b.QuestionId != QuestionId)
            return false;

        return b.UserResponse.equals(UserResponse);
    }
}
