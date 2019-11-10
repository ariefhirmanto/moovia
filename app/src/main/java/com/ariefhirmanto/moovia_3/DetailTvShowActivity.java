package com.ariefhirmanto.moovia_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;

public class DetailTvShowActivity extends AppCompatActivity {

    private ImageView imgDetailPhoto;
    private TextView tvDetailTitle;
    private TextView tvDetailRating;
    private TextView tvDetailDescription;
    private Button btnLink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv_show);

        tvDetailTitle = findViewById(R.id.item_tv_detail_title);
        tvDetailRating = findViewById(R.id.item_tv_detail_rating);
        tvDetailDescription = findViewById(R.id.item_tv_detail_description);
        imgDetailPhoto = findViewById(R.id.img_tv_detail_photo);
        btnLink = findViewById(R.id.btn_tv_link);

        TvShow tvShow = getIntent().getParcelableExtra(TvShowViewAdapter.TV_SHOW);
        String title = tvShow.getTitle();
        String rating = "Rating : " + tvShow.getRating();
        String description = tvShow.getDescription();
        String photo = tvShow.getPhoto();

        tvDetailTitle.setText(title);
        tvDetailRating.setText(rating);
        tvDetailDescription.setText(description);

        new DetailTvShowActivity.DownloadImageFromInternet(imgDetailPhoto).execute(photo);

        findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnLink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                TvShow tvShowIntent = getIntent().getParcelableExtra(TvShowViewAdapter.TV_SHOW);
                String url = tvShowIntent.getUrl();
                Intent externalLink = new Intent(Intent.ACTION_VIEW);
                externalLink.setData(Uri.parse(url));
                startActivity(externalLink);
                finish();
            }
        });
    }

    private class DownloadImageFromInternet extends AsyncTask<String, Void, Bitmap> {
        ImageView imageView;

        public DownloadImageFromInternet(ImageView imageView) {
            this.imageView = imageView;
        }

        protected Bitmap doInBackground(String... urls) {
            String imageURL = urls[0];
            Bitmap bimage = null;
            try {
                InputStream in = new java.net.URL(imageURL).openStream();
                bimage = BitmapFactory.decodeStream(in);

            } catch (Exception e) {
                Log.e("Error Message", e.getMessage());
                e.printStackTrace();
            }
            return bimage;
        }

        protected void onPostExecute(Bitmap result) {
            imageView.setImageBitmap(result);
        }
    }

}
