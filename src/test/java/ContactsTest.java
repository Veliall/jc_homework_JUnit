import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by Igor Khristiuk on 27.06.2021
 */
class ContactsTest {

    Contacts contacts;
    Contact contact;

    @BeforeEach
    void init() {
        contacts = new Contacts();
        contact = new Contact("Test", "Testovich", "+1111111", Group.WORK);
    }

    @Test
    void testAddContact_NullArgument_throwsException() {
        //expect:
        assertThrows(NullPointerException.class, () -> {
            contacts.addContact(null);
        });
    }

    @Test
    void testAddContact() {
        //when
        final boolean testContacts = contacts.addContact(contact);

        //then
        Assertions.assertTrue(testContacts);
    }

    @Test
    void testAddTheSameContact() {
        //given
        contacts.addContact(contact);

        //when
        final boolean testContacts = contacts.addContact(contact);

        //then
        Assertions.assertFalse(testContacts);
    }

    @Test
    void testSearchByPhone() {
        //given
        contacts.addContact(contact);
        final String phone = "+1111111";

        //when
        final Contact testContact = contacts.searchByPhone(phone);

        //then
        Assertions.assertEquals(phone, testContact.getPhone());

    }

    @Test
    void testSearchByPhoneWithUnknownPhone() {
        //given
        contacts.addContact(contact);
        final String phone = "+999999999";

        //then
        Assertions.assertNull(contacts.searchByPhone(phone));
    }
}