package Views.Edit;

import MVC.Option;
import MVC.UserInterface.IOutput;
import MVC.UserInterface.RenderType;
import MVC.View.IView;

public class SurveyAlreadyLoadedMessageView implements IView {
    public void Render(IOutput o, Object model)
    {
        o.Reset();
        o.SetRenderType(RenderType.OptionList);
        o.SetPrompt("A survey has already been loaded. Choose what you would like to do:");
        o.SetOptionList(
                new Option("1", "Do nothing and just edit this survey/test"),
                new Option("2", "Edit a brand new survey/test (Unsaved changes will be lost)"),
                new Option("0", "Go back! I didn't mean to"));
        o.SetLeftHeader("Warning!");
        o.Update();
    }
}
