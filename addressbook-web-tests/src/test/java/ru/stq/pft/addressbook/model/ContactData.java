package ru.stq.pft.addressbook.model;

public class ContactData {
  private final String contactName;
  private final String contactSecondName;
  private String group;
  private final String contactAddress;
  private final String contactHomePhone;
  private final String contactEmail;

  public ContactData(String contactName, String contactSecondName, String group, String contactAddress, String contactHomePhone, String contactEmail) {
    this.contactName = contactName;
    this.contactSecondName = contactSecondName;
    this.group = group;
    this.contactAddress = contactAddress;
    this.contactHomePhone = contactHomePhone;
    this.contactEmail = contactEmail;
  }

  public String getContactName() {
    return contactName;
  }

  public String getContactSecondName() {
    return contactSecondName;
  }

  public String getContactAddress() {
    return contactAddress;
  }

  public String getContactHomePhone() {
    return contactHomePhone;
  }

  public String getContactEmail() {
    return contactEmail;
  }

  public String getGroup() {
    return group;
  }
}
