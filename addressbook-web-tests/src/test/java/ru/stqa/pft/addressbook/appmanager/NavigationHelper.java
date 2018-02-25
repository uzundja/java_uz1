package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver wd) {
    super(wd);
}

  // Идти на страницу Групп
  public void gotoGroupPage() {
    if (isElementPresent(By.tagName("h1"))
            &&  wd.findElement(By.tagName("h1")).getText().equals("Groups")
            &&  isElementPresent(By.name("new"))) {
      return;
    }
    click(By.linkText("groups"));
  }



  // Идти на страницу Контактов
  public void gotoCreateContact() {
    click(By.linkText("add new"));
  }



  // Открыть страницу Home
  public void gotoHome() {
    if (isElementPresent(By.id("maintable"))){
      return;
    }
    click(By.linkText("home"));
  }
}
