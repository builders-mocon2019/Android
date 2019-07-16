package com.example.builders.Auth;


import android.Manifest;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.builders.API.APIManager;
import com.example.builders.R;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;
import com.tsongkha.spinnerdatepicker.DatePicker;
import com.tsongkha.spinnerdatepicker.DatePickerDialog;
import com.tsongkha.spinnerdatepicker.SpinnerDatePickerDialogBuilder;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.app.Activity.RESULT_OK;

public class RegiFragment1 extends Fragment implements com.tsongkha.spinnerdatepicker.DatePickerDialog.OnDateSetListener {

    TextView regiTxt1, regiBirthYear, regiBirthMonth, regiBirthDay, regiResult, imageResult;
    LinearLayout regiBirth;

    CircleImageView imageView;

    private int nowYear = 2019, nowMonth = 0, nowDay = 1;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_register1, container, false);

        imageView = v.findViewById(R.id.regi1_image);
        imageResult = v.findViewById(R.id.regi1_imageResult);

        Button testBtn = v.findViewById(R.id.testBtn);
        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 1);

            }
        });

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
                                if (year > 2019) {
                                    Toast.makeText(getContext(), "현재 연도 이후로 설정할 수 없습니다.", Toast.LENGTH_SHORT).show();
                                } else {
                                    nowYear = year;
                                    nowMonth = monthOfYear;
                                    nowDay = dayOfMonth;
                                    regiBirthYear.setText(year + "년");
                                    regiBirthMonth.setText(((monthOfYear + 1) < 10 ? "0" : "") + (monthOfYear + 1) + "월");
                                    regiBirthDay.setText(((dayOfMonth) < 10 ? "0" : "") + dayOfMonth + "일");
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
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                try {
                    // 선택한 이미지에서 비트맵 생성
                    InputStream in = getContext().getContentResolver().openInputStream(data.getData());
                    Bitmap img = BitmapFactory.decodeStream(in);
                    in.close();

                    imageView.setImageBitmap(img);

                    ByteArrayOutputStream outStream = new ByteArrayOutputStream();
                    Resources res = getResources();

                    img.compress(Bitmap.CompressFormat.PNG, 100, outStream);
                    byte[] image = outStream.toByteArray();
                    String profileImageBase64 = Base64.encodeToString(image, 0);

                    Log.d("asd", "onActivityResult: "+profileImageBase64);
                    imageResult.setText(profileImageBase64);

                    // 이미지 표시
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


        //APIManager.instance();
    }

    @Override
    public void onDateSet(com.tsongkha.spinnerdatepicker.DatePicker view, int year, int monthOfYear, int dayOfMonth) {

    }
}
