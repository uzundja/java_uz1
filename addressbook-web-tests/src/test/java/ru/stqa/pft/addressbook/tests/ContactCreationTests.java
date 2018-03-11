package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Set;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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
    assertThat(after.size(),equalTo(before.size() + 1));

    contact.withId(after.stream().mapToInt((c)-> c.getId()).max().getAsInt());
    before.add (contact);
    assertThat(after, equalTo(before));
  }
}
