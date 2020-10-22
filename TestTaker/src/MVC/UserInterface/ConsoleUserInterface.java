package MVC.UserInterface;

import MVC.Option;
import MVC.View.IView;

import java.util.Arrays;
import java.util.Scanner;

public class ConsoleUserInterface implements IInput, IOutput, IViewRenderer {

    private String _headerLeft;
    private String _headerRight;
    private String _prompt;
    private String _staticText;

    private Option[] _options;
    private RenderType _renderType;

    private Scanner _inputScanner;

    private final String InvalidResponseMessage = "Invalid Response";

    public ConsoleUserInterface()
    {
        _inputScanner = new Scanner(System.in);
    }

    @Override
    public int PromptForInt(String msg) {
        System.out.println(msg);
        System.out.print("(number) ~> ");
        return _inputScanner.nextInt();
    }

    @Override
    public int PromptForInt(String msg, int min, int max) {
        while (true)
        {
            System.out.println(msg);
            System.out.print("(number [" + min + ", " + max + "]) ~> ");
            int input = _inputScanner.nextInt();

            if (input >= min && input <= max)
                return input;

            System.out.println(InvalidResponseMessage);
        }

    }

    @Override
    public String PromptForString(String msg) {
        while (true)
        {
            System.out.println(msg);
            System.out.print(" ~> ");
            String input = _inputScanner.nextLine().trim();

            if (input.length() > 0)
                return input;

            System.out.println(InvalidResponseMessage);
        }
    }

    @Override
    public boolean PromptForBoolean(String msg) {
        while (true)
        {
            System.out.println(msg);
            System.out.print("(T/F) ~> ");
            String input = _inputScanner.nextLine().toUpperCase().trim();
            if (input.equals("T"))
                return true;
            if (input.equals("F"))
                return false;
            System.out.println(InvalidResponseMessage);
        }
    }

    @Override
    public Option PromptForOption(String msg, Option... options) {
        while (true)
        {
            System.out.println(msg);
            System.out.print("(option) ~> ");

            String input = _inputScanner.nextLine().trim();

            if (options.length == 0)
                options = this._options;

            for (Option opt : options) {
                if (opt.GetKey().equals(input))
                    return opt;
            }

            System.out.println("Invalid Response.");
        }
    }

    @Override
    public void SetLeftHeader(String left) {
        if (left == null)
            left = "";
        _headerLeft = left;
    }

    @Override
    public void SetRightHeader(String right) {
        if (right == null)
            right = "";
        _headerRight = right;
    }

    @Override
    public void SetPrompt(String prompt) {
        _prompt = prompt;
    }

    @Override
    public void SetOptionList(Option... options) {
        _options = options;
    }

    @Override
    public void SetRenderType(RenderType renderType) {
        _renderType = renderType;
    }

    @Override
    public void SetStaticText(String text) {
        _staticText = text;
    }

    @Override
    public void Alert(String msg) {
        if (msg.trim().length() > 0)
            System.out.println(msg);
        System.out.println("Press <return> to continue....");
        _inputScanner.nextLine();
    }

    @Override
    public void Reset() {
        _headerLeft = "";
        _headerRight = "";
        _options = null;
        _prompt = "";
        _renderType = RenderType.StaticText;
        _staticText = "";
    }

    @Override
    public void Update() {
        Clear();
        if (_renderType == RenderType.None)
            return;

        int headerLeft = 0;
        if (_headerLeft != null)
            headerLeft = _headerLeft.length();

        int headerRight = 0;
        if (_headerRight != null)
            headerRight = _headerRight.length();

        int gapLength = ConsoleWidth() - headerLeft - headerRight;
        String firstLine = _headerLeft + RepeatingString(' ', gapLength) + _headerRight;
        System.out.println(firstLine);
        System.out.println(RepeatingString(' ', ConsoleWidth()));

        if (_prompt != null && _prompt.trim().length() != 0)
        {
            System.out.println(_prompt);
            System.out.println(" -- ");
        }

        switch (_renderType)
        {
            case StaticText:
                System.out.println(_staticText);
                break;
            case OptionList:
                for (Option option : _options)
                {
                    System.out.println(String.format("[%s] %s", option.GetKey(), option.GetValue()));
                }
                System.out.println();
                break;
            case LongPrompt:
                break;
            case ShortPrompt:
                break;
        }
        System.out.flush();
    }

    @Override
    public void Render(IView view, Object model) {
        view.Render(this, model);
    }

    @Override
    public void Render(IView view) {
        view.Render(this, null);
    }

    private String RepeatingString(char c, int count)
    {
        char[] chars = new char[count];
        Arrays.fill(chars, c);
        return new String(chars);
    }


    private void Clear()
    {
        System.out.print(RepeatingString('\n', 20));
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private int ConsoleWidth()
    {
        return 50;
    }
}
