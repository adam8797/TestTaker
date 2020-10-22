package Models;

import Models.Response.Response;
import Repository.FileRepository;
import Repository.IRepository;

import java.nio.file.Paths;

public class Test extends Survey
{
    public Test(String name, String path)
    {
        super(name, path);
        Responses = new FileRepository<>(Paths.get(path, name, "responses.bin").toString());
    }

    public IRepository<Response> Responses;
}
