package com.example.jplumbly.foodplanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by JPlumbly on 1/29/2017.
 */

public class Product {
    public String GTIN;
    public String TPNB;
    public String TPNC;
    public String Description;
    public String Brand;
    public ArrayList<String> QtyContents;
    public ArrayList<String> Ingredients;
    public ArrayList<String> Storage;
    public String MarketingText;
    public ArrayList<String> ProductAttributes;

    public Product(){
        QtyContents = new ArrayList<String>();
        Ingredients = new ArrayList<String>();
        Storage = new ArrayList<String>();
        ProductAttributes = new ArrayList<String>();
    }

    public static Product parse(JSONObject json){
        Product parsedModel = new Product();

        try {
            parsedModel.GTIN = json.getString("gtin");
            parsedModel.TPNB = json.getString("tpnb");
            parsedModel.TPNC = json.getString("tpnc");
            parsedModel.Description = json.getString("description");
            parsedModel.Brand = json.getString("brand");
            parsedModel.MarketingText = json.getString("marketingText");

            JSONArray ingredients = json.getJSONArray("ingredients");

            for (int i =0, length = ingredients.length(); i<length; i++){
                parsedModel.Ingredients.add(ingredients.getString(i));
            }

            JSONArray storage = json.getJSONArray("storage");

            for (int i =0, length = ingredients.length(); i<length; i++){
                parsedModel.Storage.add(storage.getString(i));
            }

            JSONArray attributes = json.getJSONArray("productAttributes");

            for (int i =0, length = ingredients.length(); i < length; i++){
                parsedModel.ProductAttributes.add(attributes.getString(i));
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return parsedModel;
    }
}
