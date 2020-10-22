package Repository;

import java.util.List;

public interface IRepository<TEntity extends Entity>
{
    /**
     * @return An Iterable of all entities in the repository
     */
    List<TEntity> GetAll();

    /**
     * @param id ID of the entity to find
     * @return The found entity, or null if not found
     */
    TEntity FindById(int id);

    /**
     * @return The number of entities in the repository
     */
    int Count();

    /**
     * Inserts an entity into the repository. Will modify object ID
     * @param entity
     */
    void Add(TEntity entity);

    /**
     * Replaces an entity with the same ID. Will not modify object ID
     * @param entity
     */
    void Update(TEntity entity);

    /**
     * Removes an entity from the repository
     * @param entity
     */
    void Delete(TEntity entity);

    /**
     * Removes an entity from the repository by ID
     * @param id
     */
    void DeleteById(int id);

    /**
     * Write any modifications of the repository to disk, if not already written.
     */
    void CommitChanges();
}
