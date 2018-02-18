package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupHelper {
  private FirefoxDriver wd;

  public GroupHelper(FirefoxDriver wd) {
    this.wd = wd;
  }

  // Вернуться на страницу Групп
  public void returnToGroupPage() {
    wd.findElement(By.linkText("group page")).click();
  }

  // Подтвердить создание Группы
  public void submitGroupCreation() {
    wd.findElement(By.name("submit")).click();
  }

  // Заполнение формы
  public void fillGroupForm(GroupData groupData) {
    wd.findElement(By.name("group_name")).click();
    wd.findElement(By.name("group_name")).clear();
    wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
    wd.findElement(By.name("group_header")).click();
    wd.findElement(By.name("group_header")).clear();
    wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
    wd.findElement(By.name("group_footer")).click();
    wd.findElement(By.name("group_footer")).clear();
    wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
  }

  // Создание нвоой групыы
  public void initGroupCreation() {
    wd.findElement(By.name("new")).click();
  }

  // Удаление выбранных групп
  public void deleteSelectedGroups() {
    wd.findElement(By.name("delete")).click();
  }

  // Выбрать группу
  public void selectGroup() {
    wd.findElement(By.name("selected[]")).click();
  }
}
