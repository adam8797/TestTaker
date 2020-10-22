package Views.Shared;

import MVC.UserInterface.IOutput;
import MVC.UserInterface.RenderType;
import MVC.View.IView;

public class ClearView implements IView
{
    @Override
    public void Render(IOutput userDisplay, Object model) {
        userDisplay.Reset();
        userDisplay.SetRenderType(RenderType.None);
        userDisplay.Update();
    }
}
