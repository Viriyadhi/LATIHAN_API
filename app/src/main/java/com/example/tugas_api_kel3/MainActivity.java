package com.example.tugas_api_kel3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String BASE_URL = "https://restcountries.eu/rest/v2/all";
    private GeoAdapter adapter;
    private ArrayList<GeoModel> arrayList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_main);

        addData();
    }

    private void addData() {
                AndroidNetworking.get(BASE_URL)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                            try {
                                arrayList = new ArrayList<>();
                                for (int i = 0; i < response.length(); i++) {
                                    JSONObject jsonObject = response.getJSONObject(i);
                                    String name = jsonObject.getString("name");
                                    String capital = jsonObject.getString("capital");
                                    String region = jsonObject.getString("subregion");
                                    String flag = jsonObject.getString("flag");
                                    String population = jsonObject.getString("population");
                                    arrayList.add(new GeoModel(name, capital, region, population, flag));
                                }
                                // String geoName, String geoCapital, String geoRegion, String geoPopulation, String geoArea, String geoFlag
                            } catch (JSONException e) {
                                Log.d("error", e.toString());
                            }
                            adapter = new GeoAdapter(getApplicationContext(),arrayList);
                            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                            recyclerView.setLayoutManager(layoutManager);
                            recyclerView.setAdapter(adapter);

                            adapter.setOnItemClickListener(new GeoAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(int position) {
                                    Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                                    intent.putExtra("name", arrayList.get(position).getGeoName());
                                    intent.putExtra("capital", arrayList.get(position).getGeoCapital());
                                    intent.putExtra("region", arrayList.get(position).getGeoRegion());
                                    intent.putExtra("population", arrayList.get(position).getGeoPopulation());
                                    intent.putExtra("flag", arrayList.get(position).getGeoFlag());
                                    startActivity(intent);
                                }
                            });

                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });
    }
}