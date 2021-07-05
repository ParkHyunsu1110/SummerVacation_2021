package com.summervacation.summervaction_2021;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.*;
import android.view.*;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.*;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.*;

public class Fragment1 extends Fragment {

    //변수 목록
    Context ct;

    ViewGroup viewGroup;

    TextView mTxtDate;

    Button nowBtn, kindBtn, saveBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment1,container,false);

        ct = container.getContext();

        mTxtDate = viewGroup.findViewById(R.id.text);

        nowBtn = viewGroup.findViewById(R.id.btnNow);
        kindBtn = viewGroup.findViewById(R.id.kindBtn);
        saveBtn = viewGroup.findViewById(R.id.saveBtn);

        //DatePicker
        Calendar c = Calendar.getInstance();

        nowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(ct, android.R.style.Theme_Holo_Light_Dialog_MinWidth, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // TODO Auto-generated method stub

                        try {
                            Date d = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(year+"-"+(month+1)+"-"+dayOfMonth);
                            mTxtDate.setText(" " + year +"/" + (month+1) + "/" + dayOfMonth);
                        } catch (Exception e) {
                            // TODO: handle exception
                            e.printStackTrace();
                        }
                    }
                }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));

                datePickerDialog.getDatePicker().setCalendarViewShown(false);
                datePickerDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                datePickerDialog.show();

                if (nowBtn.isClickable()) {
                    datePickerDialog.show();
                }
            }
        });

        //종류 버튼
        kindBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] items = new String[]{"교통비","문화비","식비","쇼핑","정기지출","기타"};
                final int[] selectedIndex = {0};
                AlertDialog.Builder dialog = new AlertDialog.Builder(ct);
                dialog.setTitle("당신이 돈 쓴 이유는?").setSingleChoiceItems(items, 0,
                        new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        selectedIndex[0] = which;
                    }
                }).setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Toast.makeText(ct, items[selectedIndex[0]], Toast.LENGTH_SHORT).show();
                    }
                }).create().show();
            }
        });

        //지우면 안됨!!
        return viewGroup;
    }
}

