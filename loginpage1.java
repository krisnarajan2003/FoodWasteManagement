package com.example.foodwaste;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class loginpage1<NotificationChannal> extends AppCompatActivity {
    Button logbutton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage1);
        logbutton = findViewById(R.id.logbutton);
        if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.O){
            NotificationChannal channel;
            channel = (NotificationChannal) new NotificationChannel("notify","notify", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel((NotificationChannel) channel);

        }


        logbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMain2();
                NotificationCompat.Builder builder = new NotificationCompat.Builder(loginpage1.this,"notify");
                builder.setContentTitle("LOGIN");
                builder.setContentText("LOGIN successfully");
                builder.setSmallIcon(R.drawable.foodiconn);
                builder.setAutoCancel(true);

                NotificationManagerCompat managerCompat= NotificationManagerCompat.from(loginpage1.this);
                managerCompat.notify(1,builder.build());


            }

        });
    }

    private void openMain2() {
        startActivity(new Intent(this,loginpage1.class));
    }



}