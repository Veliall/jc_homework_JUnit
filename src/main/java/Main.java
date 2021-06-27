import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Contacts contacts = new Contacts();
        MissedCalls missedCalls = new MissedCalls();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Меню: \n" +
                    "1. Добавить контакт \n" +
                    "2. Добавить пропущенный вызов \n" +
                    "3. Вывести все пропущенные вызовы\n" +
                    "4. Очистить пропущенные вызовы\n" +
                    "5. Выход");

            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 5) {
                System.out.println("Пока - пока");
                break;
            }
            switch (choice) {
                case 1 -> {
                    System.out.println("Введите данные контакта через пробед:" +
                            " имя, фамилия, телефон, группа (FAMILY, WORK, FRIENDS)");
                    String input = scanner.nextLine();
                    String[] dataContact = input.split(" ");
                    if (contacts.haveContact(dataContact[2])) {
                        System.out.printf("Номер %s уже внесён в телефонную книгу\n", dataContact[2]);
                    } else {
                        contacts.addContact(new Contact(dataContact[0], dataContact[1],
                                dataContact[2], Group.valueOf(dataContact[3])));
                        System.out.printf("Контакт %s %s успешно добавлен в телефонную книгу\n",
                                dataContact[0], dataContact[1]);
                    }
                }
                case 2 -> {
                    System.out.println("Введите номер пропущенного вызова");
                    String inputPhone = scanner.nextLine();
                    missedCalls.addMissedCall(inputPhone, contacts);
                }
                case 3 -> System.out.println(missedCalls.toString());
                case 4 -> missedCalls.clearMissedCalls();
            }
        }

    }
}
