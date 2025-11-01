package inspektorat.aguskurniawan.threadrunnable

import android.annotation.SuppressLint
import android.os.AsyncTask
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
            Worker().execute()
        }
    }

    @SuppressLint("StaticFieldLeak")
    inner class Worker : AsyncTask<Void, String, Boolean>() {
        override fun doInBackground(vararg p0: Void?): Boolean {
            for (i in 1..20) {
                publishProgress(i.toString())
                Thread.sleep(2000)
            }
            return true
        }

        override fun onProgressUpdate(vararg values: String?) {
            binding.textView.text = values[0]
        }

        override fun onPostExecute(result: Boolean?) {
            println(result)
        }
    }
}