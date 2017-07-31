package me.anjas.educationvee;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    TextView descriptionView, titleView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        imageView = (ImageView)findViewById(R.id.image);
        descriptionView = (TextView)findViewById(R.id.description);
        titleView = (TextView)findViewById(R.id.titleView);

        String name = getIntent().getStringExtra("name");
        int image = getIntent().getIntExtra("image", R.drawable.soilmosture);
        int description = getIntent().getIntExtra("description", R.string.soilmosture);

        getSupportActionBar().setTitle(name);
        titleView.setText(name);
        imageView.setImageResource(image);
        descriptionView.setText(description);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
