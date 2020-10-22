package MVC.Controller;

import MVC.AppState;
import MVC.UserInterface.IInput;
import MVC.UserInterface.IOutput;
import MVC.UserInterface.IViewRenderer;

public interface IController<TAppState extends AppState>
{
    IResult Present(String action, String[] args, IViewRenderer renderer, IInput input, IOutput output, TAppState appState);
}
