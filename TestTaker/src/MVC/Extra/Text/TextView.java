package MVC.Extra.Text;

import MVC.UserInterface.IOutput;
import MVC.UserInterface.RenderType;
import MVC.View.IView;

public class TextView implements IView<String> {
    @Override
    public void Render(IOutput o, String model) {
        o.Reset();
        o.SetRenderType(RenderType.StaticText);
        o.SetStaticText(model);
        o.Update();
    }
}
