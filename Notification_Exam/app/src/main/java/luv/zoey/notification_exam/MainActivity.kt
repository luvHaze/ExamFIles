package luv.zoey.notification_exam

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val CHANNEL_ID = "channelID"
    val CHANNEL_NAME = "channelName"
    val NOTIFICATION_ID = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 4. 팬딩 인텐트 생성
        val intent = Intent(this, MainActivity::class.java)
        val pendingintent = TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        }

        // 1. 노티 채널을 만들어준다.
        createNotificationChannel()

        // 2. 띄워줄 노티를 만들어 준다.
        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Awesome notification")
                .setContentText("This is the content text")
                .setSmallIcon(R.drawable.ic_baseline_star_24)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingintent) // 노티에 팬딩 인텐트를 설정해주면 클릭시 해당 인텐트가 실행됨
                .build()

        // 3. 노티 매니저 생성후 매니저의 notify로 노티를 띄운다
        val notificationManager = NotificationManagerCompat.from(this)
        btnShowNotification.setOnClickListener {
            notificationManager.notify(NOTIFICATION_ID, notification)
        }

    }


    fun createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME,
                    NotificationManager.IMPORTANCE_DEFAULT).apply {
                lightColor = Color.GREEN
                enableLights(true)
            }

            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }
}