package Service;

import Entities.Customer;
import Utils.IntegerInput;
import Utils.PhoneNumber;
import menu.AdminMenu;
import repo.CustomerRepo;

import java.sql.SQLException;
import java.util.Scanner;

public class EmailInput {
    Scanner scanner = new Scanner(System.in);
    CustomerRepo customerRepo = new CustomerRepo();
    IntegerInput integerInput = new IntegerInput();
    private static final String NO_OPERATION = "Такой операции нету. Повторите попытку";
    private static final String AVAIBLE_REGISTRATION = "Пользователь успешно создан";

    public EmailInput() throws SQLException {
    }

    public Customer emailInput() throws SQLException {
        int valid;
        boolean emailValid = false;
        boolean choiceValid = false;
        Customer customer = null;
        String name;
        String phone;
        String email = scanner.nextLine();
        customer = customerRepo.findByEmail(email);
        if (customer == null) {
            valid = 3;
        } else {
            valid = 1;
        }
        do {
            switch (valid) {
                case 1:
                    do {
                        System.out.println("Имя пользователя: " + customer.getName() +
                                "\nДанные введены правильно?\n" +
                                "1.Да\n" +
                                "2.Создать нового пользователя\n" +
                                "3.Выход");
                        int choice = integerInput.integerInput();
                        switch (choice) {
                            case 1:
                                choiceValid = true;
                                emailValid = true;
                                break;
                            case 2:
                                valid = 2;
                                choiceValid = true;
                                break;
                            case 3:
                                choiceValid = true;

                                emailValid = true;
//                                AdminMenu.getInstance();
//                                AdminMenu.getInstance().getMenu();
                                break;
                            default:
                                System.out.println(NO_OPERATION);
                                break;
                        }
                    } while (!choiceValid);
                    break;
                case 2:
                    System.out.println("Регистрация нового пользователя");
                    System.out.println("Введите имя и фамилию пользователя");
                    name = scanner.nextLine();
                    System.out.println("Введите другой email");
                    String newEmail = scanner.nextLine();
                    System.out.println("Введите номер телефона");
                    phone = scanner.nextLine();
                    customer = new Customer(1, name, phone, newEmail, 0);
                    customerRepo.add(customer);
                    System.out.println(AVAIBLE_REGISTRATION);
                    emailValid = true;
                    break;
                case 3:
                    System.out.println("Регистрация нового пользователя");
                    System.out.println("Введите имя и фамилию пользователя");
                    name = scanner.nextLine();
                    System.out.println("Введите номер телефона");
                    phone = scanner.nextLine();
                    customer = new Customer(1, name, PhoneNumber.numberFormater(phone), email, 0);
                    customerRepo.add(customer);
                    System.out.println(AVAIBLE_REGISTRATION);
                    emailValid = true;
                    break;
            }
        } while (!emailValid);
        return customer;
    }
}
