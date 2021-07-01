package com.summervacation.summervaction_2021;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.*;
import android.view.*;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.*;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.*;

public class Fragment1 extends Fragment {
    Context ct;
    ViewGroup viewGroup;

    DatePicker mDate;
    TextView mTxtDate;

    Button btnNow;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment1,container,false);

        ct = container.getContext();

        mTxtDate = viewGroup.findViewById(R.id.text);
        btnNow = viewGroup.findViewById(R.id.btnNow);

        Calendar c = Calendar.getInstance();

        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);




        btnNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(ct, android.R.style.Theme_Holo_Light_Dialog_MinWidth, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // TODO Auto-generated method stub

                        try {
                            Date d = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(year+"-"+(month+1)+"-"+dayOfMonth);
                            mTxtDate.setText(year +"/" + (month+1) + "/" + dayOfMonth);
                        } catch (Exception e) {
                            // TODO: handle exception
                            e.printStackTrace();
                        }
                    }
                }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));

                datePickerDialog.getDatePicker().setCalendarViewShown(false);
                datePickerDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                datePickerDialog.show();



                if (btnNow.isClickable()) {
                    datePickerDialog.show();
                }
            }
        });

        return viewGroup;
    }
}

