package com.example.jplumbly.foodplanner;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

public class TescoService {
    private final String TESCO_API_URL = "https://dev.tescolabs.com/";
    private final String APP_KEY = "ebb7723eeaac4f8a8c625c3225db9896";
    private final String APP_SECRET = "35d99c999db64e4d915258e161df6d49";

    public void searchGroceries(AppCompatActivity context, String query, int offset, int limit){
        String groceryUrl = TESCO_API_URL + "grocery/products/?query=" + query + "&offset=" + offset + "&limit=" + limit;

        Response.Listener<JSONObject> responseListener = new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonResults = response.getJSONObject("uk").getJSONObject("ghs").getJSONObject("products").getJSONArray("results");

                    ArrayList<ProductSearchResult> results = new ArrayList<ProductSearchResult>();

                    for (int i = 0, length = jsonResults.length(); i < length; i++){
                        results.add(ProductSearchResult.parse(jsonResults.getJSONObject(i)));
                    }

                    String test = "";

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String test = "";
            }
        };

        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.GET, groceryUrl, null, responseListener, errorListener ){
            public Map<String, String> getHeaders() {
                Map<String, String> headers = new ArrayMap<String, String>();

                headers.put("Ocp-Apim-Subscription-Key", APP_KEY);
                return headers;
            }
        };

        RequestHandler.getInstance(context).addToRequestQueue(stringRequest);

    }

    public void GetProduct(AppCompatActivity context, String tpnb){
        String url = TESCO_API_URL + "product?tpnb=" + tpnb;

        RequestQueue queue = Volley.newRequestQueue(context);

        Response.Listener<JSONObject> responseListener = new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonResults = response.getJSONArray("products");

                    ArrayList<Product> results = new ArrayList<Product>();

                    for (int i = 0, length = jsonResults.length(); i < length; i++){
                        Product.parse(jsonResults.getJSONObject(i));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String test = "";
            }
        };

        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.GET, url, null, responseListener, errorListener ){
            public Map<String, String> getHeaders() {
                Map<String, String> headers = new ArrayMap<String, String>();

                headers.put("Ocp-Apim-Subscription-Key", APP_KEY);
                return headers;
            }
        };

        queue.add(stringRequest);
    }

}
