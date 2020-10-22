package Models.Response;

public class StringResponse extends Response<String>
{
    public StringResponse()
    {

    }

    public StringResponse(String s)
    {
        UserResponse = s;
    }

    @Override
    public boolean Equals(Response response) {
        if (!(response instanceof StringResponse))
            return false;

        StringResponse b = (StringResponse)response;

        if (b.QuestionId != QuestionId)
            return false;

        return b.UserResponse.equals(UserResponse);
    }
}
