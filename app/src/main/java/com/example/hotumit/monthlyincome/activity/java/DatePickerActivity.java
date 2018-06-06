package com.example.hotumit.monthlyincome.activity.java;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.hotumit.monthlyincome.R;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;

public class DatePickerActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private DatePickerDialog dpd;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Fragment datePickerFragment;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.datepicker_layout);

        init();

    }

    private void init() {
        Button dateButton = findViewById(R.id.date_button);
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();

                if (dpd == null) {
                    dpd = DatePickerDialog.newInstance(
                            DatePickerActivity.this,
                            now.get(Calendar.YEAR),
                            now.get(Calendar.MONTH),
                            now.get(Calendar.DAY_OF_MONTH)
                    );

                }

           /*     else {
                    dpd.initialize(
                            DatePickerActivity.this,
                            now.get(Calendar.YEAR),
                            now.get(Calendar.MONTH),
                            now.get(Calendar.DAY_OF_MONTH)
                    );
                    Toast.makeText(Contextor.getInstance().getContext(),"Boom",Toast.LENGTH_LONG).show();
                }
*/
                dpd.show(getFragmentManager(), "Datepickerdialog");
            }
        });

    }




    @Override
    public void onResume() {
        super.onResume();
        DatePickerDialog dpd = (DatePickerDialog) getFragmentManager().findFragmentByTag("Datepickerdialog");
        if(dpd != null) dpd.setOnDateSetListener(this);
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String date = year+"-"+monthOfYear+"-"+dayOfMonth;
        Log.e("HHHHHHHHHHHH","HHHHHHHHHHH"+date);
        new MaterialDialog.Builder(this)
                .title("Please Select Enddate")
                .content(date)
                .positiveText("Ok")
                .show();

        init();

    }
}