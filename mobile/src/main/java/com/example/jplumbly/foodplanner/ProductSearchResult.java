package com.example.jplumbly.foodplanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by JPlumbly on 1/29/2017.
 */

public class ProductSearchResult
{
    public String Image;
    public String Tpnb;
    public double Price;
    public String ContentMeasureType;
    public String Name;
    public int UnitOfSale;
    public ArrayList<String> Description;
    public double AverageSellingUnitWeight;
    public String UnitQuantity;
    public double ContentsQuantity;
    public double UnitPrice;

    public static ProductSearchResult parse(JSONObject json){
        ProductSearchResult parsedModel = new ProductSearchResult();

        try {
            parsedModel.Image = json.getString("image");
            parsedModel.Tpnb = json.getString("tpnb");
            parsedModel.Price = json.getDouble("price");
            parsedModel.ContentMeasureType = json.getString("ContentsMeasureType");
            parsedModel.Name = json.getString("name");
            parsedModel.UnitOfSale = json.getInt("UnitOfSale");
            parsedModel.AverageSellingUnitWeight = json.getDouble("AverageSellingUnitWeight");
            parsedModel.UnitQuantity = json.getString("UnitQuantity");
            parsedModel.ContentsQuantity = json.getDouble("ContentsQuantity");
            parsedModel.UnitPrice = json.getDouble("unitprice");
            parsedModel.Description = new ArrayList<String>();

            JSONArray descriptions = json.getJSONArray("description");

            for(int i = 0, length = descriptions.length(); i < length; i++){
                String desc = descriptions.getString(i);
                parsedModel.Description.add(desc);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return parsedModel;
    }
}
