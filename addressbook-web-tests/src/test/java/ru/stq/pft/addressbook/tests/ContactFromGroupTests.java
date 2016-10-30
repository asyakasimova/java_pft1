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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.ContactData;
import ru.stq.pft.addressbook.model.Contacts;
import ru.stq.pft.addressbook.model.GroupData;
import ru.stq.pft.addressbook.model.Groups;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by A.Kasimova on 29.10.2016.
 */
public class ContactFromGroupTests extends TestBase{

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
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().gotoContactsPage();
      app.contact().createContact(new ContactData().withContactName("Asya").
              withContactSecondName("Kasimova").withContactAddress("test1").withContactHomePhone("+7 945 111 11 11").withContactEmail("asya.kasimova@a.com"), true);
    }
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }

    Groups groups = app.db().groups();
    Contacts contactsInGroup = new Contacts();
    app.goTo().gotoContactsPage();

    for (GroupData group : groups) {
      if (group.getContacts().size() != 0) {
        contactsInGroup.add(group.getContacts().iterator().next());
        break;
      }
    }

    if (contactsInGroup.size() == 0) {

      Groups groupsNew = app.db().groups();
      GroupData group = groupsNew.iterator().next();
      Contacts contacts = app.db().contacts();
      app.contact().selectContactById(contacts.iterator().next().getId());
      app.contact().addToGroup(group);
    }
  }


  @Test
  public void testContactFromGroup() {
    Groups groups = app.db().groups();
    Contacts contactsInGroup = new Contacts();
    app.goTo().gotoContactsPage();
    for (GroupData group : groups) {
      if (group.getContacts().size() != 0) {
        contactsInGroup.add(group.getContacts().iterator().next());
        break;
      }
    }

    int contactId = contactsInGroup.stream().iterator().next().getId();
    Groups contactGroupsBefore = contactsInGroup.stream().iterator().next().getGroups();
    GroupData groupToRemove = contactGroupsBefore.stream().iterator().next();
    app.group().selectGroup(groupToRemove);
    app.contact().selectContactById(contactId);
    app.contact().deleteContactFromGroup(groupToRemove.getName());

    Groups contactGroupsAfter = getContactWithId(contactId).getGroups();
    assertThat(contactGroupsAfter.size(), equalTo(contactGroupsBefore.size() - 1));

    assertThat(contactGroupsAfter, equalTo(contactGroupsBefore.without(groupToRemove)));
  }

  private ContactData getContactWithId(int id) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    ContactData contact = (ContactData) session.createQuery("from ContactData where id=" + id).uniqueResult();
    session.getTransaction().commit();
    session.close();
    return contact;
  }
}
