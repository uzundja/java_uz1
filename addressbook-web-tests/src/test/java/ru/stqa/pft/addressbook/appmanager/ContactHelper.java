package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {
  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  // Заполнить страницу контактов
  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"),contactData.getFirstname());
    type(By.name("middlename"),contactData.getMiddlename());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"),contactData.getNickname());
    type(By.name("address"),contactData.getAddress());
    type(By.name("email"),contactData.getEmail());
  }

  // Подтвердить создание контакта
  public void submitContact() {
    click(By.name("submit"));
  }
}

