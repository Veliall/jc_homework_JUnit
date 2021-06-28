import java.util.HashMap;
import java.util.Map;

public class Contacts {
    private HashMap<String, Contact> contacts = new HashMap<>();

    public boolean addContact(Contact contact) {
        if (haveContact(contact.getPhone())) {
            return false;
        } else {
            contacts.put(contact.getPhone(), contact);
            return true;
        }
    }

    public boolean haveContact(String phone) {
        return contacts.containsKey(phone);
    }

    public Contact searchByPhone(String phone) {
        return contacts.getOrDefault(phone, null);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Map.Entry<String, Contact> contactsPair : contacts.entrySet()) {
            s.append(contactsPair.getValue().toString()).append("\n");
        }
        return s.toString();
    }

    public HashMap<String, Contact> getContacts() {
        return contacts;
    }
}
