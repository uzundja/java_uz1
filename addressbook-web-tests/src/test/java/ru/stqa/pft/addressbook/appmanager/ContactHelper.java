package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

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
    if (creation){
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
      }else{
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  // Подтвердить создание контакта
  public void submitContact() {
    click(By.name("submit"));
  }
  // Нажать модифицировать контакт
  public void modifyContact() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
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


}

