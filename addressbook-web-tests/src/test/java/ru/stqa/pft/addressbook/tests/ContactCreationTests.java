package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test (enabled = true)
  public void testsContactCreation() {
    Contacts before = app.contact().all();
    ContactData contact = new ContactData()
            .withFirstname("Антон")
            .withMiddlename("Викторович")
            .withLastname("Торбинский")
            .withNickname("uzundja")
            .withAddress("Севастополь")
            .withEmail("uzundja@mail.ru")
            .withGroup("test1");
    app.contact().create(contact,true);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo( before.size() + 1));
    assertThat(after,equalTo(before.withAdded(contact.withId(after.stream().mapToInt((p) -> p.getId()).max().getAsInt()))));
  }
}
