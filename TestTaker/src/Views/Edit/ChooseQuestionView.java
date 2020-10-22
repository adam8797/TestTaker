package Views.Edit;

import MVC.Option;
import MVC.UserInterface.IOutput;
import MVC.UserInterface.RenderType;
import MVC.View.IView;
import Models.Question.Question;

import java.util.List;

public class ChooseQuestionView implements IView<List<Question>>
{
    @Override
    public void Render(IOutput userDisplay, List<Question> model) {
        userDisplay.Reset();
        userDisplay.SetRenderType(RenderType.OptionList);

        Option[] options = new Option[model.size()];
        for (int i = 0; i < model.size(); i++) {
            Question q = model.get(i);
            options[i] = new Option(q.Id + "", q.Prompt);
        }

        userDisplay.SetOptionList(options);
        userDisplay.Update();
    }
}
