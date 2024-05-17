package com.example.a43204_new.ui.theme.tuan6;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.a43204_new.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivityT61 extends AppCompatActivity {
    private ListView listView;
    private  ProductAdapter adapter;
    private List<Product> productList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_t61);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        listView=findViewById(R.id.t6ListView);
        adapter= new ProductAdapter(this, productList);
        productList=new ArrayList<>();
        listView.setAdapter((ListAdapter) adapter);
        //get data from API
        new FetchProductsTask().execute();
    }//FetchProductsTask().execute();
    private class FetchProductsTask extends AsyncTask<Void, Void, String> {
        //get data from API via internet
        @Override
        protected String doInBackground(Void... voids) {
            StringBuilder respone = new StringBuilder();//save return
            try {
                URL url = new URL("https://hungnttg.hithub.io/shopgiay.json");
                HttpURLConnection connection = (java.net.HttpURLConnection) url.openConnection();
                //set method for read data
                connection.setRequestMethod("GET");

                //create buffer for read data
                BufferedReader reader = new
                        BufferedReader((new InputStreamReader(connection.getInputStream())));
                //read data
                String line = "";
                while((line=reader.readLine())!=null) {//read until EOF
                    respone.append(line);
                }
            reader.close();
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return respone.toString();
        }
        //return data for client
        @Override
        protected void onPostExecute(String s) {
            if(s!=null  && !s.isEmpty()) {
                try {
                    JSONObject json = new JSONObject(s);
                    JSONArray productsArray = json.getJSONArray("product");//get an array for objects
                    for(int i = 0; i < productsArray.length(); i++) {
                        JSONObject productObject = productsArray.getJSONObject(i);
                        String styleId = productObject.getString("styleid");
                        String brand = productObject.getString("brand_filter_facet");
                        String price = productObject.getString("price");
                        String additionInfo = productObject.getString("product_additional_info");
                        String searchImage = productObject.getString("search_image");
                        Product product = new Product(styleId, brand, price, additionInfo, searchImage);
                        productList.add(product);
                    }
                    adapter.notifyDataSetChanged();//update to adapter
                    //notifyDataSetChanged
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

            } else {
                Toast.makeText(MainActivityT61.this, "Failed to fetch products!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}