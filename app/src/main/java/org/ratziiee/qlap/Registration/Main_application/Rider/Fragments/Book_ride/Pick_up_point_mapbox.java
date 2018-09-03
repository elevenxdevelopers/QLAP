package org.ratziiee.qlap.Registration.Main_application.Rider.Fragments.Book_ride;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;

import org.ratziiee.qlap.R;
import org.ratziiee.qlap.Registration.Main_application.Driver.Fragments.my_trip_driver.trip_driver_2;
import org.ratziiee.qlap.Registration.Main_application.Driver.driver_navigation;
import org.ratziiee.qlap.Registration.Utils.AppConstants;
import org.ratziiee.qlap.Registration.Utils.utils;

public class Pick_up_point_mapbox extends AppCompatActivity {
    private MapView mapView;
    Button btn_done;
    TextView tv_qr_code;
    private AlertDialog b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_up_point_mapbox);

        tv_qr_code=findViewById(R.id.tv_qr_code);
        Mapbox.getInstance(this, AppConstants.MAP_BOX_API);
        mapView=findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);



        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {

            mapboxMap.addMarker(new MarkerOptions().position(new LatLng(28.7149,77.1154)));
            }
        });

        btn_done=findViewById(R.id.btn_done);
        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Pick_up_point_mapbox.this,book_ride_5.class);
                startActivity(i);
            }
        });

        int i=getIntent().getIntExtra("pick_up_subscription",0);
        if(i==1)
        {
            btn_done.setVisibility(View.GONE);
        }

        TextView toolbar_title=findViewById(R.id.toolbar_title);
        toolbar_title.setText("Subscription Confirmation");
        utils utils=new utils();
        utils.change_status_bar_color(this,this);
    }

    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    public void showChangeLangDialog(final Context context, Activity activity, String DialogMessage, final int uniqueId) {

        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        LayoutInflater inflater = activity.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_qr_code, null);
        dialogBuilder.setView(dialogView);
        dialogBuilder.setCancelable(true);
        final Button yes=(Button)dialogView.findViewById(R.id.btn_yes);
        final Button no=(Button)dialogView.findViewById(R.id.btn_no);
        TextView tv_dialog=(TextView)dialogView.findViewById(R.id.tv_dialog);
        tv_dialog.setText(DialogMessage);




        b = dialogBuilder.create();
        b.show();

    }
}
