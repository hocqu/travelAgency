package Utils;

public class PhoneNumber {
    public String numberFormater(String phoneNumber){
        String newNumber = phoneNumber.replaceAll("[^0-9]", "");
        if(newNumber.length()>11){
        newNumber=String.valueOf(newNumber).replaceFirst("(\\d{3})(\\d{2})(\\d{3})(\\d+)",
                "+$1 ($2) $3-$4");}
        else
        {newNumber=String.valueOf(newNumber).replaceFirst("(\\d{1})(\\d{3})(\\d{3})(\\d+)",
                "+$1 ($2) $3-$4");}
        return newNumber;
    }
}
