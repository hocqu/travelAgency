package readWrite.read;

import com.google.gson.*;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public abstract class JsonReader<T> {
    protected Gson gson;
    protected Class<T> aClass;
    protected String downTagName;
    protected String filename;
    public List<T> readJson(String filename){
        List<T> result=new ArrayList<>();
        try(Reader reader=new FileReader(filename)) {
        JsonElement je= JsonParser.parseReader(reader);
            JsonObject jo= je.getAsJsonObject();
            JsonArray arr=jo.getAsJsonArray("customers");
            for(JsonElement jel : arr){
                JsonArray pArray=jel.getAsJsonObject().getAsJsonArray(downTagName);
                pArray.forEach(jet -> result.add(gson.fromJson(jet,aClass)));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
            result.clear();
        }
        return result;
    }
}
