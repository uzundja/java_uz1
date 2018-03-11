package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase{

  @BeforeMethod
  public void ensurePrecondition() {
    if (app.contact().all().size() == 0){
      app.contact().create(new ContactData().withFirstname("Антон").withMiddlename("Викторович").withLastname("Торбинский").withNickname("uzundja")
              .withAddress("Севстополь").withEmail("uzundja@mail.ru").withGroup("test1"),true);
    }
    app.contact().homepage();
  }

  @Test (enabled = true)
  public void testContactModifications(){
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId())
            .withFirstname("Антон1")
            .withMiddlename("Викторович1")
            .withLastname("Торбинский1")
            .withNickname("uzundja")
            .withAddress("Севастополь")
            .withEmail("uzunda@mail.ru");
    app.contact().modify(contact);
    Contacts after= app.contact().all();
    assertEquals(after.size(), before.size());
    assertThat(after, CoreMatchers.equalTo(before.without(modifiedContact).withAdded(contact)));
  }
}
