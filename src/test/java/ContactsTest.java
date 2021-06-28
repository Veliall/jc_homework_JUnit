import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
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
        assertThat(contacts.getContacts(), hasEntry(contact.getPhone(), contact));
        assertThat(testContacts, equalTo(true));
    }

    @Test
    void testAddTheSameContact() {
        //given
        contacts.addContact(contact);

        //when
        final boolean testContacts = contacts.addContact(contact);

        //then
        assertThat(testContacts, equalTo(false));
    }

    @Test
    void testSearchByPhone() {
        //given
        contacts.addContact(contact);
        final String phone = "+1111111";

        //when
        final Contact testContact = contacts.searchByPhone(phone);

        //then
        assertThat(testContact.getPhone(), equalTo(phone));

    }

    @Test
    void testSearchByPhoneWithUnknownPhone() {
        //given
        contacts.addContact(contact);
        final String phone = "+999999999";

        //then
        assertThat(contacts.searchByPhone(phone), nullValue());
    }
}