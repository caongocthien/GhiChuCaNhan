package com.example.personal_note.fragment;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.personal_note.R;
import com.example.personal_note.adapter.CategoryAdapter;
import com.example.personal_note.adapter.PriorityAdapter;
import com.example.personal_note.adapter.StatusAdapter;
import com.example.personal_note.db.Category;
import com.example.personal_note.db.DatabaseHelper;
import com.example.personal_note.db.Priority;
import com.example.personal_note.db.Status;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class AddNoteFragment extends Fragment {

    Button btnAdd, btnClose;
    Dialog dialog;
    FloatingActionButton button;
    EditText edtName;
    Spinner spnCat, spnSta,spnPri;

    DatabaseHelper databaseHelper;
    ArrayAdapter<Category> adapterCat;
    ArrayList<Category> categoryArrayList;

    ArrayAdapter<Priority> adapterPri;
    ArrayList<Priority> priorityArrayList;

    ArrayAdapter<Status> adapterSta;
    ArrayList<Status> statusArrayList;



    public AddNoteFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        databaseHelper = new DatabaseHelper(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_note, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //khoi tao
        categoryArrayList = databaseHelper.getCategory();
        adapterCat = new CategoryAdapter(getContext(), categoryArrayList);

        statusArrayList = databaseHelper.getStatus();
        adapterSta = new StatusAdapter(getContext(), statusArrayList);

        priorityArrayList = databaseHelper.getPriority();
        adapterPri= new PriorityAdapter(getContext(), priorityArrayList);


        //show dialog
        button = view.findViewById(R.id.add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });


        //them note

        dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.note_dialog_layout);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().windowAnimations = R.style.Animation_Design_BottomSheetDialog;
        btnAdd = dialog.findViewById(R.id.btnAdd);
        btnClose = dialog.findViewById(R.id.btnClose);
        edtName = dialog.findViewById(R.id.edtName);



        //spinner
        spnCat = dialog.findViewById(R.id.spnCategory);
        spnPri = dialog.findViewById(R.id.spnPriority);
        spnSta = dialog.findViewById(R.id.spnStatus);

    //set adapter
        spnCat.setAdapter(adapterCat);
        spnPri.setAdapter(adapterPri);
        spnSta.setAdapter(adapterSta);





        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });




        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code
            }
        });



    }
}