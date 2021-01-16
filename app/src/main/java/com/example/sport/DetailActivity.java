package com.example.sport;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        final TextView title = (TextView) findViewById(R.id.tv_title_detail);
        final TextView Home = (TextView) findViewById(R.id.txtHome_detail);
        final TextView HomeScore = (TextView) findViewById(R.id.txtHomeScore_detail);
        final TextView Away = (TextView) findViewById(R.id.txtAway_detail);
        final TextView AwayScore = (TextView) findViewById(R.id.txtAwayScore_detail);
        final TextView Hometeam =(TextView) findViewById(R.id.txtHomeTeam_detail);
        final TextView Date = (TextView) findViewById(R.id.txtDate);

        final TextView img = (TextView) findViewById(R.id.txtimg);
        ImageView image = (ImageView) findViewById(R.id.img_detail);
        String coverImageSrc = getIntent().getStringExtra("src");
        ImageView imageView = (ImageView) findViewById(R.id.img_detail);

        Glide.with(this)
                .load(getIntent().getStringExtra("img"))
                .into(imageView);
        Hometeam.setText(getIntent().getStringExtra("Home"));
        title.setText(getIntent().getStringExtra("title"));
        Home.setText(getIntent().getStringExtra("Home"));
        HomeScore.setText(getIntent().getStringExtra("HomeScore"));
        Away.setText(getIntent().getStringExtra("Away"));
        AwayScore.setText(getIntent().getStringExtra("AwayScore"));
        img.setText(getIntent().getStringExtra("img"));
        Date.setText(getIntent().getStringExtra("Date"));
        Button btn = findViewById(R.id.btn_Fav);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myDb.insertData(title.getText().toString(), Home.getText().toString(), Away.getText().toString(), HomeScore.getText().toString(), AwayScore.getText().toString(), Date.getText().toString(), img.getText().toString());
                Hometeam.setText(getIntent().getStringExtra("Home"));
                title.setText(getIntent().getStringExtra("title"));
                Home.setText(getIntent().getStringExtra("Home"));
                HomeScore.setText(getIntent().getStringExtra("HomeScore"));
                Away.setText(getIntent().getStringExtra("Away"));
                AwayScore.setText(getIntent().getStringExtra("AwayScore"));
                img.setText(getIntent().getStringExtra("img"));
                Date.setText(getIntent().getStringExtra("Date"));
            }
        });
    }

}