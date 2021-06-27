import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

public class MissedCalls {
    private Map<LocalDateTime, String> missedCalls = new TreeMap<>();

    public Map<LocalDateTime, String> getMissedCalls() {
        return missedCalls;
    }

    public void addMissedCall(String phone, Contacts contacts) {

        if (contacts.searchByPhone(phone) != null) {
            Contact contact = contacts.searchByPhone(phone);
            missedCalls.put(LocalDateTime.now(), contact.getName() + " " + contact.getSurname());
        } else {
            missedCalls.put(LocalDateTime.now(), phone);
        }
        System.out.println("Вызов добавлен");
    }

    public void clearMissedCalls() {
        missedCalls.clear();
        System.out.println("Список очищен.");
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
        if (missedCalls.isEmpty()) {
            return "Список пуст";
        }
        StringBuilder s = new StringBuilder();
        for (Map.Entry<LocalDateTime, String> contactsPair : missedCalls.entrySet()) {
            s.append(dtf.format(contactsPair.getKey())).append(" ").append(contactsPair.getValue()).append("\n");
        }
        return s.toString();
    }
}
