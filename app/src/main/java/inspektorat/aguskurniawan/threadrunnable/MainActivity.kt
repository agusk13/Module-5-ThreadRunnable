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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val runnable = Worker()
            val thread = Thread(runnable)
            thread.start()
        }
    }

    inner class Worker : Runnable {
        override fun run() {
            killSomeTime()
        }
    }

    private fun killSomeTime() {
        for (i in 1..20) {
            Thread.sleep(2000)
            println("i: $i")
        }
    }
}