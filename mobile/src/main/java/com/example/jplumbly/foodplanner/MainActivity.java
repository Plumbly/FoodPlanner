package com.example.jplumbly.foodplanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TescoService tescoAPI = new TescoService();
        //tescoAPI.searchGroceries(this,"tomato", 0, 10);
        tescoAPI.GetProduct(this, "050436687");
    }
}
