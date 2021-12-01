package Service;

import Entities.AvaibleTours;
import Entities.Customer;
import Entities.Tour;
import Utils.IntegerInput;
import repo.AvaibleToursRepo;
import repo.TourRepo;

import java.sql.SQLException;

public class CreateOrder {
    IntegerInput integerInput = new IntegerInput();
    AvaibleToursRepo avaibleToursRepo= new AvaibleToursRepo();
    TourRepo tourRepo=new TourRepo();

    public CreateOrder() throws SQLException {
    }

    public void createOrder(Customer customer) {
        int choice;
        int sale=0;
        String tourType="";
        System.out.println("Введите номер тура");
        int id=integerInput.integerInput();
        System.out.println("Введите дату когда хотите отправиться в тур в таком порядке:\n" +
                "Год, месяц, день");
        int year = integerInput.yearInput();
        int month = integerInput.monthInput();
        int day = integerInput.dayInput();
        String departureDate=year+"-"+month+"-"+day;
        boolean choiceValid=false;
        do {
            System.out.println("Выберите тип тура:\n" +
                    "1.Excursion\n" +
                    "2.Relax\n" +
                    "3.Shopping ");
            choice=integerInput.integerInput();
            switch (choice){
                case 1:tourType="Excursion";
                    choiceValid=true;
                    break;
                case 2:tourType="Relax";
                    choiceValid=true;
                    break;
                case 3:tourType="Shopping";
                    choiceValid=true;
                    break;
                default:
                    System.out.println("Введите правильно тип тура");
                    break;
            }
        }while(!choiceValid);
        System.out.println("Введите длительность тура");
        int time=integerInput.integerInput();
        AvaibleTours avaibleTours=avaibleToursRepo.findById(id);
        sale+=customer.getSale();
        int price=avaibleTours.getCost();
        price=price/100*(100-sale);
        Tour tour=new Tour(1, customer.getId(),tourType,departureDate,time,avaibleTours.getCity(),
                price,false);
        System.out.println("В итоге получился вот такой тур-"+price);
        tourRepo.add(tour);
    }
}
