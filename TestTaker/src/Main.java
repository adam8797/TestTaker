import Controllers.MainMenuController;
import MVC.App;
import MVC.AppState;
import MVC.UserInterface.ConsoleUserInterface;
import State.QuizAppState;

public class Main {

    public static void main(String[] args)
    {
        AppState state = new QuizAppState();
        ConsoleUserInterface ui = new ConsoleUserInterface();
        App.Run(state, ui, ui, ui, new MainMenuController(), "Index");
    }

}
