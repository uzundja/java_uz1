package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModifications(){
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Антон","Викторович","Торбинский", "uzundja","Севастополь","uzunda@mail.ru","test1"),true);
    }
    int before = app.getContactHelper().getContactCount();
    app.getNavigationHelper().gotoHome ();
    app.getContactHelper().modifyContact();
    app.getContactHelper().fillContactForm(new ContactData("Антон1","Викторович1","Торбинский1", "uzundja","Севастополь","uzunda@mail.ru",null),false);
    app.getContactHelper().updateContact();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after,before);
  }
}
