package MVC.Extra.Navigation;

import MVC.UserInterface.IOutput;
import MVC.UserInterface.RenderType;
import MVC.View.IView;

public class NavigationView implements IView<NavigationViewModel> {

    @Override
    public void Render(IOutput o, NavigationViewModel model)
    {
        o.Reset();
        o.SetRenderType(RenderType.OptionList);

        o.SetOptionList(model.NavigationOptions);
        o.SetLeftHeader(model.PageTitle);
        o.SetRightHeader(model.SubTitle);

        o.Update();
    }

}
