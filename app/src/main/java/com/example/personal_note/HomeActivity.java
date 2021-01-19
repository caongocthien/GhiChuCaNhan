package com.example.personal_note;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.personal_note.db.DashBoard;
import com.example.personal_note.db.DatabaseHelper;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.FSize;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends Fragment {
    DatabaseHelper databaseHelper;
    ArrayList<DashBoard> dashBoards = new ArrayList<>();
    TextView textView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home, container, false);
        PieChart pieChart = (PieChart) view.findViewById(R.id.pieChart);
        pieChart.setUsePercentValues(true);
        databaseHelper =new DatabaseHelper(getContext());
        dashBoards=databaseHelper.getDashBoard();

        Description desc = new Description();

        desc.setText("Dashboard");
        desc.setTextSize(100f);

        pieChart.setDescription(desc);

        pieChart.setHoleRadius(0f);
        pieChart.setTransparentCircleRadius(0f);

        List<PieEntry> value = new ArrayList<>();

        for(int i = 0; i<dashBoards.size(); i++){

            DashBoard dashBoard = dashBoards.get(i);

            value.add(new PieEntry(dashBoard.getCount(), dashBoard.getName()));


        }


    //    value.add(new PieEntry(60f, "Processing"));
     //   value.add(new PieEntry(20f, "Pending"));
      //  value.add(new PieEntry(20f, "Done"));
        pieChart.setEntryLabelTextSize(20f);

        PieDataSet pieDataSet = new PieDataSet(value, "TYPE");
        pieDataSet.setFormSize(40f);
        PieData pieData = new PieData(pieDataSet);

        pieDataSet.setFormSize(40f);

        pieChart.setEntryLabelTextSize(20f);

        pieChart.setData(pieData);

        pieDataSet.setColors(ColorTemplate.PASTEL_COLORS);
        pieDataSet.setValueTextSize(30f);
        pieDataSet.setValueTextColor(Color.RED);



        pieChart.animateXY(1400, 1400);

        return view;
    }

}



