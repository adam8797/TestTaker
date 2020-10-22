package MVC.Controller;

import MVC.AppState;

public class ExitResult implements IResult {
    @Override
    public void Execute(AppState state) {
        System.exit(0);
    }
}
