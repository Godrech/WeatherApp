package weatherapp.og

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {

    private lateinit var dayOutput: TextView
    private lateinit var minOutput: TextView
    private lateinit var maxOutput: TextView
    private lateinit var weathConOutput: TextView
    private lateinit var detailsButton: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        dayOutput = findViewById(R.id.dayOutput)
        minOutput = findViewById(R.id.minOutput)
        maxOutput = findViewById(R.id.maxOutput)
        weathConOutput = findViewById(R.id.weathConOutput)
        detailsButton = findViewById(R.id.detailsButton)

        val dayArray = intent.getStringArrayExtra("dayArray")
        val minimumArray = intent.getFloatArrayExtra("minimumArray")
        val maximumArray = intent.getFloatArrayExtra("maximumArray")
        val weatherConditionArray = intent.getStringArrayExtra("weatherConditionArray")

        if (dayArray != null && minimumArray != null && maximumArray != null && weatherConditionArray != null) {
            val dayString = dayArray.joinToString("\n")
            val minString = minimumArray.joinToString("\n")
            val maxString = maximumArray.joinToString("\n")
            val weathConString = weatherConditionArray.joinToString("\n")

            dayOutput.text = "Days:\n$dayString"
            minOutput.text = "Min Temperatures:\n$minString"
            maxOutput.text = "Max Temperatures:\n$maxString"
            weathConOutput.text = "Weather Conditions:\n$weathConString"
        } else {
            dayOutput.text = "No data received"
            minOutput.text = ""
            maxOutput.text = ""
            weathConOutput.text = ""
        }

        detailsButton.setOnClickListener {
            val intent = Intent(this, MainActivity4::class.java)
            intent.putExtra("dayArray", dayArray)
            intent.putExtra("minimumArray", minimumArray)
            intent.putExtra("maximumArray", maximumArray)
            intent.putExtra("weatherConditionArray", weatherConditionArray)
            startActivity(intent)
        }
    }
}
