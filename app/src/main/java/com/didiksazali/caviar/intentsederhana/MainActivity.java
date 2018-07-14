package com.didiksazali.caviar.intentsederhana;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
//    private Button btnMoveActivity;
//    @BindView(R.id.btn_move_activity) Button btnMoveActivity;
//    private Button btnMoveWithDataActivity;
//    @BindView(R.id.btn_move_activity_data) Button btnMoveWithDataActivity;
//    private Button btnMoveWithObject;
//    @BindView(R.id.btn_move_activity_object) Button btnMoveWithObject;
//    private Button btnDialPhone;
//    @BindView(R.id.btn_dial_number) Button btnDialPhone;
//    private Button btnMoveForResult;
//    @BindView(R.id.btn_move_for_result) Button btnMoveForResult;
//    private TextView tvResult;
    @BindView(R.id.tv_result) TextView tvResult;
    private int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

//        btnMoveActivity = (Button) findViewById(R.id.btn_move_activity);
//        btnMoveActivity.setOnClickListener(this);
//
//
//        btnMoveWithDataActivity = (Button) findViewById(R.id.btn_move_activity_data);
//        btnMoveWithDataActivity.setOnClickListener(this);
//
//        btnMoveWithObject = (Button) findViewById(R.id.btn_move_activity_object);
//        btnMoveWithObject.setOnClickListener(this);
//
//        btnDialPhone = (Button) findViewById(R.id.btn_dial_number);
//        btnDialPhone.setOnClickListener(this);
//
//        btnMoveForResult = (Button) findViewById(R.id.btn_move_for_result);
//        btnMoveForResult.setOnClickListener(this);

//        tvResult = (TextView) findViewById(R.id.tv_result);
    }

    @OnClick({R.id.btn_move_activity,R.id.btn_move_activity_data,R.id.btn_move_activity_object,R.id.btn_dial_number,
            R.id.btn_move_for_result})
    void onButtonClick(View v) {
        switch (v.getId()) {
            case R.id.btn_move_activity:
                Intent moveIntent = new Intent(MainActivity.this, MoveActivity.class);
                startActivity(moveIntent);
                break;
            case R.id.btn_move_activity_data:
                Intent moveWithDataIntent = new Intent(MainActivity.this, MoveWithDataActivity.class);
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "DicodingAcademy Boy");
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 5);
                startActivity(moveWithDataIntent);
                break;
            case R.id.btn_move_activity_object:
                Person mPerson = new Person();
                mPerson.setName("DicodingAcademy");
                mPerson.setAge(5);
                mPerson.setEmail("academy@dicoding.com");
                mPerson.setCity("Bandung");
                Intent moveWithObjectIntent = new Intent(MainActivity.this, MoveWithObjectActivity.class);
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, mPerson);
                startActivity(moveWithObjectIntent);
                break;
            case R.id.btn_dial_number:
                String phoneNumber = "082170002021";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
                startActivity(dialPhoneIntent);
                break;
            case R.id.btn_move_for_result:
                Intent moveForResultIntent = new Intent(MainActivity.this, MoveForResultActivity.class);
                startActivityForResult(moveForResultIntent, REQUEST_CODE);
                break;
        }
    }

//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.btn_move_activity:
//                Intent moveIntent = new Intent(MainActivity.this, MoveActivity.class);
//                startActivity(moveIntent);
//                break;
//            case R.id.btn_move_activity_data:
//                Intent moveWithDataIntent = new Intent(MainActivity.this, MoveWithDataActivity.class);
//                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "DicodingAcademy Boy");
//                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 5);
//                startActivity(moveWithDataIntent);
//                break;
//            case R.id.btn_move_activity_object:
//                Person mPerson = new Person();
//                mPerson.setName("DicodingAcademy");
//                mPerson.setAge(5);
//                mPerson.setEmail("academy@dicoding.com");
//                mPerson.setCity("Bandung");
//                Intent moveWithObjectIntent = new Intent(MainActivity.this, MoveWithObjectActivity.class);
//                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, mPerson);
//                startActivity(moveWithObjectIntent);
//                break;
//            case R.id.btn_dial_number:
//                String phoneNumber = "082170002021";
//                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
//                startActivity(dialPhoneIntent);
//                break;
//            case R.id.btn_move_for_result:
//                Intent moveForResultIntent = new Intent(MainActivity.this, MoveForResultActivity.class);
//                startActivityForResult(moveForResultIntent, REQUEST_CODE);
//                break;
//        }
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == MoveForResultActivity.RESULT_CODE) {
                int selectedValue = data.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0);
                tvResult.setText("Hasil : " + selectedValue);
            }
        }
    }
}