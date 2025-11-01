package inspektorat.aguskurniawan.threadrunnable

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Message
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import inspektorat.aguskurniawan.threadrunnable.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mHandler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mHandler = MyHandler()

        binding.button.setOnClickListener {
            Thread {
                killSomeTime()
            }.start()
        }
    }

    @SuppressLint("HandlerLeak")
    inner class MyHandler : Handler() {
        override fun handleMessage(msg: Message) {
            binding.textView.text = msg.data?.getString("counter")
        }
    }

    private fun killSomeTime() {
        for (i in 1..20) {
            val msg = Message.obtain()
            msg.data.putString("counter", i.toString())
            mHandler.sendMessage(msg)
            Thread.sleep(2000)
            println("i: $i")
        }
    }
}