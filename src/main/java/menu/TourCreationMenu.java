package menu;


import Entities.Customer;
import Entities.Tour;
import Service.EmailInput;
import Utils.IntegerInput;
import repo.CustomerRepo;
import repo.TourRepo;

import java.sql.SQLException;
import java.util.Scanner;

public class TourCreationMenu extends Menu {
    private static final String TOUR_PAY = "Оплата заказа:\n" +
            "1. Оплачено\n" +
            "2. Не оплачено";
    private static final String ENTER_TOUR_NAME = "Укажите место куда хотите отправиться";
    private static final String ENTER_CUSTOMER_EMAIL = "Введите электронную  почту клиента";
    private static final String ENTER_TOUR_TYPE = "Выберите тип тура:\n" +
            "1.Excursion\n" +
            "2.Relax\n" +
            "3.Shopping ";
    private static final String ENTER_BURNING = "Выберите горящий тур или нет:\n" +
            "1.Горящий\n" +
            "2.Не горящий";
    private static final String ENTER_TOUR_DATE = "Укажите дату начала тура в таком порядке:\n" +
            "Год, месяц, день";
    private static final String TOUR_APPROVED = "Тур принят";
    private static final String TOUR_DECLINED = "Тур отклонён";
    private static final String NO_OPERATION = "Такой операции нету. Повторите попытку";
    private static final String ENTER_DAY_IN_TOUR = "Введите длительность тура";
    private static final String ENTER_PRICE = "Укажите стоимость тура";

    private static IntegerInput integerInput = new IntegerInput();
    private EmailInput emailInput = new EmailInput();
    private CustomerRepo customerRepo = new CustomerRepo();
    private TourRepo tourRepo=new TourRepo();
    private static TourCreationMenu menu;
    private final Scanner scanner = new Scanner(System.in);
    private int operationNumber;

    private TourCreationMenu() throws SQLException {
    }

    public static TourCreationMenu getInstance() throws SQLException {
        if (menu == null) {
            menu = new TourCreationMenu();
        }
        return menu;
    }


    @Override
    public void getMenu() throws SQLException {
        boolean exit = false;
        boolean typeValid = false;
        boolean burningValid=false;
//      Клиент говорит свой email если такого пользователя нету то он создается
        System.out.println(ENTER_CUSTOMER_EMAIL);
        Customer customer = emailInput.emailInput();
//      Клиент указывает место для тура
        System.out.println(ENTER_TOUR_NAME);
        String city = scanner.nextLine();
//      Клиент выбирает тип тура
        String tourType="";
        do {
            System.out.println(ENTER_TOUR_TYPE);
            int choice = integerInput.integerInput();
            switch (choice) {
                case 1:
                    tourType = "Excursion";
                    typeValid = true;
                    break;
                case 2:
                    tourType = "Relax";
                    typeValid = true;
                    break;
                case 3:
                    tourType = "Shopping";
                    typeValid = true;
                    break;
                default:
                    System.out.println("Введите правильно тип тура");
                    break;
            }
        } while (!typeValid);
//      Клиент указывает дату отправления в тур
        System.out.println(ENTER_TOUR_DATE);
        int year = integerInput.yearInput();
        int month = integerInput.monthInput();
        int day = integerInput.dayInput();
        String departureDate = year + "-" + month + "-" + day;
//      Клиент указывает длительность тура
        System.out.println(ENTER_DAY_IN_TOUR);
        int dayInTour = integerInput.integerInput();
//      Администратор указывает стоимость тура
        System.out.println(ENTER_PRICE);
        int price = integerInput.integerInput();
//      Администратор выбирает горящий тур или нет
        boolean burning=false;
        do {
            System.out.println(ENTER_BURNING);
            int choice = integerInput.integerInput();
            switch (choice) {
                case 1:
                    burning = true;
                    burningValid = true;
                    break;
                case 2:
                    burning = false;
                    burningValid = true;
                    break;
                default:
                    System.out.println("Укажите правильное значение");
                    break;
            }
        } while (!burningValid);
//        Стоимость заказа рассчитывается из указанной стоимости автомобиля за сутки и срока аренды
        int burningSale=0;
        if (burning){
            burningSale=price-price/10;
        }
        price=price-price/100*customer.getSale()-burningSale;
        System.out.println("Получился такой тур\n" +
                "Город-"+city+
                "\nСтоимость со всеми скидками-"+price);
       do {
           System.out.println(TOUR_PAY);
            operationNumber = integerInput.integerInput();
            switch (operationNumber) {
                case 1:
                        Tour tour=new Tour(1,customer.getId(),tourType,departureDate,dayInTour,city,price,burning);
                        if(customer.getSale() < 25){
                            customerRepo.updateSale(customerRepo.findByEmail(customer.getEmail()).getId(),
                                    customer.getSale()+5);}
                        tourRepo.add(tour);
                        System.out.println(TOUR_APPROVED);
                    exit = true;
                    break;
                case 2:
                        System.out.println(TOUR_DECLINED);
                    exit = true;
                    break;
                default:
                    System.out.println(NO_OPERATION);
                    break;
            }
        } while (!exit);
    }


}