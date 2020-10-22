package Controllers;

import MVC.Controller.ReflectedController;
import MVC.Controller.GoBackResult;
import MVC.Controller.IResult;
import MVC.Extra.Text.TextView;
import State.QuizAppState;

public class TakeSurveyController extends ReflectedController<QuizAppState>
{
    public IResult Index()
    {
        ViewRenderer.Render(new TextView(), "Load/Index");
        Output.Alert("");
        return new GoBackResult();
    }

    public IResult Respond(String id)
    {
        ViewRenderer.Render(new TextView(), "Responding to " + id);
        Output.Alert("");
        return new GoBackResult();
    }
}
