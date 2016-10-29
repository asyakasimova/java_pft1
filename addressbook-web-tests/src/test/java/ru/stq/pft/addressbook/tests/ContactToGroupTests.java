package ru.stq.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.ContactData;
import ru.stq.pft.addressbook.model.GroupData;
import ru.stq.pft.addressbook.model.Groups;

import java.util.List;

/**
 * Created by A.Kasimova on 28.10.2016.
 */
public class ContactToGroupTests extends TestBase{

  private SessionFactory sessionFactory;

  @BeforeClass
  public void setUp() throws Exception {
    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
    try {
      sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
    }
    catch (Exception e) {
      e.printStackTrace();
      // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
      // so destroy it manually.
      StandardServiceRegistryBuilder.destroy( registry );
    }
  }

  @BeforeMethod
  public void ensurePreconditionsContacts() {
    if (app.db().contacts().size() == 0) {
      app.goTo().gotoContactsPage();
      app.contact().createContact(new ContactData().withContactName("Asya").
              withContactSecondName("Kasimova").withContactAddress("test1").withContactHomePhone("+7 945 111 11 11").withContactEmail("asya.kasimova@a.com"), true);
    }
  }
  @BeforeMethod
  public void ensurePreconditionsGroups() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testContactToGroup() {
    ContactData contact = app.contact().all().iterator().next();
    Groups contactGroupsBefore = contact.getGroups();
    app.contact().selectContactById(contact.getId());
    GroupData group = getGroupList().iterator().next();
    app.contact().addToGroup(group);
    Groups contactGroupsAfter = contact.getGroups();
    contactGroupsBefore.add(group);

    MatcherAssert.assertThat(contactGroupsAfter, CoreMatchers.equalTo(contactGroupsBefore));
  }

  private List<GroupData> getGroupList() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<GroupData> groups = session.createQuery( "from GroupData" ).list();
    session.getTransaction().commit();
    session.close();
    return groups;
  }
}
