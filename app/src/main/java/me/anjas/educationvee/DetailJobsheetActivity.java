package me.anjas.educationvee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailJobsheetActivity extends AppCompatActivity {

    int langkahKerjaString, latihanString;
    String title;

    CardView langkahKerjaButton, latihanButton;
    TextView kompetensiView, subkompetensiView, landasanTeoriView, alatBahanView, keselamatanKerjaView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_jobsheet);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        langkahKerjaButton = (CardView) findViewById(R.id.langkahKerjaButton);
        latihanButton = (CardView) findViewById(R.id.latihanButton);

        kompetensiView = (TextView) findViewById(R.id.kompetensiView);
        subkompetensiView = (TextView) findViewById(R.id.subKompetensiView);
        landasanTeoriView = (TextView) findViewById(R.id.landasanTeoriView);
        alatBahanView = (TextView) findViewById(R.id.alatBahanView);
        keselamatanKerjaView = (TextView) findViewById(R.id.keselamatanKerjaView);

        title = getIntent().getStringExtra("title");
        getSupportActionBar().setTitle(title);

        kompetensiView.setText(getResources().getString(getIntent().getIntExtra("kompetensi", 0)));
        subkompetensiView.setText(getResources().getString(getIntent().getIntExtra("subkompetensi", 0)));
        landasanTeoriView.setText(getResources().getString(getIntent().getIntExtra("landasanteori", 0)));
        alatBahanView.setText(getResources().getString(getIntent().getIntExtra("alatbahan", 0)));
        keselamatanKerjaView.setText(getResources().getString(getIntent().getIntExtra("keselamatankerja", 0)));
        langkahKerjaString = getIntent().getIntExtra("langkahkerja",0);
        latihanString = getIntent().getIntExtra("latihan", 0);


        langkahKerjaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailJobsheetActivity.this, LangkahKerjaActivity.class);
                intent.putExtra("langkahkerja", langkahKerjaString);
                intent.putExtra("gambar", getIntent().getIntExtra("gambar",0));
                intent.putExtra("title", title);
                startActivity(intent);
            }
        });

        latihanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailJobsheetActivity.this, LatihanActivity.class);
                intent.putExtra("latihan", latihanString);
                intent.putExtra("title", title);
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
