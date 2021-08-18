package com.example.tugas_api_kel3;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView tv_name,tv_capital,tv_region,tv_population;
        ImageView img_flag;

        tv_name = findViewById(R.id.tv_name_detail);
        tv_capital = findViewById(R.id.tv_capital_detail);
        tv_region = findViewById(R.id.tv_region_detail);
        tv_population = findViewById(R.id.tv_population_detail);
        img_flag = findViewById(R.id.img_detail);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String name = bundle.getString("name");
            String capital = bundle.getString("capital");
            String region = bundle.getString("region");
            String population = bundle.getString("population");
            String flag = bundle.getString("flag");

            tv_name.setText(name);
            tv_capital.setText(capital);
            tv_region.setText(region);
            tv_population.setText(population);
            Picasso.get()
                    .load(flag)
                    .fit()
                    .centerCrop()
                    .into(img_flag);
        }
    }

}
