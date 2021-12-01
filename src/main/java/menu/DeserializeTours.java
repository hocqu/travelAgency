package menu;

import Entities.Customer;
import Entities.CustomersForJSON;
import Entities.Tour;
import menu.Menu;
import readWrite.read.CustomersForJSONReader;
import readWrite.read.JavaJsonReader;
import readWrite.write.JsonWriter;
import repo.CustomerRepo;
import repo.TourRepo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class DeserializeTours extends Menu {
    public static final String ENTER_FILENAME = "Введите имя файла";
    public static final String LOAD_IS_COMPLETE = "Импортирование завершено";
    private CustomerRepo customerRepo = new CustomerRepo();
    private TourRepo tourRepo = new TourRepo();
    private static DeserializeTours menu;
    private final Scanner scanner = new Scanner(System.in);

    private DeserializeTours() throws SQLException {
    }

    public static DeserializeTours getInstance() throws SQLException {
        if (menu == null) {
            menu = new DeserializeTours();
        }
        return menu;
    }

    @Override
    public void getMenu() {
        List<Customer> customerList=new ArrayList<>();
        JavaJsonReader jr = new CustomersForJSONReader();
        System.out.println(ENTER_FILENAME);
        String filename=scanner.nextLine();
        customerList.addAll(jr.readJson(filename));
        for (Customer customer : customerList) {
            Customer sqlCust=customerRepo.findByEmail(customer.getEmail());
            if(!(sqlCust==null)){
                System.out.println("Пользователь "+customer.getName()+" уже существует");
            }
            else{
                Customer c1=new Customer(customer.getId(),customer.getName(), customer.getPhone(), customer.getEmail(), customer.getSale());
                customerRepo.add(c1);
            }}
        System.out.println("Клиенты перенесены");
        //Импорт туров из JSON созданным в java в SQL
        for (Customer customer : customerList) {
            for (Tour  tour : customer.getTours()){
                Tour sqlTour=tourRepo.findByCity(tour.getCity());
                if(!(sqlTour==null) || sqlTour.equals(tour)) {
                    System.out.println("Тур: "+sqlTour.getCity()+" уже существует");
                }else
                {
                    Tour t1 = new Tour(tour.getId(), customerRepo.findByEmail(customer.getEmail()).getId(), tour.getTourType(), tour.getDepartureDate(), tour.getDaysInTour(),
                            tour.getCity(), tour.getCost(), tour.getBurning());
                    tourRepo.add(t1);
                    System.out.println(LOAD_IS_COMPLETE);
                }
            }
        }
    }
}