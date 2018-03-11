package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;
import java.util.Set;

public class ContactDeletionTest extends TestBase {
  @BeforeMethod
  public void ensurePrecondition() {
    if (app.contact().all().size() == 0){
      app.contact().create(new ContactData().withFirstname("Антон").withMiddlename("Викторович").withLastname("Торбинский").withNickname("uzundja")
              .withAddress("Севстополь").withEmail("uzundja@mail.ru").withGroup("test1"),true);
    }
    app.contact().homepage();
  }

  @Test (enabled = true)
  public void testContactDeletion() {
    app.contact().homepage();
    Set<ContactData> before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deletedContact);
    Assert.assertEquals(before, after);
  }
}
