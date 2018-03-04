package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupHelper extends HelperBase {
  GroupHelper(WebDriver wd) {
    super(wd);
  }

  // Вернуться на страницу Групп
  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  // Подтвердить создание Группы
  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  // Заполнение формы
  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  // Создание нвоой групыы
  public void initGroupCreation() {
    click(By.name("new"));
  }

  // Удаление выбранных групп
  public void deleteSelectedGroups() {
    click(By.name("delete"));
  }

  // Выбрать группу
  public void selectGroup() {
    click(By.name("selected[]"));
  }

  // Изменить Группу
  public void initGroupModification() {
    click(By.name("edit"));
  }

  // Обновить Группу
  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void createGroup(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    returnToGroupPage();
  }

  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getGroupCount() {
    return wd.findElements(By.name("selected[]")).size();
  }
}
