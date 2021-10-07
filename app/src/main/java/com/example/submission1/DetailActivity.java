package com.example.submission1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class DetailActivity extends AppCompatActivity {

    public static final String FILM_ITEM = "film_item";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Detail Film");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        Film film = intent.getParcelableExtra(FILM_ITEM);

        TextView txtName = findViewById(R.id.txt_name);
        assert film != null;
        txtName.setText(film.getName());

        TextView txtDescription = findViewById(R.id.txt_description);
        txtDescription.setText(film.getDescription());

        ImageView imgPhoto = findViewById(R.id.img_photo);
        imgPhoto.setImageResource(film.getPhoto());

        TextView txtGenre = findViewById(R.id.txt_genre);
        txtGenre.setText(film.getGenre());
    }
}
