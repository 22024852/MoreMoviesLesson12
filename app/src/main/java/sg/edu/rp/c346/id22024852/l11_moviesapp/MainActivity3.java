package sg.edu.rp.c346.id22024852.l11_moviesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity3 extends AppCompatActivity {

    Button edit;
    Button delete;
    Button cancel;

    EditText title;
    EditText year;
    EditText genre;
    Spinner spn;
    String rating = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        edit = findViewById(R.id.btnEdit);
        delete = findViewById(R.id.btnDelete);
        cancel= findViewById(R.id.Cancel);
        title = findViewById(R.id.edTitle);
        year = findViewById(R.id.etYear);
        genre = findViewById(R.id.etGenre);
        spn = findViewById(R.id.change);

        Intent i = getIntent();
        Movie song = (Movie) i.getSerializableExtra("movie");
        title.setText(song.getTitle());
        genre.setText(song.getGenre());
        year.setText(Integer.toString(song.getYear()));


        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0:
                        rating = "G";
                        break;
                    case 1:
                        rating = "PG";
                        break;
                    case 2:
                        rating = "PG13";
                        break;
                    case 3:
                        rating = "NC16";
                        break;
                    case 4:
                        rating = "M18";
                        break;
                    case 5:
                        rating = "R21";
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity3.this);
                String tt = title.getText().toString();
                song.setTitle(tt);
                String genreInp = genre.getText().toString();
                song.setGenre(genreInp);
                int yearInp = Integer.parseInt(year.getText().toString());
                song.setYear(yearInp);
                song.setRating(rating);
                db.updateMovie(song);
                db.close();
                Intent i = new Intent(MainActivity3.this, MainActivity2.class);
                startActivity(i);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity3.this);
                db.deleteMovie(song.getId());
                db.close();
                Intent i = new Intent(MainActivity3.this, MainActivity2.class);
                startActivity(i);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity3.this, MainActivity2.class);
                startActivity(i);
            }
        });

    }
}