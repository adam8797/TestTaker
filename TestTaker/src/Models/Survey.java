package Models;

import Models.Question.Question;
import Models.Response.Response;
import Repository.FileRepository;
import Repository.IRepository;

import java.nio.file.Paths;

public class Survey
{
    private String _name;

    public String GetName()
    {
        return _name;
    }

    public Survey(String name, String dataPath)
    {
        Questions = new FileRepository<>(Paths.get(dataPath, name, "questions.bin").toString());
        Responses = new FileRepository<>(Paths.get(dataPath, name, "responses.bin").toString());
    }

    public IRepository<Question> Questions;
    public IRepository<Response> Responses;

}
