package com.example.d_gille.teamproject;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.support.v4.app.NotificationCompat;

import java.util.ArrayList;
import java.util.List;

public class AdministratorDataDisplayActivity extends AppCompatActivity
{
    protected Button manageButton;
    protected Button driverButton;
    protected Button addButton;
    protected ListView dataDisplaysSettingsListView;
    DataInputs inputs;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator_data_display);

        manageButton=(Button) findViewById(R.id.manageUserButton);
        driverButton=(Button) findViewById(R.id.driverButton);
        addButton=(Button) findViewById(R.id.addDataButton);
        dataDisplaysSettingsListView=findViewById(R.id.dataDisplayListView);

        manageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToManageActivity();
            }
        });

        driverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDriver();
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addData();
            }
        });



        loadListView();
    }


    public void loadListView()
    {
       List<DataInputs> dataInputsList=new ArrayList<>();


        ArrayList<String> dataInputsListText = new ArrayList<>();

        for (int i = 0; i < dataInputsList.size(); i++) {
            String temp = "";
            temp += dataInputsList.get(i).getOilTemperature() + "\n";
            temp += dataInputsList.get(i).getOilPressure() + "\n";
            temp += dataInputsList.get(i).getFuelPressure() + "\n";
            temp += dataInputsList.get(i).getCoolantTemperature() + "\n";
            temp += dataInputsList.get(i).getEngineRPM() + "\n";
            temp += dataInputsList.get(i).getGear();

            dataInputsListText.add(temp);

        }

        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataInputsListText);
        dataDisplaysSettingsListView.setAdapter(arrayAdapter);



    }

    public void goToManageActivity()
    {
        Intent intent=new Intent(AdministratorDataDisplayActivity.this,ManageUsersActivity.class);
        startActivity(intent);
    }


    public void goToDriver()
    {


    }

    public void addData()
    {

        loadListView();

        if (!inputs.rangeOilTemperature() ||
                !inputs.rangeOilPressure() ||
                !inputs.rangeFuelPressure() ||
                !inputs.rangeFuelTemperature() ||
                !inputs.rangeCoolantTemperature() ||
                !inputs.rangeEngineRPM())
        {
            sendNotification();
        }
    }


    public void sendNotification()
    {

        String contentText = "The following issues of the sensor require attention: ";
        List<String> issues = new ArrayList<>();
        if (!inputs.rangeOilTemperature())
        {
            issues.add("oil temperature");
        }

        if (!inputs.rangeOilPressure())
        {
            issues.add("oil pressure");
        }

        if   (!inputs.rangeFuelPressure())
        {
            issues.add("fuel pressure");
        }

        if (!inputs.rangeFuelTemperature())
        {
            issues.add("Fuel temperature");
        }

        if (!inputs.rangeCoolantTemperature())
        {
            issues.add("Coolant temperature");
        }

        if (!inputs.rangeEngineRPM())
        {
            issues.add("Engine RPM");
        }

        contentText += TextUtils.join(", ", issues);

        //Builds the notification
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle("Warning!")
                .setContentText(contentText);

        //Creates and display the notification related to oil temperature
        Intent notificationIntent=new Intent(this,AdministratorDataDisplayActivity.class);
        PendingIntent contentIntent=PendingIntent.getActivity(this,0,notificationIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        notificationBuilder.setContentIntent(contentIntent);


        //Add as notification
        NotificationManager notificationManager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,notificationBuilder.build());

    }//end of function


}//end of activity
