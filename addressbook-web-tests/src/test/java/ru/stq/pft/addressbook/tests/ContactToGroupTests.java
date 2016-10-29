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
import ru.stq.pft.addressbook.model.Contacts;
import ru.stq.pft.addressbook.model.GroupData;
import ru.stq.pft.addressbook.model.Groups;

import java.util.List;

/**
 * Created by A.Kasimova on 28.10.2016.
 */
public class ContactToGroupTests extends TestBase{


  private SessionFactory sessionFactory;

  @BeforeClass
  public void setUpDb() throws Exception {
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
    Contacts contacts = app.db().contacts();
    ContactData contact = contacts.iterator().next();
    int contactId = contact.getId();
    Groups contactGroupsBefore = contact.getGroups();
    GroupData group = getGroupList().iterator().next();
    int groupId = group.getId();
    
    app.contact().selectContactById(contact.getId());
    app.contact().addToGroup(group);
    contact = getContactWithId(contactId);
    Groups contactGroupsAfter = contact.getGroups();
    contactGroupsBefore.add(group);

    MatcherAssert.assertThat(contactGroupsAfter, CoreMatchers.equalTo(contactGroupsBefore));
  }

  @Test
  public void testContactFromGroup() {
    Contacts contacts = app.db().contacts();
  }

  private List<GroupData> getGroupList() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<GroupData> groups = session.createQuery( "from GroupData" ).list();
    session.getTransaction().commit();
    session.close();
    return groups;
  }
  private List<ContactData> getContacts() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<ContactData> contacts = session.createQuery( "from ContactData where deprecated = '0000-00-00'" ).list();
    session.getTransaction().commit();
    session.close();
    return contacts;
  }
  private ContactData getContactWithId(int id) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    ContactData contact = (ContactData) session.createQuery( "from ContactData where id=" + id).uniqueResult();
    session.getTransaction().commit();
    session.close();
    return contact;
  }
}
