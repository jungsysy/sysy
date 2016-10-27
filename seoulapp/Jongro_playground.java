package com.example.user.seoulapp;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import static android.widget.AdapterView.*;

class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    ListView listView;
    myAdapter adapter;

    // !! 리스트에 항목추가
    String[] menu = {"전화 바로걸기", "홈페이지 바로가기", "위치기반", "위치 및 길찾기", "시설정보", "기타정보", "커뮤니티"};
    //int[] imgs = {R.drawable.book, R.drawable.good, R.drawable.book, R.drawable.book, R.drawable.book, R.drawable.book,  R.drawable.book};

    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = (ListView) findViewById(R.id.listView);
        adapter = new myAdapter();
        listView.setAdapter(adapter);
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        listView.setOnItemClickListener(this);
    }


    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    // !! 중요코드 세세한 정보 아직 구현되지 않은 페이지는 test로 이동하도록함.
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

        if (position == 0) {
            Intent intent = new Intent( Intent.ACTION_DIAL );
            intent.setData( Uri.parse( "tel:02-3219-7000" ) ); // !! 전화번호바꾸기
            startActivity( intent );
        }
        else if (position == 1) {  // !! 홈페이지 바로가기 모바일 주소로 넣어주는게 좋음
            Uri uri = Uri.parse("http://gslib.sen.go.kr/gslib_index.jsp");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            startActivity(intent);
        }
        else if (position == 2) { // !! 위치기반 만든 후 연결 임시로 test에 연결함
            Intent intent2 = new Intent(MainActivity.this, test.class);
            startActivity(intent2);
        }

        else if (position == 3) { // !! 위치 및 길찾기
            Intent intent2 = new Intent(MainActivity.this, test.class);
            startActivity(intent2);
        }

        else if (position == 4) { // !! 시설정보 (도서관의 경우 휴관일 등)
            Intent intent2 = new Intent(MainActivity.this, test.class);
            startActivity(intent2);
        }

        else if (position == 5) { // !! 기타정보
            Intent intent2 = new Intent(MainActivity.this, test.class);
            startActivity(intent2);
        }

        else if (position == 6) { // !! 커뮤니티 임시로 test 액티비티로 연결
            Intent intent2 = new Intent(MainActivity.this, test.class);
            startActivity(intent2);
        }


    }


    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }


    class myAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return menu.length;
        }

        @Override
        public Object getItem(int position) {
            return menu[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            MenuItemView view = new MenuItemView(getApplicationContext());
            ImageView imgView = (ImageView)view.findViewById(R.id.imageView2);

            view.setMenu(menu[position]);
            //imgView.setImageResource(imgs[position]);


            return view;

        }
    }
}
