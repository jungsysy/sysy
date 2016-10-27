package com.example.user.seoulapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by user on 2016-10-08.
 */

public class MenuItemView extends LinearLayout {
    TextView menuTextView;

    public MenuItemView(Context context) {
        super(context);
        inflation_init(context);

        menuTextView = (TextView) findViewById(R.id.menuTextView);
    }

    private void inflation_init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.menu_item, this, true);
    }

    public void setMenu(String menu){
        menuTextView.setText(menu);
    }


}
