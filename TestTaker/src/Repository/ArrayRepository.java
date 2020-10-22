package Repository;

import java.util.ArrayList;
import java.util.List;

public class ArrayRepository<TEntity extends Entity> implements IRepository<TEntity>
{
    protected ArrayList<TEntity> Repo;

    public ArrayRepository()
    {
        Repo = new ArrayList<>();
    }

    public ArrayRepository(ArrayList<TEntity> repo)
    {
        Repo = repo;
    }

    public List<TEntity> GetAll() {
        return Repo;
    }

    public TEntity FindById(int id) {
        for (TEntity entity : Repo) {
            if (entity.Id == id)
                return entity;
        }
        return null;
    }

    public int Count() {
        return Repo.size();
    }

    public void Add(TEntity entity) {
        int maxId = -1;
        for (int i = 0; i < Repo.size(); i++)
        {
            TEntity e = Repo.get(i);
            if (e.Id >= maxId)
                maxId = e.Id;
        }

        // this entity will take the next ID
        entity.Id = maxId + 1;
        Repo.add(entity);
    }

    public void Update(TEntity entity) {

        // this function acts more like an upsert
        boolean wasUpdated = false;

        for (int i = 0; i < Repo.size(); i++)
        {
            if (Repo.get(i).Id == entity.Id)
            {
                wasUpdated = true;
                Repo.set(i, entity);
            }
        }

        if (!wasUpdated)
        {
            // need to insert
            // not calling Add(), because
            // we want to preserve the ID
            Repo.add(entity);
        }
    }

    public void Delete(TEntity entity) {
        Repo.remove(entity);
    }

    public void DeleteById(int id) {
        for (int i = 0; i < Repo.size(); i++)
        {
            if (Repo.get(i).Id == id)
                Repo.remove(i);
        }
    }

    public void CommitChanges() {

    }
}
