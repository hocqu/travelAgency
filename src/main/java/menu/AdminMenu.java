package menu;

import Utils.IntegerInput;

import java.sql.SQLException;

public class AdminMenu extends Menu {

    private static IntegerInput integerInput=new IntegerInput();
    private static final String MAIN_MENU = "Menu:\n" +
            "1. New order\n" +
            "2. List of customers\n" +
            "3. List of orders\n" +
            "4. Export (Serialize) all orders to JSON file\n" +
            "5. Import (Disserialize) order data into the database\n" +
            "6. Exit";
    private static final String NO_OPERATION = "There is no such operation. Try again";
    private static final String EXIT = "Closing";
    private static int operationNumber;

    private static AdminMenu adminMenu;

    private AdminMenu() {
    }

    public static AdminMenu getInstance() {
        if (adminMenu == null) {
            adminMenu = new AdminMenu();
        }
        return adminMenu;
    }

    @Override
    public void getMenu() throws SQLException {
        Menu menu = null;
        boolean exit = false;
        do {
            System.out.println(MAIN_MENU);
            operationNumber = integerInput.integerInput();
            switch (operationNumber) {
                case 1:
                    menu = TourCreationMenu.getInstance();
                    break;
                case 2:
                    menu = MenuOfCustomers.getInstance();
                    break;
                case 3:
                    menu = MenuOfTours.getInstance();
                    break;
               case 4:
                    menu = SerializeTours.getInstance();
                    break;
               case 5:
                    menu = DeserializeTours.getInstance();
                    break;
                case 6:
                    exit = true;
                    menu = null;
                    System.out.println(EXIT);
                    break;
                default:
                    System.out.println(NO_OPERATION);
                    menu=null;
                    break;
            }
            if (menu != null) {
                menu.getMenu();
            }

        } while (!exit);
    }
}