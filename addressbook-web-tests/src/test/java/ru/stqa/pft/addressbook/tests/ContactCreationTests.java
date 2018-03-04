package ru.stqa.pft.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testsContactCreation() {
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().createContact(new ContactData("Антон","Викторович","Торбинский","uzundja","Севастополь","uzundja@mail.ru","test1"),true);
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after,before + 1);
  }
}
