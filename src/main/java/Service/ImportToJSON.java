package Service;

import Entities.Customer;
import Entities.CustomersForJSON;
import Entities.Tour;
import readWrite.write.JsonWriter;
import repo.CustomerRepo;
import repo.TourRepo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;


public class ImportToJSON {
    public ImportToJSON() throws SQLException {
    }

    CustomerRepo customerRepo = new CustomerRepo();
    TourRepo tourRepo = new TourRepo();

    private List<Tour> tours = new ArrayList<>();
    public static final List<Customer> CUSTOMER_LIST = new ArrayList<>();
    public List<Customer> clist = new ArrayList<>();
    public List<Tour> tlist = new ArrayList<>();
    public List<Tour> custTour = new ArrayList<>();
    Scanner scanner=new Scanner(System.in);

    public void add() {
        System.out.println("Введите название файла");
        String filename=scanner.nextLine();
        filename=filename.concat(".json");
        Map<Integer, List<Tour>> tours = new TreeMap<>();
        clist = customerRepo.findAll();
        tlist = tourRepo.findAll();
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
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
