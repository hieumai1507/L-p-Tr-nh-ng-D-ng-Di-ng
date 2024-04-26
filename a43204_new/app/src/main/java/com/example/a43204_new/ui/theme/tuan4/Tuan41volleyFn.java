package com.example.a43204_new.ui.theme.tuan4;

import android.content.Context;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Tuan41volleyFn {
    String strJSON ="";
    public void getJsonArrayOfObject(Context context, TextView textView) {
        // 1. tao request
        RequestQueue queue = Volley.newRequestQueue(context);

        // 2. Url
        String url ="https://hungnttg.github.io/array_json_new.json";
        // 3. Goi Request
        JsonArrayRequest request = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonArray) {
                        //chuyen mang sang cac doi tuong
                        for(int i = 0; i < jsonArray.length(); i++) {
                            try {
                                JSONObject person = jsonArray.getJSONObject(i); //lay tung doi tuong
                                String id = person.getString("id"); //lay id
                                String name = person.getString("name"); //lay name
                                String email = person.getString("email"); // lay email
                                //
                                strJSON +="Id: " +id+"\n";
                                strJSON +="Name: " +id+"\n";
                                strJSON +="Email: " +id+"\n";
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }
                            textView.setText(strJSON);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                textView.setText(volleyError.getMessage());
            }
        });
        //JsonArrayRequest(url,thanhcong, thatbai)
        // 4. thuc thi request

        queue.add(request);

    }
}
