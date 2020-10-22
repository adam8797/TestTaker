package MVC.Controller;

import MVC.AppState;
import MVC.UserInterface.IInput;
import MVC.UserInterface.IOutput;
import MVC.UserInterface.IViewRenderer;

import java.lang.reflect.Method;

public class ReflectedController<TAppState extends AppState> implements IController<TAppState> {

    protected TAppState State;
    protected IViewRenderer ViewRenderer;
    protected IInput Input;
    protected IOutput Output;

    @Override
    public IResult Present(String action, String[] args, IViewRenderer renderer, IInput input, IOutput output, TAppState appState) {
        ViewRenderer = renderer;
        Input = input;
        Output = output;
        State = appState;

        try {

            Class c = getClass();
            Method[] methods = c.getMethods();
            Method method = null;
            for (int i = 0; i < methods.length; i++) {
                if (methods[i].getName().equals(action))
                    method = methods[i];
            }

            if (method == null)
                return null;

            //ToDo: Again, java sucks and cant do simple crap

//            if (method.getReturnType() != typeof(IResult))
//                return null;

            if (args == null)
                args = new String[0];

            if (method.getParameterCount() > args.length)
                return null;

//            Class<?>[] parameterTypes = method.getParameterTypes();
//            for (Class<?> c : parameterTypes) {
//                if (c != "".getClass())
//                    return null;
//            }

            return (IResult)method.invoke(this, args);
        }
        catch (Exception ex)
        {
            return null;
        }
    }
}
