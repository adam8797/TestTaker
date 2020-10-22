package MVC;

import MVC.Controller.IController;
import MVC.Controller.IResult;
import MVC.UserInterface.IInput;
import MVC.UserInterface.IOutput;
import MVC.UserInterface.IViewRenderer;

public class App
{
    public static void Run(AppState state, IInput input, IOutput output, IViewRenderer renderer, IController mainController, String mainAction)
    {
        HardGoTo(state, mainController, mainAction);

        while (true)
        {
            Location current = state.CurrentLocation;

            IResult result = current.GetController().Present(current.GetAction(), current.GetArguments(), renderer, input, output, state);

            if (result == null)
            {
                output.Alert("Null Result. Press enter to return to main menu");
                HardGoTo(state, mainController, mainAction);
            }
            else
                result.Execute(state);

            if (state.CurrentLocation == null)
            {
                output.Alert("Undefined Action. Press enter to return to main menu");
                HardGoTo(state, mainController, mainAction);
            }
        }
    }

    private static void HardGoTo(AppState state, IController controller, String action)
    {
        state.CurrentLocation = new Location(controller, action);
        state.PreviousLocations.clear();
    }
}
