package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModifications(){
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Антон","Викторович","Торбинский", "uzundja","Севастополь","uzunda@mail.ru","test1"),true);
    }
    app.getContactHelper().gotoHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().modifyContact();
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(),"Антон1","Викторович1","Торбинский1", "uzundja","Севастополь","uzunda@mail.ru",null);
    app.getContactHelper().fillContactForm(contact,false);
    app.getContactHelper().updateContact();
    app.getContactHelper().gotoHomePage();
    List<ContactData> after= app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(),g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
