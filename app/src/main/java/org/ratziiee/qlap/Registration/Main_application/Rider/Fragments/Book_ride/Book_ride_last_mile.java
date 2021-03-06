package org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Book_ride;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Subscription.Subscription_activity;
import org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Subscription.subscription;
import org.ratziiee.qlap.Registration.Utils.Location.StalkerCallback;
import org.ratziiee.qlap.Registration.Utils.utils;

public class Book_ride_last_mile extends AppCompatActivity implements StalkerCallback{
    Button btn_save;
    String TAG="Book_ride_1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_ride_last_mile);


        TextView toolbar_title=findViewById(R.id.toolbar_title);
        toolbar_title.setText("Book Ride");
        utils utils=new utils();
        utils.change_status_bar_color(this,this);
        btn_save=findViewById(R.id.btn_save);

        TextView tv_subs=findViewById(R.id.tv_subs);
        tv_subs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Book_ride_last_mile.this, Subscription_activity.class);
                startActivity(i);
            }
        });



        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Book_ride_last_mile.this,Book_ride_2.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onExecuted(Location location, int callingActivity) {
        Log.d(TAG, "onExecuted: "+location);
    }

    @Override
    public void onFailedStalklerCallback(int failCode, int callingActivity) {

        Log.d(TAG, "onFailedStalklerCallback: "+failCode);
    }
}
