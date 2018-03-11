package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTest extends TestBase {
  @BeforeMethod
  public void ensurePrecondition() {
    if (app.contact().list().size() == 0){
      app.contact().create(new ContactData("Антон","Викторович","Торбинский", "uzundja","Севастополь","uzunda@mail.ru","test1"),true);
    }
    app.contact().homepage();
  }

  @Test (enabled = true)
  public void testContactDeletion() {
    app.contact().homepage();
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    app.contact().delete(index);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove((index));
    Assert.assertEquals(before, after);
  }
}
