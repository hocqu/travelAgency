package readWrite.read;

import Entities.Tour;
import com.google.gson.Gson;

public class TourJsonReader extends JsonReader{
    public TourJsonReader(){
        gson=new Gson();
        aClass= Tour.class;
        downTagName="tours";
        filename="travelAgency.json";
    }
}
