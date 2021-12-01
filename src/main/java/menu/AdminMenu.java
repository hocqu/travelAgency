package menu;

import Utils.IntegerInput;

import java.sql.SQLException;

public class AdminMenu extends Menu {

    private static IntegerInput integerInput=new IntegerInput();
    private static final String MAIN_MENU = "Меню администратора:\n" +
            "1. Новый заказ\n" +
            "2. Список всех клиентов\n" +
            "3. Список всех заказов\n" +
            "4. Экспортировать(Сериализация) все заказы в JSON файл\n" +
            "5. Имортировать(Дисериализация) данные о заказах в бд\n" +
            "6. Выход";
    private static final String NO_OPERATION = "Такой операции нету. Повторите попытку";
    private static final String EXIT = "Закрытие программы";
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