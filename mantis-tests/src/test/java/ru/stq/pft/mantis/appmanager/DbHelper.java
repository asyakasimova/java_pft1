package ru.stq.pft.mantis.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.stq.pft.mantis.model.User;

import java.util.List;

/**
 * Created by A.Kasimova on 27.10.2016.
 */
public class DbHelper {

  private final SessionFactory sessionFactory;


  public DbHelper() {
  // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
          .configure() // configures settings from hibernate.cfg.xml
          .build();
    sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
  }

  public User user() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<User> result = session.createQuery( "from User where id > 1").list();
    User user = result.stream().iterator().next();

    session.getTransaction().commit();
    session.close();
    return user;

  }
}
