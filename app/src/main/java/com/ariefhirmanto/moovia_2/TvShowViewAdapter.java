package com.ariefhirmanto.moovia_2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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

public class TvShowViewAdapter extends RecyclerView.Adapter<TvShowViewAdapter.CardViewHolder> {
    private ArrayList<TvShow> listTvShow;
    private Context context;
    public final static String TV_SHOW = "EXTRA_TV";
//    public final static String URL = "url";

    public TvShowViewAdapter(ArrayList<TvShow> list, Context context) {
        this.context = context;
        this.listTvShow = list;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_data_tv, viewGroup, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder cardViewHolder, final int i) {
        final TvShow tvShow = listTvShow.get(i);

        Glide.with(cardViewHolder.itemView.getContext())
                .load(tvShow.getPhoto())
                .apply(new RequestOptions().override(350, 350))
                .into(cardViewHolder.imgPhoto);

        cardViewHolder.tvTitle.setText(tvShow.getTitle());
        cardViewHolder.tvRelease.setText(tvShow.getRelease());
        cardViewHolder.tvRating.setText(tvShow.getRating());

        cardViewHolder.btnLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TvShow tvShow = listTvShow.get(i);
                Intent intent = new Intent(context, DetailTvShowActivity.class);
                intent.putExtra(TvShowViewAdapter.TV_SHOW, tvShow);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listTvShow.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvTitle, tvRelease, tvRating;
        Button btnLink;


        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvTitle = itemView.findViewById(R.id.tv_item_title);
            tvRelease = itemView.findViewById(R.id.tv_item_release);
            tvRating = itemView.findViewById(R.id.tv_item_rating);
            btnLink = itemView.findViewById(R.id.btn_link);
        }
    }
}
