package com.example.user.seoulapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

//종로구 공원//
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(this, LoadingActivity.class));
    }

    //버튼은 지도 이미지 밑에 숨겨놨음. 아이콘(지도상 물방울 아이콘)을 누르면 상세 페이지로 넘어감
    public void onClickButton1(View view){
        Intent intent = new Intent(this, Jongro_playground.class);
        startActivity(intent);

        // ! 화면 전환시 아래 메세지 나옴
        Toast.makeText(this, "삼청 공원을 선택하셨습니다", Toast.LENGTH_SHORT).show();
    }


    /*
    protected void onButton1Clicked(View v)
    {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
     */
}
