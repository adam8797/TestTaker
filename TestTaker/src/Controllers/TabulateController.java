package Controllers;

import MVC.Controller.ReflectedController;
import MVC.Controller.GoBackResult;
import MVC.Controller.IResult;
import MVC.Extra.Text.TextView;
import State.QuizAppState;

public class TabulateController extends ReflectedController<QuizAppState>
{
    public IResult Index()
    {
        ViewRenderer.Render(new TextView(), "Tabulate/Index");
        Output.Alert("");
        return new GoBackResult();
    }

    public IResult QuestionDetails(String questionId)
    {
        ViewRenderer.Render(new TextView(), "Tabulate/QuestionDetails " + questionId);
        Output.Alert("");
        return new GoBackResult();
    }

    public IResult Grade(String responseSet)
    {
        ViewRenderer.Render(new TextView(), "Tabulate/Grade " + responseSet);
        Output.Alert("");
        return new GoBackResult();
    }
}
