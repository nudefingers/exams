package dao;

import entity.Climber;
import entity.Mountain;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ClimberDao implements Dao<Climber, String>{
    private EntityManager manager;

    public ClimberDao(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void add(Climber entity) {
        manager.persist(entity);
    }

    @Override
    public Climber getByPK(String string) {
        return manager.find(Climber.class, string);
    }

    @Override
    public List<Climber> getAll() {

        // SELECT * FROM tb_group;
        return null;
    }

    @Override
    public void update(Climber entity) {

    }

    public Climber getByNameAndMail(String name, String mail) {
        TypedQuery<Climber> query = manager.createNamedQuery("climber.get.by.name.mail", Climber.class);
        //query.setParameter("climber_name", name);
        query.setParameter("climber_mail", mail);

        return query.getSingleResult();
    }

    @Override
    public void deleteByPK(String string) {
        manager.remove(getByPK(string));
    }
}
