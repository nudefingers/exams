package dao;

import entity.ClimbingGroup;
import entity.Mountain;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;

public class ClimbingGroupDao implements Dao<ClimbingGroup, Integer>{
    private EntityManager manager;

    public ClimbingGroupDao(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void add(ClimbingGroup entity) {
        manager.persist(entity);
    }

    @Override
    public ClimbingGroup getByPK(Integer integer) {
        return manager.find(ClimbingGroup.class, integer);
    }

    @Override
    public List<ClimbingGroup> getAll() {

        // SELECT * FROM tb_group;
        return null;
    }

    @Override
    public void update(ClimbingGroup entity) {

    }

    @Override
    public void deleteByPK(Integer integer) {
        manager.remove(getByPK(integer));
    }

    public List<ClimbingGroup> getByFutureDate(LocalDateTime date) {
        TypedQuery<ClimbingGroup> query = manager.createNamedQuery("group.get.future.date", ClimbingGroup.class);
        query.setParameter("start_date", date);

        return query.getResultList();
    }
}
