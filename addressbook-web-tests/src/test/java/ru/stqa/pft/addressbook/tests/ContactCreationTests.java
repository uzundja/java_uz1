package ru.stqa.pft.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Set;

public class ContactCreationTests extends TestBase {

  @Test (enabled = true)
  public void testsContactCreation() {
    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData()
            .withFirstname("Антон")
            .withMiddlename("Викторович")
            .withLastname("Торбинский")
            .withNickname("uzundja")
            .withAddress("Севастополь")
            .withEmail("uzundja@mail.ru")
            .withGroup("test1");
    app.contact().create(contact,true);
    Set<ContactData> after= app.contact().all();
    Assert.assertEquals(after.size(),before.size() + 1);

    contact.withId(after.stream().mapToInt((c)-> c.getId()).max().getAsInt());
    before.add (contact);
    Assert.assertEquals(before,after);
  }
}
