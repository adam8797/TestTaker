package MVC.Controller;

import MVC.AppState;
import MVC.Location;

public class GoToResult implements IResult
{
    final Location target;

    public GoToResult(Location l)
    {
        target = l;
    }

    public GoToResult(IController controller, String action, String... args)
    {
        target = new Location(controller, action, args);
    }

    public GoToResult(IController controller, String action)
    {
        target = new Location(controller, action);
    }

    public GoToResult(IController controller)
    {
        target = new Location(controller, null);
    }

    @Override
    public void Execute(AppState state)
    {
        state.PreviousLocations.push(state.CurrentLocation);
        state.CurrentLocation = target;
    }
}