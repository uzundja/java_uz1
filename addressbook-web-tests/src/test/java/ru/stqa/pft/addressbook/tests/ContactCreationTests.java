package ru.stqa.pft.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test (enabled = true)
  public void testsContactCreation() {
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData("Антон","Викторович","Торбинский","uzundja","Севастополь","uzundja@mail.ru","test1");
    app.contact().create(contact,true);
    List<ContactData> after= app.contact().list();
    Assert.assertEquals(after.size(),before.size() + 1);
    contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add (contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(),g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);
  }
}
