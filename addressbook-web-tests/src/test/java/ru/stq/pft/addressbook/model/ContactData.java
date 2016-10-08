package ru.stq.pft.addressbook.model;

public class ContactData {
  private final int id;
  private final String contactName;
  private final String contactSecondName;
  private String group;
  private final String contactAddress;
  private final String contactHomePhone;
  private final String contactEmail;

  public ContactData(int id, String contactName, String contactSecondName, String group, String contactAddress, String contactHomePhone, String contactEmail) {
    this.id = id;
    this.contactName = contactName;
    this.contactSecondName = contactSecondName;
    this.group = group;
    this.contactAddress = contactAddress;
    this.contactHomePhone = contactHomePhone;
    this.contactEmail = contactEmail;
  }

  public ContactData(String contactName, String contactSecondName, String group, String contactAddress, String contactHomePhone, String contactEmail) {
    this.id = 0;
    this.contactName = contactName;
    this.contactSecondName = contactSecondName;
    this.group = group;
    this.contactAddress = contactAddress;
    this.contactHomePhone = contactHomePhone;
    this.contactEmail = contactEmail;
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

  public String getContactEmail() {
    return contactEmail;
  }

  public String getGroup() {
    return group;
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
