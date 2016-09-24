package ru.stq.pft.addressbook;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase{


    @Test
    public void testContactDeletion() {


      app.selectContacts();
      app.deleteSelectedContacts();
      app.acceptDeletionContacts();
      app.returnToHomePage();
    }

}
