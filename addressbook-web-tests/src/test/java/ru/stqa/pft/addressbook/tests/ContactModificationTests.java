package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModifications(){
    app.getNavigationHelper().gotoHome ();
    app.getContactHelper().modifyContact();
    app.getContactHelper().fillContactForm(new ContactData("Антон1","Викторович1","Торбинский1", "uzundja","Севастополь","uzunda@mail.ru",null),false);
    app.getContactHelper().updateContact();
  }
}
