package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase{

  @BeforeMethod
  public void ensurePrecondition() {
    if (app.contact().list().size() == 0){
      app.contact().create(new ContactData().withFirstname("Антон").withMiddlename("Викторович").withLastname("Торбинский").withNickname("uzundja")
              .withAddress("Севстополь").withEmail("uzundja@mail.ru").withGroup("test1"),true);
    }
    app.contact().homepage();
  }

  @Test (enabled = true)
  public void testContactModifications(){
    List<ContactData> before = app.contact().list();
    int index = before.size() -1;
    ContactData contact = new ContactData()
            .withId(before.get(index).getId())
            .withFirstname("Антон1")
            .withMiddlename("Викторович1")
            .withLastname("Торбинский1")
            .withNickname("uzundja")
            .withAddress("Севастополь")
            .withEmail("uzunda@mail.ru");
    app.contact().modify(index, contact);

    List<ContactData> after= app.contact().list();
    Assert.assertEquals(after.size(),before.size());
    before.remove (index);
    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(),g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
