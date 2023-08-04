package sg.edu.rp.c346.id22024852.l11_moviesapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomAdapter  extends ArrayAdapter{

    Context parent_context;
    int layout_id;
    ArrayList<Movie> movies;

    public CustomAdapter(@NonNull Context context, int resource, ArrayList<Movie> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        movies = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvT = rowView.findViewById(R.id.tvTitle);
        TextView tvG = rowView.findViewById(R.id.tvGenre);
        TextView tvY = rowView.findViewById(R.id.tvYear);
        ImageView ivR = rowView.findViewById(R.id.imageView);

        Movie current = movies.get(position);
        tvT.setText(current.getTitle());
        tvG.setText(current.getGenre());
        tvY.setText(current.getyear());

        if (current.getRating().equals("G")) {
            ivR.setImageResource(R.drawable.rating_g);
        } else if (current.getRating().equals("PG")) {
            ivR.setImageResource(R.drawable.rating_pg);
        } else if (current.getRating().equals("PG13")) {
            ivR.setImageResource(R.drawable.rating_pg13);
        } else if (current.getRating().equals("NC16")) {
            ivR.setImageResource(R.drawable.rating_nc16);
        } else if (current.getRating() .equals("M18")) {
            ivR.setImageResource(R.drawable.rating_m18);
        } else {
            ivR.setImageResource(R.drawable.rating_r21);
        }

        return rowView;
    }



}
