package com.example.personal_note.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.personal_note.HomeActivity;
import com.example.personal_note.R;
import com.example.personal_note.adapter.CategoryAdapter;
import com.example.personal_note.db.Category;
import com.example.personal_note.db.DatabaseHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class AddCategoryFragment extends Fragment {

    Button btnAdd, btnClose;
    Dialog dialog;
    FloatingActionButton button;
    EditText edtName;
    ListView lvCategory;
    DatabaseHelper databaseHelper;
    ArrayList<Category> categoryArrayList;
    CategoryAdapter adapter;



    public AddCategoryFragment() {
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
        return inflater.inflate(R.layout.fragment_add_category, container, false);

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        categoryArrayList = databaseHelper.getCategory();
        adapter =new CategoryAdapter(getContext(),categoryArrayList);

        //show dialog
        button = view.findViewById(R.id.add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
                //Toast.makeText(getContext(), "thien", Toast.LENGTH_SHORT).show();
            }
        });


        //Hien dialog
        dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.category_dialog_layout);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().windowAnimations = R.style.Animation_Design_BottomSheetDialog;
        btnAdd = dialog.findViewById(R.id.btnAdd);
        btnClose = dialog.findViewById(R.id.btnClose);


        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


        //Them gia tri vao mang
        lvCategory = view.findViewById(R.id.lvCategory);
        edtName = dialog.findViewById(R.id.edtName);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                Date date = Calendar.getInstance().getTime();
                SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
                String strdate = formatter.format(date);


                Category category = new Category(name, strdate);

                if (databaseHelper.insertCategory(category)>0) {
                    adapter.clear();
                    categoryArrayList.addAll(databaseHelper.getCategory());
                    adapter.notifyDataSetChanged();
                    Toast.makeText(getContext(), "Them thanh cong", Toast.LENGTH_SHORT).show();

                }
                dialog.dismiss();



            }
        });

        lvCategory = view.findViewById(R.id.lvCategory);
        lvCategory.setAdapter(adapter);


    }


}