package menu;


import Entities.Customer;
import Utils.IntegerInput;
import repo.CustomerRepo;

import java.sql.SQLException;
import java.util.List;

public class MenuOfCustomers extends Menu {

    private static final String LIST_OF_CUSTOMERS = "Список всех клиентов:";
    private static final String NO_CUSTOMERS = "Клиентов нет";
    private static final String GO_BACK = "1. Назад";
    private static final String NO_OPERATION = "Такой операции нету. Повторите попытку";

    private static CustomerRepo customerRepo;
    IntegerInput integerInput=new IntegerInput();

    static {
        try {
            customerRepo = new CustomerRepo();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static int operationNumber;
    private static MenuOfCustomers menu;

    private MenuOfCustomers() {
    }

    public static MenuOfCustomers getInstance() {
        if (menu == null) {
            menu = new MenuOfCustomers();
        }
        return menu;
    }

    @Override
    public void getMenu() {
            boolean exit = false;
            System.out.println(LIST_OF_CUSTOMERS);
            final List<Customer> customers = customerRepo.findAll();
            if (customers.size() > 0) {
                customers.forEach(System.out::println);
            } else {
                System.out.println(NO_CUSTOMERS);
            }
            do {
                System.out.println(GO_BACK);
                operationNumber = integerInput.integerInput();
                if (operationNumber == 1) {
                    exit = true;
                } else {
                    System.out.println(NO_OPERATION);
                }
            } while (!exit);
    }
}