package Controllers;

import MVC.AppState;
import MVC.Controller.ReflectedController;
import MVC.Controller.GoBackResult;
import MVC.Controller.IResult;
import MVC.Extra.Text.TextView;

public class LoadController extends ReflectedController<AppState> {

    public IResult Index()
    {
        ViewRenderer.Render(new TextView(), "Load/Index");
        Output.Alert("");
        return new GoBackResult();
    }

}
