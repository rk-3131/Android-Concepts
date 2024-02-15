package com.example.randomuserinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.android.volley.toolbox.JsonObjectRequest;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView profile = findViewById(R.id.imageView);
        TextView name = findViewById(R.id.name_id);
        TextView country = findViewById(R.id.country_id);
        TextView email = findViewById(R.id.email_id);
        TextView age = findViewById(R.id.age_id);
        TextView gender = findViewById(R.id.gender_id);
        Button submit = findViewById(R.id.getData);

        RequestQueue requestQueue = Volley.newRequestQueue(this);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                        "https://randomuser.me/api/", null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    JSONArray result = response.getJSONArray("results");
                                    JSONObject userObject = result.getJSONObject(0);
                                    JSONObject nameObject = userObject.getJSONObject("name");
                                    String nameStr = nameObject.getString("title") + ". " + nameObject.getString("first") + " " + nameObject.getString("last");
                                    JSONObject locationObject = userObject.getJSONObject("location");
                                    String countryStr = locationObject.getString("country");
                                    String emailStr = userObject.getString("email");
                                    JSONObject registeredObject = userObject.getJSONObject("registered");
                                    String ageStr = registeredObject.getString("age");
                                    String genderStr = userObject.getString("gender");
                                    JSONObject imageObject = userObject.getJSONObject("picture");
                                    String imgUrl = imageObject.getString("large");


                                    name.setText(nameStr);
                                    country.setText(countryStr);
                                    email.setText(emailStr);
                                    age.setText(ageStr);
                                    gender.setText(genderStr);
                                    Picasso.get().load(imgUrl).into(profile);
                                }catch (Exception e){
                                    Toast.makeText(MainActivity.this, "There is some error", Toast.LENGTH_SHORT).show();
                                    Log.d("RKTAG", "Exception occured" + e.toString());
                                }

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("RKTAG", error.toString());
                    }
                });
                requestQueue.add(jsonObjectRequest);
            }
        });

    }
}