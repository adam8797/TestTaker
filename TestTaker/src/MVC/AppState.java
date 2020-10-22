package MVC;

import java.util.Stack;

public class AppState
{
    public AppState()
    {
        PreviousLocations = new Stack<>();
    }

    public Location CurrentLocation;

    public Stack<Location> PreviousLocations;
}
