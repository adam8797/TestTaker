package Models.Question;

import MVC.Option;
import Models.Response.ArrayResponse;
import Models.Response.Response;

import java.util.ArrayList;

public class MatchingQuestion extends OptionQuestion<ArrayResponse>
{
    public ArrayList<Option> UserOptions;
    // Options:
    // A: Answer A
    // B: Answer B
    // C: Answer C
    // D: Answer D

    // Response is list of strings "UserOptions.Key:Options.Key"

}
