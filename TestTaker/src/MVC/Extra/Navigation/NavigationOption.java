package MVC.Extra.Navigation;

import MVC.Controller.GoToResult;
import MVC.Controller.IController;
import MVC.Controller.IResult;
import MVC.Location;
import MVC.Option;

public class NavigationOption extends Option {

    Location targetLocation = null;
    IResult staticResult = null;

    public NavigationOption(String key, String value, Location l)
    {
        super(key, value);
        targetLocation = l;
    }

    public NavigationOption(String key, String value, IController controller)
    {
        super(key, value);
        targetLocation = new Location(controller, null);
    }

    public NavigationOption(String key, String value, IController controller, String action)
    {
        super(key, value);
        targetLocation = new Location(controller, action);
    }

    public NavigationOption(String key, String value, IController controller, String action, String... args)
    {
        super(key, value);
        targetLocation = new Location(controller, action, args);
    }

    public NavigationOption(String key, String value, IResult staticResult)
    {
        super(key, value);
        this.staticResult = staticResult;
    }

    public IResult GetResult()
    {
        if (staticResult != null)
            return staticResult;

        return new GoToResult(targetLocation);
    }
}

