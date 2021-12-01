//package Service;
//
//import Entities.AvaibleTours;
//import Entities.Customer;
//import Entities.Tour;
//import readWrite.read.CustomerJsonReader;
//import readWrite.read.CustomersForJSONReader;
//import readWrite.read.JavaJsonReader;
//import readWrite.read.JsonReader;
//import repo.AvaibleToursRepo;
//import repo.CustomerRepo;
//import repo.TourRepo;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ImportJSON {
//    CustomerRepo customerRepo=new CustomerRepo();
//    TourRepo tourRepo=new TourRepo();
//    AvaibleToursRepo avaibleToursRepo=new AvaibleToursRepo();
//
//    public ImportJSON() throws SQLException {
//    }
//
//    public void importCustomer(){ //Импорт клиентов из JSON в SQL
//        List<Customer> customerList=new ArrayList<>();
//        JsonReader jr = new CustomerJsonReader();
//        customerList.addAll(jr.readJson());
//        for (Customer customer : customerList) {
//
//            Customer sqlCust=customerRepo.findByEmail(customer.getEmail());
//            if(!(sqlCust==null)){
//                System.out.println("Пользователь "+customer.getName()+" уже существует");
//            }
//            else{
//                Customer c1=new Customer(customer.getId(),customer.getName(), customer.getPhone(), customer.getEmail(), customer.getSale());
//            customerRepo.add(c1);
//        }}
//        System.out.println("Клиенты перенесены");
//    }
//    public void importOrders(){ //Импорт туров из JSON в SQL
//        List<Customer> customerList=new ArrayList<>();
//        JsonReader jr = new CustomerJsonReader();
//        customerList.addAll(jr.readJson());
//        for (Customer customer : customerList) {
//            for (Tour  tour : customer.getTours()){
//                Tour t1=new Tour(tour.getId(),customer.getId(),tour.getTourType(),tour.getDepartureDate(),tour.getDaysInTour(),
//                        tour.getCity(),tour.getCost(),tour.getBurning());
//                tourRepo.add(t1);
//            }
//        }
//        System.out.println("Заказы перенесены");
//    }
//    public void importJavaCreatedCustomer(){ //Импорт клиентов из JSON созданным в java в SQL
//        List<Customer> customerList=new ArrayList<>();
//        JavaJsonReader jr = new CustomersForJSONReader();
//        customerList.addAll(jr.readJson());
//        for (Customer customer : customerList) {
//
//            Customer sqlCust=customerRepo.findByEmail(customer.getEmail());
//            if(!(sqlCust==null)){
//                System.out.println("Пользователь "+customer.getName()+" уже существует");
//            }
//            else{
//                Customer c1=new Customer(customer.getId(),customer.getName(), customer.getPhone(), customer.getEmail(), customer.getSale());
//                customerRepo.add(c1);
//            }}
//        System.out.println("Клиенты перенесены");
//    }
//    public void importJavaCreatedOrders(){ //Импорт туров из JSON созданным в java в SQL
//        List<Customer> customerList=new ArrayList<>();
//        JavaJsonReader jr = new CustomersForJSONReader();
//        customerList.addAll(jr.readJson());
//        for (Customer customer : customerList) {
//            for (Tour  tour : customer.getTours()){
//                Tour t1=new Tour(tour.getId(),customer.getId(),tour.getTourType(),tour.getDepartureDate(),tour.getDaysInTour(),
//                        tour.getCity(),tour.getCost(),tour.getBurning());
//                tourRepo.add(t1);
//            }
//        }
//        System.out.println("Заказы перенесены");
//    }
//    public void importJavaTours(){ //Импорт туров из JSON созданным в java в SQL
//        List<Customer> customerList=new ArrayList<>();
//        JavaJsonReader jr = new CustomersForJSONReader();
//        customerList.addAll(jr.readJson());
//        for (Customer customer : customerList) {
//            for (Tour tour : customer.getTours()) {
//                AvaibleTours sqlTours = avaibleToursRepo.findByCity(tour.getCity());
//                int price = tour.getCost() + tour.getCost() / 100 * customer.getSale();
//                if (tour.getBurning()) {
//                    price = price + price / 100 * 20;
//                }
//                if (!(sqlTours == null)) {
//                    System.out.println("Тур " + tour.getCity() + " уже существует");
//                } else {
//                    AvaibleTours a1 = new AvaibleTours(tour.getId(), tour.getCity(), price);
//                    avaibleToursRepo.add(a1);
//                }
//            }
//        }
//        System.out.println("Туры перенесены");
//    }
//    public void importTours(){ //Импорт туров из JSON в SQL
//        List<Customer> customerList=new ArrayList<>();
//        JsonReader jr = new CustomerJsonReader();
//        customerList.addAll(jr.readJson());
//        for (Customer customer : customerList) {
//            for (Tour tour : customer.getTours()) {
//                if(tour.getCity()==null){
//                    break;
//                }
//                else{
//                AvaibleTours sqlTours = avaibleToursRepo.findByCity(tour.getCity());
//                int price = tour.getCost() + tour.getCost() / 100 * customer.getSale();
//                if (tour.getBurning()) {
//                    price = price + price / 100 * 20;
//                }
//                if (!(sqlTours == null)) {
//                    System.out.println("Тур " + tour.getCity() + " уже существует");
//                } else {
//                    AvaibleTours a1 = new AvaibleTours(tour.getId(), tour.getCity(), price);
//                    avaibleToursRepo.add(a1);
//                }
//                }
//            }
//        }
//        System.out.println("Туры перенесены");
//    }
//}
