package azuredrop.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sendNotice = (Button)findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(this);
        Button sendNotice2 = (Button)findViewById(R.id.send_notice2);
        sendNotice2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, NotificationActivity.class);
        PendingIntent pi = PendingIntent.getActivities(this, 0, new Intent[]{intent}, 0);
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification = null;

        switch (v.getId()) {
            case R.id.send_notice:
                notification = new NotificationCompat.Builder(this)
                        .setContentTitle("This is content title")
                        .setContentText("This is content text")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                        .setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Luna.ogg")))
                        .setVibrate(new long[]{0, 1000, 1000, 1000})
                        .setLights(Color.GREEN, 1000,1000)
                        .setContentIntent(pi)
                        .setAutoCancel(true)
                        .build();
                manager.notify(1, notification);
                break;
            case R.id.send_notice2:
                notification = new NotificationCompat.Builder(this)
                        .setContentTitle("This is content title")
                        .setContentText("This is content text")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                        .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(
                                BitmapFactory.decodeResource(getResources(), R.drawable.big_image)
                        ))
                        .setPriority(NotificationCompat.PRIORITY_MAX)
                        .build();
                manager.notify(2, notification);
                break;
            default:
                break;
        }
    }
}
