package com.example.unsplashapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    int index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imageView);
        Button prev = findViewById(R.id.prevButton);
        Button next = findViewById(R.id.nextButton);

        List<String> urlList = new ArrayList<>();

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,
                "https://api.unsplash.com/photos/?client_id=JuKuH_UtQZKpZnlC_xp7xgfNUMTEPurYoiuMx4A4-80",
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        for (int i = 0; i < response.length(); i++){
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                JSONObject urlObject = jsonObject.getJSONObject("urls");
                                String imageUrl = urlObject.getString("regular");
                                Log.d("RKTAG", imageUrl);
                                urlList.add(imageUrl);
                            } catch (JSONException e) {
                                Log.d("RKTAG", "JSONERROR: " + e.toString());
                            }
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("RKTAG", "Some error occured");
            }
        });
        requestQueue.add(jsonArrayRequest);

//        String firstUrl = urlList.get(0);
//        Picasso.get().load(firstUrl).into(imageView);

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = urlList.get(index);
                index--;
                if (index < 0){
                    index = (index % urlList.size() + urlList.size()) % urlList.size();
                }
                Picasso.get().load(url).into(imageView);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = urlList.get(index);
                index = (index + 1) % urlList.size();
                Picasso.get().load(url).into(imageView);
            }
        });


    }
}