package Utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IntegerInput {
    Scanner scanner=new Scanner(System.in);
    Integer number;
    Integer year;
    Integer month;
    Integer day;
    boolean numberValid = false;
    public int integerInput(){
        do {
            try {
                number = scanner.nextInt();
                scanner.nextLine();
                numberValid = true;
            } catch (InputMismatchException e) {
                System.out.println("Введите целое число");
                scanner.nextLine();
                System.out.println("Ошибка: " + e);
            }
        } while (!numberValid);
        return number;
    }
    public int yearInput(){
        do {
            try {
                year = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Введите целое число");
                scanner.nextLine();
                System.out.println("Ошибка: " + e);
            }
            if(year>=2021 && year<=2023){
            numberValid = true;}
            else{
                System.out.println("Значение выходит за пределы, введите номер года еще раз");
                numberValid=false;
            }
        } while (!numberValid);
        return year;
    }
    public int monthInput(){
        do {
            try {
                month = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Введите целое число");
                scanner.nextLine();
                System.out.println("Ошибка: " + e);
            }
            if(month>0 && month<=12){
                numberValid = true;}
            else{
                System.out.println("Значение выходит за пределы, введите номер месяца еще раз");
                numberValid=false;
            }
        } while (!numberValid);
        return month;
    }
    public int dayInput(){
        do {
            try {
                day = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Введите целое число");
                scanner.nextLine();
                System.out.println("Ошибка: " + e);
            }
            if(day>0 && day<=31){
                numberValid = true;}
            else{
                System.out.println("Значение выходит за пределы, введите число еще раз");
                numberValid=false;
            }
        } while (!numberValid);
        return day;
    }
}
