package MVC;

import MVC.Controller.IController;

public class Location
{
    public static final String DefaultAction = "Index";

    public Location(IController controller, String action, String... args)
    {
        _controller = controller;
        _action = action;
        _arguments = args;
    }

    private IController _controller;
    private String _action;
    private String[] _arguments;

    public IController GetController()
    {
        return _controller;
    }

    public String GetAction()
    {
        if (_action == null)
            return DefaultAction;
        return _action;
    }

    public String[] GetArguments()
    {
        return _arguments;
    }
}
