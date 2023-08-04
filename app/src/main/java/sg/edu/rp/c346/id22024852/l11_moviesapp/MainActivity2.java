package sg.edu.rp.c346.id22024852.l11_moviesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ListView lv;
    Button back;
    Button pg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lv = findViewById(R.id.listV);
        back = findViewById(R.id.back);
        pg = findViewById(R.id.btnPG13);

        DBHelper db = new DBHelper(MainActivity2.this);

        ArrayList<Movie> data = db.getMovies();

        CustomAdapter ca = new CustomAdapter(this, R.layout.row, data);
        lv.setAdapter(ca);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Movie movie = data.get(position);
                Intent i = new Intent(MainActivity2.this, MainActivity3.class);
                i.putExtra("movie", movie);
                startActivity(i);

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(i);
            }
        });

        pg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity2.this);
                data.clear();
                ArrayList<Movie> pgmovies = db.getRatingMovie("PG");
                data.addAll(pgmovies);
                ca.notifyDataSetChanged();
            }
        });

    }
}