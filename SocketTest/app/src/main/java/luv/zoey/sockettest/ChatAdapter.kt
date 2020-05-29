package luv.zoey.sockettest

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class ChatAdapter(
    val context: Context,
    val arrayList: ArrayList<ChatModel>
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var preferences: SharedPreferences

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val chat_Text = itemView.findViewById<TextView>(R.id.chat_Text)
        val chat_Time = itemView.findViewById<TextView>(R.id.chat_Time)

    }

    inner class Holder2(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val chat_You_Image = itemView?.findViewById<ImageView>(R.id.chat_You_Image)
        val chat_You_Name = itemView?.findViewById<TextView>(R.id.chat_You_Name)
        val chat_Text = itemView?.findViewById<TextView>(R.id.chat_Text)
        val chat_Time = itemView?.findViewById<TextView>(R.id.chat_Time)
    }


    // 상황에 따라서 뷰타입을 두가지로 지정해 줄 수 있다.
    override fun getItemViewType(position: Int): Int {
        preferences = context.getSharedPreferences("USERSIGN", Context.MODE_PRIVATE)
        val currentUserName = preferences.getString("name", "")

        // 내 아이디와 arraylist의 name이 같다면 내꺼 아니면 상대방꺼
        // 즉 상대 채팅인지 내 채팅인지를 prefernces에 담긴 값을 통해 판단 -> 각기 다른 뷰홀더로 뷰를 생성한다.
        return when (arrayList[position].name) {
            currentUserName -> {
                1
            }
            else -> {
                2
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View
        // getItemViewType 에서 뷰타입에 따라서 각각 다른 홀더로 뷰를 리턴해준다.

        return when (viewType) {
            1 -> {
                view = LayoutInflater.from(context).inflate(R.layout.item_my_chat, parent, false)
                Holder(view)
            }
            else -> {
                view = LayoutInflater.from(context).inflate(R.layout.item_your_chat, parent, false)
                Holder2(view)
            }

        }

    }


    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        when (viewHolder) {
            is Holder -> {
                viewHolder.apply {
                    chat_Text.text = arrayList[position].script
                    chat_Time.text = arrayList[position].date_time
                }
            }
            is Holder2 -> {
                viewHolder.apply {
                    chat_You_Image.setImageResource(R.mipmap.ic_launcher)
                    chat_You_Name.text = arrayList[position].name
                    chat_Text.text = arrayList[position].script
                    chat_Time.text = arrayList[position].date_time
                }

            }
        }
    }


    override fun getItemCount(): Int {
        return arrayList.size
    }

    fun addItem(item: ChatModel) {
        arrayList.add(item)
    }
}