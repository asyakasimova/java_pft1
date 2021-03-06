package ru.stq.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class ContactData {
  @XStreamOmitField
  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;
  @Expose
  @Column(name = "firstname")
  private String contactName;
  @Expose
  @Column(name = "lastname")
  private String contactSecondName;

  @Expose
  @Column(name = "address")
  @Type(type = "text")
  private String contactAddress;
  @Expose
  @Column(name = "home")
  @Type(type = "text")
  private String contactHomePhone;
  @Expose
  @Column(name = "mobile")
  @Type(type = "text")
  private String contactMobilePhone;
  @Expose
  @Column(name = "work")
  @Type(type = "text")
  private String contactWorkPhone;
  @Expose
  @Transient
  private String allPhones;
  @Expose
  @Column(name = "email")
  @Type(type = "text")
  private String contactEmail;
  @Expose
  @Transient
  private String contactEmail2;
  @Expose
  @Transient
  private String contactEmail3;
  @Expose
  @Transient
  private String emails;
  @Expose
  @Transient
  @Column(name = "photo")
  @Type(type = "text")
  private String photo;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "address_in_groups", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
  private Set<GroupData> groups = new HashSet<GroupData>();



  public File getPhoto() {
    if (photo == null) {
      return null;
    }  else {
      return new File(photo); }
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

  public String getAllPhones() {
    return allPhones;
  }

  public String getEmails() {
    return emails;
  }

  public Groups getGroups() {
    return new Groups(groups);
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
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
            ", contactAddress='" + contactAddress + '\'' +
            ", contactHomePhone='" + contactHomePhone + '\'' +
            ", contactMobilePhone='" + contactMobilePhone + '\'' +
            ", contactWorkPhone='" + contactWorkPhone + '\'' +
            ", contactEmail='" + contactEmail + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (contactName != null ? !contactName.equals(that.contactName) : that.contactName != null) return false;
    if (contactSecondName != null ? !contactSecondName.equals(that.contactSecondName) : that.contactSecondName != null)
      return false;
    if (contactAddress != null ? !contactAddress.equals(that.contactAddress) : that.contactAddress != null)
      return false;
    if (contactHomePhone != null ? !contactHomePhone.equals(that.contactHomePhone) : that.contactHomePhone != null)
      return false;
    return contactEmail != null ? contactEmail.equals(that.contactEmail) : that.contactEmail == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (contactName != null ? contactName.hashCode() : 0);
    result = 31 * result + (contactSecondName != null ? contactSecondName.hashCode() : 0);
    result = 31 * result + (contactAddress != null ? contactAddress.hashCode() : 0);
    result = 31 * result + (contactHomePhone != null ? contactHomePhone.hashCode() : 0);
    result = 31 * result + (contactEmail != null ? contactEmail.hashCode() : 0);
    return result;
  }

  public ContactData inGroup(GroupData group) {
    groups.add(group);
    return this;
  }
}
