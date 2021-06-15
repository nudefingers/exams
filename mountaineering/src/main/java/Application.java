import dao.ClimberDao;
import dao.ClimbingGroupDao;
import dao.MountainDao;
import entity.Climber;
import entity.ClimbingGroup;
import entity.Mountain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("perunit");

        EntityManager manager = factory.createEntityManager();
        ClimberDao climberDao = new ClimberDao(manager);
        MountainDao mountainDao = new MountainDao(manager);
        ClimbingGroupDao climbingGroupDao = new ClimbingGroupDao(manager);

        Climber climber1 = new Climber();

        Climber.ClimberKey key1 = new Climber.ClimberKey();
        key1.setName("Петров");
        key1.setSurname("Григорий");
        climber1.setKey(key1);

        climber1.setAge(34);
        climber1.setEmail("grigri@gmail.com");
        climber1.setUuid();


        Climber climber2 = new Climber();

        Climber.ClimberKey key2 = new Climber.ClimberKey();
        key2.setName("Ян");
        key2.setSurname("Ян");
        climber2.setKey(key2);

        climber2.setAge(18);
        climber2.setEmail("ya_yan@gmail.com");
        climber2.setUuid();

        Mountain everest = new Mountain();
        everest.setName("Эверест");
        everest.setHeight(8000);

        ClimbingGroup group = new ClimbingGroup();
        group.setMountain(everest);
        group.setStart(LocalDateTime.of(2021,7,20,11,0));
        List<Climber> climbers = Arrays.asList(climber1, climber2);
        group.setClimbers(climbers);

        manager.getTransaction().begin();
        climberDao.add(climber1);
        climberDao.add(climber2);
        mountainDao.add(everest);
        climbingGroupDao.add(group);
        manager.getTransaction().commit();

        /*System.out.println(mountainDao.getByHeight(5000, 6000));
        System.out.println(climbingGroupDao.getNotStarted());
        System.out.println(climberDao.getByFullNameEmail("Василий", "test@test.ru"));
        System.out.println(mountainDao.getByName("Everest1"));*/
    }
}
