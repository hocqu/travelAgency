package menu;

import Entities.Customer;
import Entities.CustomersForJSON;
import Entities.Tour;
import menu.Menu;
import readWrite.write.JsonWriter;
import repo.CustomerRepo;
import repo.TourRepo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class SerializeTours extends Menu {
    public static final String ENTER_FILENAME = "Введите имя файла";
    public static final String LOAD_IS_COMPLETE = "Экспортирование завершено успешно";
    private CustomerRepo customerRepo = new CustomerRepo();
    private TourRepo tourRepo = new TourRepo();
    private static SerializeTours menu;
    private final Scanner scanner = new Scanner(System.in);

    private SerializeTours() throws SQLException {
    }

    public static SerializeTours getInstance() throws SQLException {
        if (menu == null) {
            menu = new SerializeTours();
        }
        return menu;
    }

    @Override
    public void getMenu() {
        System.out.println(ENTER_FILENAME);
        String filename = scanner.nextLine();
        Map<Integer, List<Tour>> tours = new TreeMap<>();
        List<Customer> clist = customerRepo.findAll();
        List<Tour> tlist = tourRepo.findAll();
        for (Tour t1 : tlist) {
            if (!tours.containsKey(t1.getCustomer_id())) {
                List<Tour> custTour = new ArrayList<Tour>() {{
                    add(t1);
                }};
                tours.put(t1.getCustomer_id(), custTour);
            } else {
                List<Tour> tours1 = tours.get(t1.getCustomer_id());
                tours1.add(t1);
                tours.put(t1.getCustomer_id(), tours1);
            }
        }
        Set<Map.Entry<Integer, List<Tour>>> entrySet = tours.entrySet();
        for (Map.Entry<Integer, List<Tour>> m1 : entrySet) {
            for (Customer c1 : clist) {
                if (c1.getId().equals(m1.getKey())) {
                    c1.setTours(m1.getValue());
                }
            }
        }
        JsonWriter jw = new JsonWriter();
        CustomersForJSON customers = new CustomersForJSON(clist);
        try {
            jw.writeJson(customers, filename);
            System.out.println(LOAD_IS_COMPLETE);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}