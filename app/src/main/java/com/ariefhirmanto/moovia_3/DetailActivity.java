package com.ariefhirmanto.moovia_3;

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

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;

public class DetailActivity extends AppCompatActivity {
    private ImageView imgDetailPhoto;
    private TextView tvDetailTitle;
    private TextView tvDetailRating;
    private TextView tvDetailDescription;
    private Button btnLink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvDetailTitle = findViewById(R.id.item_detail_title);
        tvDetailRating = findViewById(R.id.item_detail_rating);
        tvDetailDescription = findViewById(R.id.item_detail_description);
        imgDetailPhoto = findViewById(R.id.img_detail_photo);
        btnLink = findViewById(R.id.btn_link);

        Movie movie = getIntent().getParcelableExtra(MovieViewAdapter.MOVIE);
        String title = movie.getTitle();
        String rating = "Rating : " + movie.getRating();
        String description = movie.getDescription();
        String photo = movie.getPhoto();

        tvDetailTitle.setText(title);
        tvDetailRating.setText(rating);
        tvDetailDescription.setText(description);

        new DownloadImageFromInternet(imgDetailPhoto).execute(photo);

        findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnLink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Movie movieIntent = getIntent().getParcelableExtra(MovieViewAdapter.MOVIE);
                String url = movieIntent.getUrl();
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
