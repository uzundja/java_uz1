package ru.stqa.pft.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testsContactCreation() {
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData("Антон","Викторович","Торбинский","uzundja","Севастополь","uzundja@mail.ru","test1");
    app.getContactHelper().createContact (contact,true);
    List<ContactData> after= app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size() + 1);

    int max = 0;
    for (ContactData g : after ) {
      if (g.getId() > max) {
        max = g.getId();
      }
    }
    contact.setId(max);
    before.add (contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

  }
}
