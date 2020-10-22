package MVC.Extra.Navigation;

import MVC.AppState;
import MVC.Controller.ReflectedController;
import MVC.Controller.GoBackResult;
import MVC.Controller.IResult;
import MVC.Option;

import java.util.ArrayList;
import java.util.List;

public abstract class NavigationController<TAppState extends AppState> extends ReflectedController<TAppState> {

    protected abstract NavigationOption[] GetNavigationOptions();

    protected abstract String GetTitle();

    protected String GetSubtitle()
    {
        return "";
    }

    protected IResult ActionChosen(NavigationOption chosen)
    {
        return chosen.GetResult();
    }

    public IResult Index()
    {
        NavigationViewModel model = new NavigationViewModel();

        NavigationOption[] navigationOptions;

        if (State.PreviousLocations.size() > 0)
        {
            // Add GoBack
            NavigationOption[] optionsArray = GetNavigationOptions();

            List<NavigationOption> options = new ArrayList<>(optionsArray.length + 1);
            for (NavigationOption opt : optionsArray) {
                options.add(opt);
            }
            options.add(new NavigationOption("0", "Go Back", new GoBackResult()));
            model.NavigationOptions = options.toArray(new NavigationOption[options.size()]);
        }
        else
        {
            model.NavigationOptions = GetNavigationOptions();
        }

        model.PageTitle = GetTitle();
        model.SubTitle = GetSubtitle();

        ViewRenderer.Render(new NavigationView(), model);

        Option choice = Input.PromptForOption("Choose a menu option", model.NavigationOptions);

        NavigationOption chosenNav = (NavigationOption)choice;

        return ActionChosen(chosenNav);
    }

}
