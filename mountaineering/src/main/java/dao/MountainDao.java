package dao;

import entity.Mountain;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class MountainDao implements Dao<Mountain, Integer>{
    private EntityManager manager;

    public MountainDao(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void add(Mountain entity) {
        manager.persist(entity);
    }

    @Override
    public Mountain getByPK(Integer integer) {
        return manager.find(Mountain.class, integer);
    }

    @Override
    public List<Mountain> getAll() {
        TypedQuery<Mountain> query = manager.createNamedQuery("mountain.get.all", Mountain.class);

        return query.getResultList();
    }

    public List<Mountain> getByHeigth(int min, int max) {
        TypedQuery<Mountain> query = manager.createNamedQuery("mountain.get.by.height", Mountain.class);
        query.setParameter("min_height",min);
        query.setParameter("max_height",max);

        return query.getResultList();
    }

    public Mountain getByName(String name) {
        TypedQuery<Mountain> query = manager.createNamedQuery("mountain.get.by.name", Mountain.class);
        query.setParameter("mountain_name", name);

        return query.getSingleResult();
    }

    @Override
    public void update(Mountain entity) {

    }

    @Override
    public void deleteByPK(Integer integer) {

    }
}
