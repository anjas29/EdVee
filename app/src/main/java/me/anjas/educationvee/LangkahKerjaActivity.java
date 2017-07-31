package me.anjas.educationvee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

public class LangkahKerjaActivity extends AppCompatActivity {

    ImageView jobsheetImage;
    TextView langkahkerjaView;
    WebView kodeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_langkah_kerja);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        jobsheetImage = (ImageView) findViewById(R.id.jobsheetImage);
        langkahkerjaView = (TextView) findViewById(R.id.langkahkerjaView);
        kodeView = (WebView) findViewById(R.id.webview);

        getSupportActionBar().setTitle(getIntent().getStringExtra("title"));

        jobsheetImage.setImageResource(getIntent().getIntExtra("gambar", 0));
        langkahkerjaView.setText(getResources().getString(getIntent().getIntExtra("langkahkerja",0)));

        switch (getIntent().getStringExtra("title")){
            case "Jobsheet LM35":
                kodeView.loadUrl("file:///android_asset/kode_lm35.html");
                break;
            case "Jobsheet PING SR 04":
                kodeView.loadUrl("file:///android_asset/kode_ping.html");
                break;
            case "Jobsheet LDR":
                kodeView.loadUrl("file:///android_asset/kode_ldr.html");
                break;
            case "Jobsheet PIR":
                kodeView.loadUrl("file:///android_asset/kode_pir.html");
                break;
            default:
                kodeView.loadUrl("file:///android_asset/kode_pir.html");
                break;
        }

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
