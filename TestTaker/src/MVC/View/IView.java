package MVC.View;

import MVC.UserInterface.IOutput;

public interface IView<TModel>
{
    void Render(IOutput userDisplay, TModel model);
}
