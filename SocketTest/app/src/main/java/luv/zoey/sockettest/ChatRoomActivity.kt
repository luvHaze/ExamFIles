package luv.zoey.sockettest

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import io.socket.client.IO
import io.socket.client.Socket
import io.socket.emitter.Emitter
import kotlinx.android.synthetic.main.activity_chat_room.*
import org.json.JSONException
import org.json.JSONObject
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*


class ChatRoomActivity : AppCompatActivity() {

    private lateinit var preferences: SharedPreferences
    private lateinit var chating_Text: EditText
    private lateinit var chat_Send_Button: Button

    private var hasConnection: Boolean = false
    private var thread2: Thread? = null
    private var startTyping = false
    private var time = 2

    private var mSocket: Socket = IO.socket("http://8171a12768de.ngrok.io")

    //리사이클러뷰
    var arrayList = arrayListOf<ChatModel>()
    val mAdapter = ChatAdapter(this, arrayList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_room)
        preferences = getSharedPreferences("USERSIGN", Context.MODE_PRIVATE)

        chat_recyclerview.adapter = mAdapter

        val lm = LinearLayoutManager(this)
        chat_recyclerview.layoutManager = lm
        chat_recyclerview.setHasFixedSize(true) // 아이템이 추가 삭제될때 크기측면에서 오류 안나게 해줌

        chat_Send_Button = findViewById(R.id.chat_Send_Button)
        chating_Text = findViewById(R.id.chating_Text)

        if (savedInstanceState != null) {
            hasConnection = savedInstanceState.getBoolean("hasConnection")
        }

        if (hasConnection) {

        } else {
            //소켓연결
            mSocket.connect()

            //서버에 신호 보내는거같음 emit Listenser들 실행
            //socket.on은 수신을 뜻함

            mSocket.on("connect user", onNewUser)
            mSocket.on("chat message", onNewMessage)

            val userId = JSONObject()
            try {
                userId.put("username", preferences.getString("name", "") + "Connected")
                userId.put("roomName", "room_example")
                Log.e("username", preferences.getString("name", "") + "Connected")

                // socket.emit은 메세지 전송
                mSocket.emit("connect user", userId)

            } catch (e: JSONException) {
                e.printStackTrace()
            }
        }

        hasConnection = true

        chat_Send_Button.setOnClickListener {
            sendMessage()
        }

    }


    private var onNewMessage: Emitter.Listener = Emitter.Listener { args ->

        runOnUiThread(Runnable {
            val data = args[0] as JSONObject
            val name: String
            val script: String
            val profile_image: String
            val date_time: String

            try {
                Log.e("asdfsd", data.toString())
                name = data.getString("name")
                script = data.getString("script")
                profile_image = data.getString("profile_image")
                date_time = data.getString("date_time")

                val format = ChatModel(name, script, profile_image, date_time)
                mAdapter.addItem(format)
                mAdapter.notifyDataSetChanged()
                Log.e("new me",name )

            } catch (e: Exception) {
                return@Runnable
            }
        })


    }

    // 어플 키자마자 서버에 connect user 하고 프로젝트오 onNewUser 실행
    private var onNewUser: Emitter.Listener = Emitter.Listener { args ->
        runOnUiThread(Runnable {

            val length = args.size

            if (length == 0) return@Runnable

            var username = args[0].toString()
            try {
                val `object` = JSONObject(username)
                username = `object`.getString("username")
            } catch (e: JSONException) {
                e.printStackTrace()
            }
        })
    }


    private fun sendMessage() {
        preferences = getSharedPreferences("USERSIGN", Context.MODE_PRIVATE)
        val now = System.currentTimeMillis()
        val date = Date(now)
        // 나중에 바꿔줄것 밑의 yyyy-mm-dd는 그냥 포멧임
        val sdf = SimpleDateFormat("yyyy-MM-dd")

        val getTime = sdf.format(date)

        val message = chating_Text.getText().toString().trim({ it <= ' ' })
        if (TextUtils.isEmpty(message)) {
            return
        }
        chating_Text.setText("")
        val jsonObject = JSONObject()
        try {
            jsonObject.put("name", preferences.getString("name", ""))
            jsonObject.put("script", message)
            jsonObject.put("profile_image", "example")
            jsonObject.put("date_time", getTime)
            jsonObject.put("roomName", "room_example")
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        Log.e("챗룸", "sendMessage: 1" + mSocket.emit("chat message", jsonObject))
        Log.e("sendmmm", preferences.getString("name", ""))
    }

}
