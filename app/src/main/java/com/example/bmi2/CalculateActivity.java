package com.example.bmi2;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CalculateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);


        Button back = findViewById(R.id.back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button calculate = findViewById(R.id.cal_button);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText heightEditor = findViewById(R.id.height_editText);
                EditText weightEditor = findViewById(R.id.weight_editText);

                int h = Integer.parseInt(heightEditor.getText().toString());
                int w = Integer.parseInt(weightEditor.getText().toString());
                float bmi = calBmi(h, w);

                String printText = "";
                if (bmi < 18.5)
                    printText = "ผอมเกินไป";

                else if (bmi < 25)
                    printText = "ปกติ";

                else if (bmi < 30)
                    printText = "อ้วน";

                else
                    printText = "อ้วนเกินไป";

                Toast t = Toast.makeText(CalculateActivity.this, printText, Toast.LENGTH_LONG);
                t.show();


                AlertDialog.Builder dialog = new AlertDialog.Builder(CalculateActivity.this);
                dialog.setTitle("Resalt");
                dialog.setMessage(printText);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //todo : ถ้าไม่่ใส่
                    }
                });
                dialog.setNegativeButton("NO", null);
                dialog.setCancelable(false);
                // ถ้าเป็น true จะสามารถกดออกจากตรงไหนก็ได้ที่ไม่ใช่ปุ่ม
                dialog.show();
            }
        });
    }

    private float calBmi(int h, int w) {
        float height = h / 100f;
        float bmi = w / (height * height);
        return bmi;
    }


}
