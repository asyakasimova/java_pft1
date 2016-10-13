package ru.stq.pft.addressbook.model;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private String contactName;
  private String contactSecondName;
  private String group;
  private String contactAddress;
  private String contactHomePhone;
  private String contactEmail;

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

  public String getContactEmail() {
    return contactEmail;
  }

  public String getGroup() {
    return group;
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
