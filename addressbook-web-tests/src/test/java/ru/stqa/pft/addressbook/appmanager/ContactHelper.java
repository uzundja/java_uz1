package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {
  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  // Заполнить страницу контактов
  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("middlename"), contactData.getMiddlename());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("address"), contactData.getAddress());
    type(By.name("email"), contactData.getEmail());

    // Метод который позволяет заполнять форму которая то содержит элемент group то нет
    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  // на страницу нового контакта
  public void homepage() {
    click(By.linkText("home"));
  }

  // на страницу нового контакта
  public void gotoContactPage() {
    click(By.linkText("add new"));
  }

  // Подтвердить создание контакта
  public void submitContact() {
    click(By.name("submit"));
  }

  // Выбрать контакт
  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  // Нажать модифицировать контакт
  public void modifyContact(int index) {
    wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img")).get(index).click();
  }

  // Update контакт
  public void updateContact() {
    click(By.xpath("//input[@name='update']"));
  }

  // Выбрать все контакты
  public void selectAllContact() {
    click(By.id("MassCB"));
  }

  // Удалить все контакты
  public void deleteContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  // Закрыть окно
  public void Accept() {
    wd.switchTo().alert().accept();
  }

  // Создать контакт
  public void create(ContactData contact, boolean b) {
    gotoContactPage();
    fillContactForm(contact, b);
    submitContact();
    homepage();
  }

  // Модифицировать контакт
  public void modify(int index, ContactData contact) {
    modifyContact(index);
    fillContactForm(contact, false);
    updateContact();
    homepage();
  }

  // Удалить контакт
  public void delete(int index) {
    selectContact(index);
    deleteContact();
    Accept();
    homepage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("tr[name = 'entry']"));
    for (WebElement element : elements) {
      String name = element.findElement(By.xpath(".//td[3]")).getText();
      String lastName = element.findElement(By.xpath(".//td[2]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData().withId(id).withFirstname(name).withLastname(lastName);
      contacts.add(contact);
    }
    return contacts;
  }
}
