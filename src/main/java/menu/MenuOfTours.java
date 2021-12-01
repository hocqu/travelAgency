package menu;


import Entities.Customer;
import Entities.Tour;
import Utils.IntegerInput;
import repo.TourRepo;

import java.sql.SQLException;
import java.util.List;

public class MenuOfTours extends Menu {

    private static final String LIST_OF_TOURS = "Список всех туров:";
    private static final String NO_TOURS = "Туров нет";
    private static final String GO_BACK = "1. Назад";
    private static final String NO_OPERATION = "Такой операции нету. Повторите попытку";

    private static TourRepo tourRepo;
    IntegerInput integerInput=new IntegerInput();

    static {
        try {
            tourRepo = new TourRepo();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static int operationNumber;
    private static MenuOfTours menu;

    private MenuOfTours() {
    }

    public static MenuOfTours getInstance() {
        if (menu == null) {
            menu = new MenuOfTours();
        }
        return menu;
    }

    @Override
    public void getMenu() {
        boolean exit = false;
        System.out.println(LIST_OF_TOURS);
        final List<Tour> tours = tourRepo.findAll();
        if (tours.size() > 0) {
            tours.forEach(System.out::println);
        } else {
            System.out.println(NO_TOURS);
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