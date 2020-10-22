package Models.Response;

public class ArrayResponse extends Response<String[]>
{
    public ArrayResponse()
    {
        super();
    }

    public ArrayResponse(String[] response)
    {
        UserResponse = response;
    }

    @Override
    public boolean Equals(Response response) {

        if (!(response instanceof ArrayResponse))
            return false;

        ArrayResponse arr = (ArrayResponse)response;

        if (arr.QuestionId != QuestionId)
            return false;

        if (arr.UserResponse.length != UserResponse.length)
            return false;

        for (int i = 0; i < arr.UserResponse.length; i++) {
            if (!arr.UserResponse[i].equals(UserResponse[i]))
                return false;
        }

        return true;
    }
}
