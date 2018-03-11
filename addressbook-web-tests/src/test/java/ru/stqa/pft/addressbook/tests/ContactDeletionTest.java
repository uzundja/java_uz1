package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

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
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Contacts after = app.contact().all();
    assertEquals(after.size(), before.size() - 1);
    assertThat(after, CoreMatchers.equalTo(before.without (deletedContact)));
  }
}
