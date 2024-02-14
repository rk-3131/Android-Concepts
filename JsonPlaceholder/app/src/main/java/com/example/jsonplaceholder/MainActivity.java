package com.example.jsonplaceholder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView id = findViewById(R.id.id_id);
        TextView title = findViewById(R.id.id_title);
        TextView desc = findViewById(R.id.id_description);
        TextView price = findViewById(R.id.id_price);
        TextView discount = findViewById(R.id.id_discount);
        TextView rating = findViewById(R.id.id_rating);
        TextView stocks = findViewById(R.id.id_stock);
        TextView brand = findViewById(R.id.id_brand);
        TextView category = findViewById(R.id.id_category);
        Button getButton = findViewById(R.id.getButton);

        RequestQueue requestQueue = Volley.newRequestQueue(this);



        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "https://dummyjson.com/products/1",
                        null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("RKTAG", "Data has been recieved");
                        try {
                            id.setText(response.getString("id"));
                            title.setText(response.getString("title"));
                            desc.setText(response.getString("description"));
                            price.setText(response.getString("price"));
                            discount.setText(response.getString("discountPercentage"));
                            rating.setText(response.getString("rating"));
                            stocks.setText(response.getString("stock"));
                            brand.setText(response.getString("brand"));
                            category.setText(response.getString("category"));

                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("RKTAG", "There is some error");
                    }
                });
                requestQueue.add(jsonObjectRequest);
            }
        });
    }
}