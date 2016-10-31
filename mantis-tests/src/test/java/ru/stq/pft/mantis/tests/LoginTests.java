package ru.stq.pft.mantis.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stq.pft.mantis.appmanager.HttpSession;

import java.io.IOException;

import static org.testng.Assert.*;

/**
 * Created by A.Kasimova on 31.10.2016.
 */
public class LoginTests extends TestBase {

  @Test
  public void testLogin() throws IOException {
    HttpSession session = app.newSession();
    assertTrue(session.login("administrator", "root1"));
    assertTrue(session.isLoggedInAs("administrator"));
  }
}
