package ru.stq.pft.addressbook.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.stq.pft.addressbook.model.ContactData;
import ru.stq.pft.addressbook.model.Contacts;
import ru.stq.pft.addressbook.model.GroupData;
import ru.stq.pft.addressbook.model.Groups;

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

  public Groups groups() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<GroupData> result = session.createQuery( "from GroupData").list();

    session.getTransaction().commit();
    session.close();
    return new Groups(result);

  }

  public Contacts contacts() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<ContactData> result = session.createQuery( "from ContactData where deprecated = '0000-00-00'").list();

    session.getTransaction().commit();
    session.close();
    return new Contacts(result);

  }

}
