package MVC.UserInterface;

import MVC.View.IView;

public interface IViewRenderer
{
    void Render(IView view, Object model);
    void Render(IView view);
}
