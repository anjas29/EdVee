package me.anjas.educationvee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.webkit.WebView;

import java.util.ArrayList;

import me.anjas.educationvee.adapters.JobsheetAdapter;
import me.anjas.educationvee.objects.Jobsheet;

public class JobsheetActivity extends AppCompatActivity {
    //WebView webview;
    public static ArrayList<Jobsheet> items;
    RecyclerView listView;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobsheet);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //webview = (WebView)findViewById(R.id.webview);
        //webview.loadUrl("file:///android_asset/kode_program.html");

        listView = (RecyclerView) findViewById(R.id.listView);
        items = new ArrayList<Jobsheet>();
        layoutManager= new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        listView.setHasFixedSize(true);

        listView.setLayoutManager(layoutManager);

        getData();

        JobsheetAdapter adapter = new JobsheetAdapter(getApplicationContext(), items);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void getData(){
        items.add(new Jobsheet("Jobsheet LM35", "Penggunaan Sensor LM35 berbasis IoT", 2, R.string.lm35_kompetensi, R.string.lm35_subkompetensi, R.string.lm35_landasanteori, R.string.lm35_alatbahan, R.string.lm35_keselamatankerja, R.string.lm35_langkahkerja, R.string.lm35_latihan, R.drawable.rangkaian_lm35));
        items.add(new Jobsheet("Jobsheet PING SR 04", "Penggunaan Sensor PING SR 04 berbasis IoT", 1, R.string.ping_kompetensi, R.string.ping_subkompetensi, R.string.ping_landasanteori, R.string.ping_alatbahan, R.string.ping_keselamatankerja, R.string.ping_langkahkerja, R.string.ping_latihan, R.drawable.rangkaian_ping));
        items.add(new Jobsheet("Jobsheet LDR", "Penggunaan Sensor LDR berbasis IoT", 1, R.string.ldr_kompetensi, R.string.ldr_subkompetensi, R.string.ldr_landasanteori, R.string.ldr_alatbahan, R.string.ldr_keselamatankerja, R.string.ldr_langkahkerja, R.string.ldr_latihan,R.drawable.rangkaian_ldr));
        items.add(new Jobsheet("Jobsheet PIR", "Penggunaan Sensor PIR berbasis IoT", 1, R.string.pir_kompetensi, R.string.pir_subkompetensi, R.string.pir_landasanteori, R.string.pir_alatbahan, R.string.pir_keselamatankerja, R.string.pir_langkahkerja, R.string.pir_latihan, R.drawable.rangkaian_pir));
    }
}
