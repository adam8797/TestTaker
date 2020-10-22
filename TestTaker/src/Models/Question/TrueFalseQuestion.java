package Models.Question;

import MVC.Option;
import Models.Response.BooleanResponse;

public class TrueFalseQuestion extends OptionQuestion<BooleanResponse>
{
    public TrueFalseQuestion()
    {
        super();
        Options.clear();
        Options.add(new Option("t", "True"));
        Options.add(new Option("f", "False"));
    }

    // response is a boolean
}
