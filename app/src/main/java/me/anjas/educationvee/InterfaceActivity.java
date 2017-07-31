package me.anjas.educationvee;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.text.InputType;
import android.text.method.DigitsKeyListener;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.github.lzyzsd.circleprogress.ArcProgress;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.truizlop.fabreveallayout.FABRevealLayout;

import java.util.ArrayList;
import java.util.List;

public class InterfaceActivity extends AppCompatActivity {
    LineChart chart;
    Firebase firebase;
    List<Entry> entries;
    List<Entry> entries2;
    ArrayList<String> labels;
    ArrayList<Integer> colors;
    LinearLayoutManager linearLayoutManager;
    LinearLayout mainLayout;
    ProgressBar progressBar;

    FirebaseDatabase database;

    Button setButton, hideButton;
    TextView tresholdView;
    FABRevealLayout fabRevealLayout;
    Switch switchButton;
    TextView lm35View, pingView, ldrView, pirView;
    ArcProgress lm35ArcView, pingArchView, ldrArchView, pirArchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        fabRevealLayout = (FABRevealLayout) findViewById(R.id.fab_reveal_layout);
        hideButton = (Button) findViewById(R.id.hideButton);
        switchButton = (Switch) findViewById(R.id.switchView);
        lm35View = (TextView) findViewById(R.id.lm35View);
        pingView = (TextView) findViewById(R.id.pingView);
        ldrView = (TextView) findViewById(R.id.ldrView);
        pirView = (TextView) findViewById(R.id.pirView);

        lm35ArcView = (ArcProgress) findViewById(R.id.lm35ArchView);
        pingArchView = (ArcProgress) findViewById(R.id.pingArchView);
        ldrArchView = (ArcProgress) findViewById(R.id.ldrArchView);
        pirArchView= (ArcProgress) findViewById(R.id.pirArchView);

        chart = (LineChart)findViewById(R.id.chart);
        chart.setNoDataText("Memuat data ...");
        Firebase.setAndroidContext(this);
        firebase = new Firebase("https://tekno-7c6bf.firebaseio.com/");
        database = FirebaseDatabase.getInstance();

        getCurrentStat();
        setGraph();

        tresholdView = (TextView) findViewById(R.id.tresholdView);
        setButton = (Button) findViewById(R.id.setButton);

        setButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(InterfaceActivity.this);
                alertDialog.setTitle("Treshold");
                alertDialog.setMessage("Masukan Treshold");

                final EditText input = new EditText(InterfaceActivity.this);
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                input.setKeyListener(DigitsKeyListener.getInstance("0123456789"));
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                alertDialog.setView(input);
                alertDialog.setIcon(android.R.drawable.ic_menu_help);

