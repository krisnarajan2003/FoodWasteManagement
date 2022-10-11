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

public class signpage1<NotificationChannal> extends AppCompatActivity {
    Button signupbutton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signpage1);
        signupbutton = findViewById(R.id.signupbutton);
        if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.O){
            NotificationChannal channel;
            channel = (NotificationChannal) new NotificationChannel("notify","notify", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel((NotificationChannel) channel);

        }


        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMain2();
                NotificationCompat.Builder builder = new NotificationCompat.Builder(signpage1.this,"notify");
                builder.setContentTitle("SIGN UP");
                builder.setContentText("Sign up successfully");
                builder.setSmallIcon(R.drawable.foodiconn);
                builder.setAutoCancel(true);

                NotificationManagerCompat managerCompat= NotificationManagerCompat.from(signpage1.this);
                managerCompat.notify(1,builder.build());


            }

        });
    }

    private void openMain2() {
        startActivity(new Intent(this,signpage1.class));
    }



}