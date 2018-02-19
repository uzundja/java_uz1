package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletetion(){
    app.getNavigationHelper().gotoHome ();
    app.getContactHelper().selectAllContact ();
    app.getContactHelper().deleteContact();
    app.getContactHelper().Accept();
  }
  }
