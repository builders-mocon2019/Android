package com.example.builders.Auth;


import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.builders.R;
import com.tsongkha.spinnerdatepicker.DatePicker;
import com.tsongkha.spinnerdatepicker.DatePickerDialog;
import com.tsongkha.spinnerdatepicker.SpinnerDatePickerDialogBuilder;

public class RegiFragment1 extends Fragment implements com.tsongkha.spinnerdatepicker.DatePickerDialog.OnDateSetListener {

    TextView regiTxt1, regiBirthYear, regiBirthMonth, regiBirthDay, regiResult;
    LinearLayout regiBirth;

    private int nowYear=2019, nowMonth=0, nowDay=1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_register1, container, false);

        regiTxt1 = v.findViewById(R.id.regi_txt1);
        Shader textShader = new LinearGradient(150, 0, 0, regiTxt1.getPaint().getTextSize(),
                new int[]{getResources().getColor(R.color.gradientOrange), getResources().getColor(R.color.gradientYellow)},
                new float[]{0, 1}, Shader.TileMode.CLAMP);
        regiTxt1.getPaint().setShader(textShader);


        regiBirthYear = v.findViewById(R.id.regi_birthYear);
        regiBirthMonth = v.findViewById(R.id.regi_birthMonth);
        regiBirthDay = v.findViewById(R.id.regi_birthDay);

        regiResult = v.findViewById(R.id.regi1_result);
        regiBirth = v.findViewById(R.id.regi_birth);
        regiBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SpinnerDatePickerDialogBuilder()
                        .context(getContext())
                        .callback(new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                if(year>2019){
                                    Toast.makeText(getContext(), "현재 연도 이후로 설정할 수 없습니다.", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    nowYear = year;
                                    nowMonth = monthOfYear;
                                    nowDay = dayOfMonth;
                                    regiBirthYear.setText(year + "년");
                                    regiBirthMonth.setText(((monthOfYear+1)<10?"0":"") + (monthOfYear + 1) + "월");
                                    regiBirthDay.setText(((dayOfMonth)<10?"0":"") + dayOfMonth + "일");
                                    regiResult.setText(year + "/" + (monthOfYear + 1) + "/" + dayOfMonth);
                                }
                            }
                        })
                        .spinnerTheme(R.style.DatePickerStyle)
                        .defaultDate(nowYear, nowMonth, nowDay)
                        .showTitle(false)
                        .build()
                        .show();
            }
        });

        return v;


    }


    @Override
    public void onDateSet(com.tsongkha.spinnerdatepicker.DatePicker view, int year, int monthOfYear, int dayOfMonth) {

    }
}
