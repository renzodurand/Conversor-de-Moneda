package models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Conversor {
    private String json;
    private ConversorRecord conversorRecord;


    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public Conversor(String json) {
        this.json = json;
        this.conversorRecord = gson.fromJson(json, ConversorRecord.class);
    }

    public String getBaseCoin(){
        return this.conversorRecord.base_code();
    }

    public String getTargetCoin(){
        return this.conversorRecord.target_code();
    }

    public String getConversionRate(){
        return this.conversorRecord.conversion_rate();
    }

    public String getConversionResult(){
        return this.conversorRecord.conversion_result();
    }

}
