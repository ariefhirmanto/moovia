package com.ariefhirmanto.moovia_2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class MovieViewAdapter extends RecyclerView.Adapter<MovieViewAdapter.CardViewHolder> {
    private ArrayList<Movie> listMovie;
    private Context context;
    public final static String MOVIE = "EXTRA_MOVIE";
//    public final static String URL = "url";

    public MovieViewAdapter(ArrayList<Movie> list, Context context) {
        this.context = context;
        this.listMovie = list;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_data_movie, viewGroup, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder cardViewHolder, final int i) {
        Movie movie = listMovie.get(i);

        Glide.with(cardViewHolder.itemView.getContext())
                .load(movie.getPhoto())
                .apply(new RequestOptions().override(350, 350))
            .into(cardViewHolder.imgPhoto);

        cardViewHolder.tvTitle.setText(movie.getTitle());
        cardViewHolder.tvStarring.setText(movie.getStarring());
        cardViewHolder.tvRating.setText(movie.getRating());

        cardViewHolder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Movie movie = listMovie.get(i);
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(MovieViewAdapter.MOVIE, movie);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvTitle, tvStarring, tvRating;
        Button btnDetail;


        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvTitle = itemView.findViewById(R.id.tv_item_title);
            tvStarring = itemView.findViewById(R.id.tv_item_starring);
            tvRating = itemView.findViewById(R.id.tv_item_rating);
            btnDetail = itemView.findViewById(R.id.btn_detail);
        }
    }
}
