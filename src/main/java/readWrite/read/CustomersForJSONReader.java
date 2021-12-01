package readWrite.read;

import Entities.Customer;
import Entities.Tour;
import com.google.gson.Gson;

public class CustomersForJSONReader extends JavaJsonReader{
    public CustomersForJSONReader(){
        gson=new Gson();
        aClass= Customer.class;
        downTagName="customer";
        filename="test.json";
    }
}
