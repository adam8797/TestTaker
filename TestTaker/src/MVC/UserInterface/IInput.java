package MVC.UserInterface;

import MVC.Option;

public interface IInput
{
    int PromptForInt(String msg);
    int PromptForInt(String msg, int min, int max);
    String PromptForString(String msg);
    boolean PromptForBoolean(String msg);
    Option PromptForOption(String msg, Option... options);
}
