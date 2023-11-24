package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static  String TAG = "ThuyTeo";

    private EditText editTextName, editTextMSSV, editTextAge;
    private CheckBox dabong, choigame;
    private RadioGroup radioGroupGender;
    private RadioButton nam , nu;
    private Button buttonSave;
    private TextView textViewResult;




    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: ");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate: ");
        editTextName = findViewById(R.id.edtTen);
        editTextMSSV = findViewById(R.id.edtMSSV);
        editTextAge = findViewById(R.id.edtTuoi);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        dabong = findViewById(R.id.cbDaBong);
        choigame = findViewById(R.id.cbChoiGame);
        buttonSave = findViewById(R.id.btnLuu);
        textViewResult = findViewById(R.id.edtKQ);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                luuThongtin();
            }
        });



    }

    private String getSelectedGender() {
        RadioGroup radioGroup = findViewById(R.id.radioGroupGender);
        int selectedId = radioGroup.getCheckedRadioButtonId();

        if (selectedId == R.id.radioNam) {
            return "Nam";
        } else if (selectedId == R.id.radioNu) {
            return "Nữ";
        } else {
            return "Không rõ";
        }
    }
    private void luuThongtin() {
        String name = editTextName.getText().toString().trim();
        String mssv = editTextMSSV.getText().toString().trim();
        String ageStr = editTextAge.getText().toString().trim();


        if (name.isEmpty() || mssv.isEmpty() || ageStr.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        int age = Integer.parseInt(ageStr);





        // Xử lý sở thích
        StringBuilder hobbiesBuilder = new StringBuilder("Hobbies: ");
        if (dabong.isChecked()) {
            hobbiesBuilder.append("Đá bóng, ");
        }
        if (choigame.isChecked()) {
            hobbiesBuilder.append("Chơi game, ");
        }

        // Loại bỏ dấu phẩy cuối cùng nếu có
        String hobbies = hobbiesBuilder.toString().replaceAll(", $", "");

        // Hiển thị kết quả
        String result = "Ten: " + name + "\nMSSV: " + mssv + "\nTuoi: " + age + "\nGioi Tinh: " + getSelectedGender() + "\n" + hobbies;
        textViewResult.setText(result);
    }
    }