                alertDialog.setPositiveButton("Ya",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                int treshold = 0;
                                try{
                                    treshold = Integer.parseInt(input.getText().toString());
                                    if(treshold > 100){
                                        treshold = 100;
                                    }
                                }catch(Exception e){
                                    treshold = 0;
                                }
                                setTreshold(treshold);
                            }
                        });

                alertDialog.setNegativeButton("Batal",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                alertDialog.show();
            }
        });

        hideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fabRevealLayout.revealMainView();
            }
        });

        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if(checked){
                    tresholdView.setText("0.0");
                    setTreshold(0);
                }else{
                    tresholdView.setText("100.0");
                    setTreshold(100);
                }
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

    public void setGraph(){
        firebase.child("records_v2").orderByKey().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
                entries = new ArrayList<Entry>();
                labels = new ArrayList<String>();
                colors = new ArrayList<Integer>();
                ArrayList<Entry> suhuValues = new ArrayList<Entry>();
                ArrayList<Entry> kelembabanValues = new ArrayList<Entry>();
                ArrayList<Entry> lm35Values = new ArrayList<Entry>();
                ArrayList<Entry> pirValues = new ArrayList<Entry>();
                LineDataSet dataSetSuhu, dataSetKelembaban, datasetLm35, datasetPir;

                int number = 0;
                for(DataSnapshot object : dataSnapshot.getChildren()){
                    String value = object.getValue().toString();
                    String [] valueSplit = value.split("_",4);
                    float suhuValue, kelembabanValue, lm35Value, pirValue;
                    Log.d("DEBUGS", value);
                    try{
                        Log.d("DEBUGS", valueSplit[0]);
                        suhuValue = Float.parseFloat(valueSplit[0]);
                        kelembabanValue = Float.parseFloat(valueSplit[1]);
                        lm35Value = Float.parseFloat(valueSplit[2]);
                        pirValue = Float.parseFloat(valueSplit[3]);
                    }catch(Exception e){
                        suhuValue = 0;
                        kelembabanValue = 0;
                        lm35Value = 0;
                        pirValue = 0;
                    }

                    suhuValues.add(new Entry(number, (float) suhuValue));
                    kelembabanValues.add(new Entry(number, (float) kelembabanValue));
                    lm35Values.add(new Entry(number, (float) lm35Value));
                    pirValues.add(new Entry(number, (float) pirValue));

                    number++;
                }
                dataSetSuhu = new LineDataSet(suhuValues, "LM35");
                dataSetSuhu.setMode(LineDataSet.Mode.CUBIC_BEZIER);
                dataSetSuhu.setColor(Color.parseColor("#C3C60C"));
                dataSetSuhu.setDrawCircleHole(false);

                dataSetKelembaban = new LineDataSet(kelembabanValues, "PING SR 04");
                dataSetKelembaban.setMode(LineDataSet.Mode.CUBIC_BEZIER);
                dataSetKelembaban.setColor(Color.parseColor("#F08080"));
                dataSetKelembaban.setDrawCircleHole(false);

                datasetLm35 = new LineDataSet(lm35Values, "LDR");
                datasetLm35.setMode(LineDataSet.Mode.CUBIC_BEZIER);
                datasetLm35.setColor(Color.parseColor("#B2FF59"));
                datasetLm35.setDrawCircleHole(false);

                datasetPir = new LineDataSet(pirValues, "PIR");
                datasetPir.setMode(LineDataSet.Mode.CUBIC_BEZIER);
                datasetPir.setColor(Color.parseColor("#4A148C"));
                datasetPir.setDrawCircleHole(false);

                dataSets.add(dataSetSuhu);
                dataSets.add(dataSetKelembaban);
                dataSets.add(datasetLm35);
                dataSets.add(datasetPir);


                //set Axis
                chart.getAxisRight().setEnabled(false);
                chart.getXAxis().setDrawGridLines(false);
                YAxis yAxis = chart.getAxisLeft();
                yAxis.setAxisMaxValue(100);
                yAxis.setAxisMinValue(0);

                LineDataSet lineDataSet = new LineDataSet(entries, "");
                LineData dataSet = new LineData(dataSets);



                //Chart Interaction Control
                chart.setTouchEnabled(true);
                chart.setDragEnabled(true);
                chart.setScaleEnabled(true);
                chart.setPinchZoom(true);

                //set Dataset
                chart.setData(dataSet);

                //set Description
                chart.getDescription().setText("Monitoring");

                chart.animateXY(2000,2000);

                chart.invalidate();
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    public void getCurrentStat(){
        firebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                float ldr = Float.parseFloat(dataSnapshot.child("ldr").getValue().toString());
                float ping = Float.parseFloat(dataSnapshot.child("ping sr 04").getValue().toString());
                float lm35 = Float.parseFloat(dataSnapshot.child("lm35").getValue().toString());
                float pir = Float.parseFloat(dataSnapshot.child("pir").getValue().toString());
                setCurrentStat(lm35, ping, ldr, pir);
                float treshold = Float.parseFloat(dataSnapshot.child("set_treshold").getValue().toString());
                tresholdView.setText(treshold+"");
                Toast.makeText(InterfaceActivity.this, "Treshold berhasil diperbaharui.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    public void setTreshold(double treshold){
        DatabaseReference myRef = database.getReference("set_treshold");
        myRef.setValue(treshold);

    }

    public void setCurrentStat(float lm35, float ping, float ldr, float pir){
        lm35View.setText(lm35 +" \u2103");
        pingView.setText(ping +" m");
        ldrView.setText(ldr +" %");
        pirView.setText(pir +"");

        lm35ArcView.setProgress((int)lm35);
        pingArchView.setProgress((int)ping);
        ldrArchView.setProgress((int)ldr);
        pirArchView.setProgress((int)pir);
    }
}
