package MVC;

import java.io.Serializable;

public class Option implements Serializable
{
    private String _key;
    private String _value;

    public Option(String key, String value)
    {
        _key = key;
        _value = value;
    }

    public String GetKey()
    {
        return _key;
    }

    public String GetValue()
    {
        return _value;
    }
}
