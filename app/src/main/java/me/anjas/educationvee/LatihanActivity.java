package me.anjas.educationvee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class LatihanActivity extends AppCompatActivity {
    TextView latihanView, interfacingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latihan);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        latihanView = (TextView) findViewById(R.id.latihanView);
        interfacingView = (TextView) findViewById(R.id.interfacingView);

        getSupportActionBar().setTitle(getIntent().getStringExtra("title"));
        latihanView.setText(getResources().getString(getIntent().getIntExtra("latihan",0)));

        interfacingView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LatihanActivity.this, InterfaceActivity.class);
                startActivity(intent);
            }
        });
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
