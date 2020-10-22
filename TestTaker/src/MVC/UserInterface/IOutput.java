package MVC.UserInterface;

import MVC.Option;

public interface IOutput
{
    void SetLeftHeader(String left);
    void SetRightHeader(String right);
    void SetPrompt(String prompt);
    void SetOptionList(Option... options);
    void SetRenderType(RenderType renderType);
    void SetStaticText(String text);
    void Alert(String msg);

    void Reset();
    void Update();
}
