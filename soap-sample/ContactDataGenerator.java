package ru.stq.pft.addressbook.generators;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import org.openqa.selenium.remote.BrowserType;
import ru.stq.pft.addressbook.appmanager.ApplicationManager;
import ru.stq.pft.addressbook.model.ContactData;
import ru.stq.pft.addressbook.model.GroupData;
import ru.stq.pft.addressbook.model.Groups;
import ru.stq.pft.addressbook.tests.TestBase;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by A.Kasimova on 22.10.2016.
 */
public class ContactDataGenerator extends TestBase{
 /* @Parameter (names = "-c", description = "Contacts count")
  public int count;

  @Parameter (names = "-f", description = "Target file")
  public String file;

  @Parameter (names = "-d", description = "Data format")
  public String format;

  protected final ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);

  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    generator.app.init();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.ensurePreconditions();
    generator.run();
  }

  public void ensurePreconditions() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }
  }

 private void run() throws IOException {
    List<ContactData> contacts = generateContacts(count);

    if (format.equals("csv")) {
      saveAsCsv(contacts, new File(file));
    } else if (format.equals("xml")) {
      saveAsXml(contacts, new File(file));
    } else if (format.equals("json")) {
      saveAsJson(contacts, new File(file));
    }else {
      System.out.println("Unrecognised format " + format);
    }
  }

  private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(contacts);
    Writer writer = new FileWriter(file);
    writer.write(json);
    writer.close();
  }

  private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactData.class);
    String xml = xstream.toXML(contacts);
    try (Writer writer = new FileWriter(file)) {
      writer.write(xml);
    }
  }

  private void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
    try (Writer writer = new FileWriter(file)) {
      for (ContactData contact : contacts){
        writer.write(String.format("%s;%s;%s;%s;%s;\n", contact.getContactName(), contact.getContactSecondName(), contact.getContactAddress(), contact.getContactHomePhone(),
                contact.getContactEmail()));
      }
    }
  }

  private GroupData selectContact() {
    Groups groups = app.db().groups();
    String groupName = groups.iterator().next().getName();
    return new GroupData();
  }

   private  List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    Groups groups = app.db().groups();

    for (int i = 0; i < count; i++) {
      ContactData newContact = new ContactData().withContactName((String.format("Asya %s", i))).withContactSecondName(String.format("Kas %s", i)).withContactAddress(String.format("address %s", i))
              .withContactHomePhone(String.format("+7 495 111 11 1%s", i)).withContactEmail(String.format("a.kas%s@mail.ru", i)).inGroup(groups.iterator().next());
      contacts.add(newContact);
    }
    return contacts;
  }*/
}
