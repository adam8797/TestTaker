package Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileRepository<TEntity extends Entity> extends ArrayRepository<TEntity>
{
    private final String _file;

    public FileRepository(String file)
    {
        _file = file;
        LoadIntoMemory();
    }

    private void LoadIntoMemory()
    {
        FileChecks();
        try
        {
            //Saving of object in a file
            FileInputStream file = new FileInputStream(_file);
            ObjectInputStream out = new ObjectInputStream(file);

            // Method for serialization of object
            Repo = (ArrayList<TEntity>)out.readObject();

            out.close();
            file.close();
        }
        catch (EOFException ex)
        {
            // File is empty
            Repo = new ArrayList<>();
        }
        catch(IOException ex)
        {
            System.out.println("IOException caught: " + ex);
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException caught");
        }
    }

    private void SaveToDisk()
    {
        FileChecks();
        try
        {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(_file);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(Repo);

            out.close();
            file.close();
        }
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
    }

    private void FileChecks()
    {
        File f = new File(_file);
        try {
            if (!f.exists()) {
                new File(f.getParent()).mkdirs();
                f.createNewFile();
            }
        }
        catch (IOException ex)
        {
            System.out.println("Unable to check file");
        }
    }

    public List<TEntity> GetAll() {
        return super.GetAll();
    }

    public TEntity FindById(int id) {

        if (Repo == null)
            LoadIntoMemory();
        return super.FindById(id);
    }

    public int Count() {
        if (Repo == null)
            LoadIntoMemory();
        return super.Count();
    }

    public void Add(TEntity entity) {
        if (Repo == null)
            LoadIntoMemory();
        super.Add(entity);
    }

    public void Update(TEntity entity) {
        if (Repo == null)
            LoadIntoMemory();
        super.Update(entity);
    }

    public void Delete(TEntity entity) {
        if (Repo == null)
            LoadIntoMemory();
        super.Delete(entity);
    }

    public void DeleteById(int id) {
        if (Repo == null)
            LoadIntoMemory();
        super.DeleteById(id);
    }


    @Override
    public void CommitChanges() {
        SaveToDisk();
    }
}
