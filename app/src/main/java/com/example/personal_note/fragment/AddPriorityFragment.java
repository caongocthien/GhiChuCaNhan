package com.example.personal_note.fragment;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.personal_note.R;
import com.example.personal_note.adapter.CategoryAdapter;
import com.example.personal_note.adapter.PriorityAdapter;
import com.example.personal_note.db.Category;
import com.example.personal_note.db.DatabaseHelper;
import com.example.personal_note.db.Priority;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class AddPriorityFragment extends Fragment {

    Button btnAdd, btnClose,bai2;
    Dialog dialog;
    FloatingActionButton button;
    EditText edtName;
    ListView lvPriority;
    ArrayList arrayList;
    ArrayAdapter arrayAdapter;
    DatabaseHelper databaseHelper;


    public AddPriorityFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //
        }

        databaseHelper = new DatabaseHelper(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_priority, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //show dialog
        button = view.findViewById(R.id.add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });

        //tao dialog

        dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.priority_dialog_layout);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().windowAnimations = R.style.Animation_Design_BottomSheetDialog;
        edtName = dialog.findViewById(R.id.edtName);
        btnAdd = dialog.findViewById(R.id.btnAdd);
        btnClose = dialog.findViewById(R.id.btnClose);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


        //Them gia tri vao mang
        lvPriority = view.findViewById(R.id.lvPriority);
        edtName = dialog.findViewById(R.id.edtName);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                Date date = Calendar.getInstance().getTime();
                SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
                String strdate = formatter.format(date);


                Priority priority = new Priority(name, strdate);

                if (databaseHelper.insertPriority(priority)>0) {
                    arrayAdapter.clear();
                    arrayList.addAll(databaseHelper.getPriority());
                    arrayAdapter.notifyDataSetChanged();
                    Toast.makeText(getContext(), "Them thanh cong", Toast.LENGTH_SHORT).show();
                }


            }
        });


        ArrayList<Priority> priorityArrayList = databaseHelper.getPriority();
        PriorityAdapter adapter = new PriorityAdapter( getContext(),priorityArrayList);
        lvPriority = view.findViewById(R.id.lvPriority);
        lvPriority.setAdapter(adapter);


    }

}