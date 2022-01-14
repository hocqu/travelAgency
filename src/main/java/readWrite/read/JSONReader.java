package readWrite.read;

import Entities.Customer;
import Entities.Tour;
import com.google.gson.Gson;

public class JSONReader extends JavaJsonReader{
    public JSONReader(){
        gson=new Gson();
        aClass= Customer.class;
        downTagName="customer";
        filename=filename;
    }
}
