package ru.stq.pft.mantis.tests;

import org.testng.annotations.Test;

/**
 * Created by A.Kasimova on 31.10.2016.
 */
public class RegistrationTests extends TestBase {

  @Test
  public void testRegistration() {
    app.registration().start("user1", "user1@localhost.localdomain");
  }
}
