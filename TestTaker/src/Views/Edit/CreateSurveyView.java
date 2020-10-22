package Views.Edit;

import MVC.Option;
import MVC.UserInterface.IOutput;
import MVC.UserInterface.RenderType;
import MVC.View.IView;

public class CreateSurveyView implements IView
{
    public void Render(IOutput o, Object model)
    {
        o.Reset();
        o.SetRenderType(RenderType.OptionList);
        o.SetPrompt("Creating a new Survey/Test");
        o.SetOptionList(
                new Option("1", "Create a new Survey"),
                new Option("2", "Create a new Test"),
                new Option("0", "Go back! I didn't mean to"));
        o.Update();
    }
}
