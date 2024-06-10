package weatherapp.og

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var weathLogo: ImageView
    private lateinit var splashButton : Button
    private lateinit var appNam: TextView
    private lateinit var stNum: TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        splashButton = findViewById(R.id.splashButton)
        weathLogo = findViewById(R.id.weathLogo)
        appNam = findViewById(R.id.appNam)
        stNum = findViewById(R.id.stNum)

        splashButton.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

    }
}