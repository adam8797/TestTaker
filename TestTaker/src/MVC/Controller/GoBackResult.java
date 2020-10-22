package MVC.Controller;

import MVC.AppState;

public class GoBackResult implements IResult {
    @Override
    public void Execute(AppState state) {
        state.CurrentLocation = state.PreviousLocations.pop();
    }
}
