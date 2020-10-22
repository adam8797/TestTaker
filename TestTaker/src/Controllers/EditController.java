package Controllers;

import MVC.Controller.GoBackResult;
import MVC.Controller.GoToResult;
import MVC.Controller.IResult;
import MVC.Extra.Navigation.NavigationController;
import MVC.Extra.Navigation.NavigationOption;
import MVC.Extra.Text.TextView;
import MVC.Option;
import MVC.UserInterface.RenderType;
import Models.Question.Question;
import Models.Question.TrueFalseQuestion;
import Models.Response.BooleanResponse;
import Models.Survey;
import Models.Test;
import State.QuizAppState;
import Views.Edit.ChooseQuestionView;
import Views.Edit.CreateSurveyView;
import Views.Edit.SurveyAlreadyLoadedMessageView;
import Views.Shared.ClearView;

import java.nio.file.Paths;
import java.util.List;

public class EditController extends NavigationController<QuizAppState>
{
    @Override
    protected NavigationOption[] GetNavigationOptions()
    {
        return new NavigationOption[] {
                new NavigationOption("1", "Add a new T/F Question", this, "TrueFalse", ""),
                new NavigationOption("2", "Add a new Multiple Choice Question", this, "MultipleChoice"),
                new NavigationOption("3", "Add a new Short Answer Question", this, "ShortAnswer"),
                new NavigationOption("4", "Add a new Essay Question", this, "Essay"),
                new NavigationOption("5", "Add a new Matching Question", this, "Matching"),
                new NavigationOption("6", "Add a new Ranking Question", this, "Ranking"),
                new NavigationOption("7", "Edit a Question", this, "Edit")
        };
    }

    @Override
    protected String GetTitle()
    {
        return "Edit";
    }

    public IResult Index()
    {
        if (State.LoadedSurvey != null)
        {
            ViewRenderer.Render(new SurveyAlreadyLoadedMessageView(), null);
            int choice = Input.PromptForInt("Choose an option", 0, 2);
            switch (choice)
            {
                case 1:
                    break;
                case 2:
                    Create();
                    break;
                case 0:
                    return new GoBackResult();
            }
        }
        else
            Create();

        return super.Index();
    }

    public IResult IndexNoLoad()
    {
        return super.Index();
    }

    private void Create()
    {
        ViewRenderer.Render(new CreateSurveyView());

        int choice = Input.PromptForInt("Choose an option", 0, 2);
        String name = Input.PromptForString("Name of Survey/Test: ");

        switch (choice)
        {
            case 0:
                return;
            case 1:
                State.LoadedSurvey = new Survey(name, "data");
                break;
            case 2:
                State.LoadedSurvey = new Test(name, "data");
                break;
        }
    }

    public IResult Edit()
    {
        List<Question> questions = State.LoadedSurvey.Questions.GetAll();

        if (questions.size() == 0)
        {
            Output.Alert("No Questions to Edit!");
            return new GoBackResult();
        }

        ViewRenderer.Render(new ChooseQuestionView(), questions);

        int questionIndex = Input.PromptForInt("Choose a question: ", 0, questions.size() - 1);

        Question q = questions.get(questionIndex);

        if (q instanceof TrueFalseQuestion)
            return new GoToResult(this, "TrueFalse", questionIndex + "");


        return null;
    }

    public IResult TrueFalse(String id)
    {
        if (id == null || id.equals(""))
        {
            ViewRenderer.Render(new TextView(), "Creating New True/False Question.");

            // Creating a new Question
            TrueFalseQuestion question = new TrueFalseQuestion();
            question.Prompt = Input.PromptForString("Enter Prompt: ");

            if (State.LoadedSurvey instanceof Test)
            {
                boolean b = Input.PromptForBoolean("Enter Correct Answer: ");
                question.CorrectAnswer = new BooleanResponse(b);
            }

            State.LoadedSurvey.Questions.Add(question);
            State.LoadedSurvey.Questions.CommitChanges();
        }
        else
        {
            ViewRenderer.Render(new TextView(), "Editing True/False Question.");
            Output.Alert("");
            // Editing a question
        }

        return new GoToResult(this, "IndexNoLoad");
    }
}
