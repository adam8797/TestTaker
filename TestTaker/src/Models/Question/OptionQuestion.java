package Models.Question;

import MVC.Option;
import Models.Response.Response;

import java.util.ArrayList;

public abstract class OptionQuestion<TResponse extends Response> extends GradableQuestion<TResponse> {

    public OptionQuestion()
    {
        Options = new ArrayList<>();
    }

    public ArrayList<Option> Options;
}
