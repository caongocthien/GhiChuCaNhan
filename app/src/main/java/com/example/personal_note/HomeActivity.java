package com.example.personal_note;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        PieChart pieChart =findViewById(R.id.piechart);
        pieChart.setUsePercentValues(true);

        Description desc = new Description();
        desc.setText("Dashboard");
        desc.setTextSize(20f);

        pieChart.setDescription(desc);

        pieChart.setHoleRadius(0f);
        pieChart.setTransparentCircleRadius(0f);

        List<PieEntry> value = new ArrayList<>();
        value.add(new PieEntry( 60f,"Processing"));
        value.add(new PieEntry(20f,"Pending"));
        value.add(new PieEntry(20f,"Done"));

        PieDataSet pieDataSet = new PieDataSet(value, "TYPE");

        PieData pieData = new PieData(pieDataSet);

        pieChart.setData(pieData);
        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        pieChart.animateXY(1400,1400);
    }
}