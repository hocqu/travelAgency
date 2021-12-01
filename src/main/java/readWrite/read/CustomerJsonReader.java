package readWrite.read;

import Entities.Customer;
import com.google.gson.Gson;

public class CustomerJsonReader extends JsonReader{
    public CustomerJsonReader(){
        gson=new Gson();
        aClass= Customer.class;
        downTagName="customer";
        filename=filename;
    }
}
