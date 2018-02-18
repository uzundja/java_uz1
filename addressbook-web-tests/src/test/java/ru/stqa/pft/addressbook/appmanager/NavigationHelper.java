package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(FirefoxDriver wd) {
    super(wd);
}

  // Идти на страницу Групп
  public void gotoGroupPage() {
    click(By.linkText("groups"));
  }
  // Идти на страницу Контактов
  public void gotoCreateContact() {
    click(By.linkText("add new"));
  }
}
