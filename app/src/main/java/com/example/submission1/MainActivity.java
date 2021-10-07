package com.example.submission1;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private String[] dataName;
    private String[] dataDescription;
    private String[] dataGenre;
    private TypedArray dataPhoto;
    private TypedArray dataStar;
    private FilmAdapter adapter;
    private ArrayList<Film> films;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Daftar Film");

        adapter = new FilmAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(DetailActivity.FILM_ITEM, films.get(i));
                startActivity(intent);

                Toast.makeText(MainActivity.this, films.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addItem() {
        films = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            Film film = new Film();
            film.setPhoto(dataPhoto.getResourceId(i, -1));
            film.setName(dataName[i]);
            film.setStar(dataStar.getResourceId(i, -1));
            film.setDescription(dataDescription[i]);
            film.setGenre(dataGenre[i]);
            films.add(film);
        }
        adapter.setFilms(films);
    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name);
        dataStar = getResources().obtainTypedArray(R.array.data_star);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
        dataGenre = getResources().getStringArray(R.array.data_genre);
    }
}
