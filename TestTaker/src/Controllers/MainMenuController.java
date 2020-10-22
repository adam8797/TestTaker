package Controllers;

import MVC.Controller.ExitResult;
import MVC.Controller.IResult;
import MVC.Extra.Navigation.NavigationController;
import MVC.Extra.Navigation.NavigationOption;
import Models.Test;
import State.QuizAppState;

public class MainMenuController extends NavigationController<QuizAppState> {

    @Override
    protected NavigationOption[] GetNavigationOptions() {
        IResult nullResult = null;

        if (State.LoadedSurvey == null) {

            return new NavigationOption[]{
                new NavigationOption("1", "Create a new Survey/Test", new EditController()),
                new NavigationOption("2", "Load a Survey/Test", nullResult),
                new NavigationOption("0", "Quit", new ExitResult()),
            };
        }
        else
        {
            String noun = State.LoadedSurvey instanceof Test ? "Test":"Survey";
            return new NavigationOption[]{
                    new NavigationOption("1", "Edit the loaded " + noun, new EditController()),
                    new NavigationOption("2", "Take the loaded " + noun, new TakeSurveyController()),
                    new NavigationOption("3", "Tabulate the loaded" + noun, new TabulateController()),
                    new NavigationOption("4", "Load a different Survey/Test", nullResult),
                    new NavigationOption("0", "Quit", new ExitResult()),
            };
        }
    }

    @Override
    protected String GetTitle() {
        return "Main Menu";
    }



}
