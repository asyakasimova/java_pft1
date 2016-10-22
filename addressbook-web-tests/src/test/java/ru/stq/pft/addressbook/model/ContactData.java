package ru.stq.pft.addressbook.model;

import java.io.File;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private String contactName;
  private String contactSecondName;
  private String group;
  private String contactAddress;
  private String contactHomePhone;
  private String contactMobilePhone;
  private String contactWorkPhone;
  private String allPhones;
  private String contactEmail;
  private String contactEmail2;
  private String contactEmail3;
  private String emails;
  private File photo;

  public File getPhoto() {
    return photo;
  }

  public int getId() {
    return id;
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

  public String getContactMobilePhone() {
    return contactMobilePhone;
  }

  public String getContactWorkPhone() {
    return contactWorkPhone;
  }

  public String getContactEmail() {
    return contactEmail;
  }

  public String getContactEmail2() {
    return contactEmail2;
  }

  public String getContactEmail3() {
    return contactEmail3;
  }

  public String getGroup() {
    return group;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public String getEmails() {
    return emails;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  public ContactData withEmails(String emails) {
    this.emails = emails;
    return this;
  }

  public ContactData withContactEmail2(String contactEmail2) {
    this.contactEmail2 = contactEmail2;
    return this;
  }

  public ContactData withContactEmail3(String contactEmail3) {
    this.contactEmail3 = contactEmail3;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withContactName(String contactName) {
    this.contactName = contactName;
    return this;
  }

  public ContactData withContactSecondName(String contactSecondName) {
    this.contactSecondName = contactSecondName;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactData withContactAddress(String contactAddress) {
    this.contactAddress = contactAddress;
    return this;
  }

  public ContactData withContactHomePhone(String contactHomePhone) {
    this.contactHomePhone = contactHomePhone;
    return this;
  }
  public ContactData withContactMobilePhone(String contactMobilePhone) {
    this.contactMobilePhone = contactMobilePhone;
    return this;
  }

  public ContactData withContactWorkPhone(String contactWorkPhone) {
    this.contactWorkPhone = contactWorkPhone;
    return this;
  }

  public ContactData withContactEmail(String contactEmail) {
    this.contactEmail = contactEmail;
    return this;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", contactName='" + contactName + '\'' +
            ", contactSecondName='" + contactSecondName + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (contactName != null ? !contactName.equals(that.contactName) : that.contactName != null) return false;
    return contactSecondName != null ? contactSecondName.equals(that.contactSecondName) : that.contactSecondName == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (contactName != null ? contactName.hashCode() : 0);
    result = 31 * result + (contactSecondName != null ? contactSecondName.hashCode() : 0);
    return result;
  }
}
