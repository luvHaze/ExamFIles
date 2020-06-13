package luv.zoey.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // [001]
        /*
        GlobalScope.launch {
            delay(3000L)
            Log.d(TAG, "Coroutine says hello from thread ${Thread.currentThread().name}")
        }

        Log.d(TAG, "hello from thread ${Thread.currentThread().name}")
        */

        // [002]
        //  suspend fun 은 코루틴 안에서만 동작할 수 있다.
        /*
        GlobalScope.launch{
            val networkAnswer = doNetworkCall()
            val networkAnswer2 = doNetworkCall2()
            Log.d(TAG, networkAnswer)
            Log.d(TAG, networkAnswer2)
        }
        */

        //[003]
        // 쓰레드 동작 중에 메인쓰레드에서 할 일이 생기면
        // withContext(Dispatchers.Main) -> 메인 쓰레드를 불러야 한다.
        /*
        GlobalScope.launch (Dispatchers.IO){
            Log.d(TAG,"Starting Coroutine in thread ${Thread.currentThread().name}")
            val answer = doNetworkCall()
            withContext(Dispatchers.Main){
                Log.d(TAG, "Setting text in thread ${Thread.currentThread().name}")
                textview.text=answer
            }
        }
        */

        //[004]
        // runBlocking은 새로운 코루틴을 실행하고 완료될때까지
        // 현재 쓰레드를 차단한다.
        /*
        Log.d(TAG, "Before runBlocking")
        runBlocking {
            launch {
                delay(3000L)
                Log.d(TAG, "Finished IO Coroutine 1")
            }
            launch {
                delay(3000L)
                Log.d(TAG, "Finished IO Coroutine 2")
            }

            Log.d(TAG, "Start of RunBlocking")
            delay(5000L)
            Log.d(TAG,"End of Runblocking")
        }
        Log.d(TAG, "After runBlocking")
        */


        //[005]
        // .cancel() 메소드를 사용했을때 캔슬이 되지만  Job2 코루틴은
        // 계속되서 실행되는것을 확인 -> withTimeout으로 매개변수만큼의 시간이지나면
        // 자동으로 캔슬되게끔 했다.
        /*
        val job = GlobalScope.launch(Dispatchers.Default) {
            repeat(5) {
                Log.d(TAG, "Coroutine is still working...")
                delay(1000L)
            }
        }
        val job2 = GlobalScope.launch(Dispatchers.Default) {
            Log.d(TAG, "Starting long running calculation...")

            //3초뒤 자동으로 캔슬됨
            withTimeout(1000L){
                for (i in 30..40) {
                    if(isActive){
                        Log.d(TAG, "Result for i = $i : ${fib(i)}")
                    }
                }
            }

            Log.d(TAG, "Ending long running calculation")
        }

        runBlocking() {
            delay(2000L)
            job2.cancel()
            Log.d(TAG, "Canceled Job ! ")
        }
        */

    }

    suspend fun doNetworkCall(): String {
        delay(3000L)
        return "this is the answer"
    }

    suspend fun doNetworkCall2(): String {
        delay(3000L)
        return "this is the answer"
    }

    fun fib(n: Int): Long {
        return if (n == 0) 0
        else if (n == 1) 1
        else fib(n - 1) + fib(n - 2)
    }


}
