package me.anjas.educationvee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;

public class SensorActivity extends AppCompatActivity {
    CardView lm35Button, smButton, dht11Button, ldrButton, ultrasonicButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        smButton = (CardView)findViewById(R.id.smButton);
        lm35Button = (CardView)findViewById(R.id.lm35Button);
        dht11Button = (CardView)findViewById(R.id.dhtButton);
        ldrButton = (CardView)findViewById(R.id.ldrButton);
        ultrasonicButton = (CardView)findViewById(R.id.ultrasonicButton);

        smButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SensorActivity.this, DetailActivity.class);
                intent.putExtra("name", "Sensor Soil Moisture");
                intent.putExtra("description", R.string.soilmosture);
                intent.putExtra("image", R.drawable.soilmosture);
                startActivity(intent);
            }
        });

        lm35Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SensorActivity.this, DetailActivity.class);
                intent.putExtra("name", "Sensor Suhu LM35 ");
                intent.putExtra("description", R.string.lm35);
                intent.putExtra("image", R.drawable.lm35);
                startActivity(intent);
            }
        });

        dht11Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SensorActivity.this, DetailActivity.class);
                intent.putExtra("name", "Sensor DHT11");
                intent.putExtra("description", R.string.dht11);
                intent.putExtra("image", R.drawable.dht11);
                startActivity(intent);
            }
        });

        ldrButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SensorActivity.this, DetailActivity.class);
                intent.putExtra("name", "Sensor LDR ");
                intent.putExtra("description", R.string.ldr);
                intent.putExtra("image", R.drawable.ldr);
                startActivity(intent);
            }
        });

        ultrasonicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SensorActivity.this, DetailActivity.class);
                intent.putExtra("name", "Sensor HC-SR04");
                intent.putExtra("description", R.string.ultrasonic);
                intent.putExtra("image", R.drawable.ultrasonic);
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
