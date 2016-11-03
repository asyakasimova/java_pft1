package ru.stq.pft.mantis.model;

/**
 * Created by A.Kasimova on 02.11.2016.
 */
public class MailMessage {

  public String to;
  public String text;

  public MailMessage(String to, String text) {
    this.to = to;
    this.text = text;
  }
}
