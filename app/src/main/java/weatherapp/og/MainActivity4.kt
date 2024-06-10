package weatherapp.og

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity4 : AppCompatActivity() {

    private lateinit var detailedInfo: TextView
    private lateinit var backButton: Button
    private lateinit var mainScreenButton: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        detailedInfo = findViewById(R.id.detailedInfo)
        backButton = findViewById(R.id.backButton)
        mainScreenButton = findViewById(R.id.mainScreenButton)

        val dayArray = intent.getStringArrayExtra("dayArray")
        val minimumArray = intent.getFloatArrayExtra("minimumArray")
        val maximumArray = intent.getFloatArrayExtra("maximumArray")
        val weatherConditionArray = intent.getStringArrayExtra("weatherConditionArray")

        if (dayArray != null && minimumArray != null && maximumArray != null && weatherConditionArray != null) {
            val stringBuilder = StringBuilder()
            for (i in dayArray.indices) {
                stringBuilder.append("Day: ${dayArray[i]}\n")
                stringBuilder.append("Min Temperature: ${minimumArray[i]}\n")
                stringBuilder.append("Max Temperature: ${maximumArray[i]}\n")
                stringBuilder.append("Weather Condition: ${weatherConditionArray[i]}\n\n")
            }
            detailedInfo.text = stringBuilder.toString()

            // Calculate the average temperature for the week
            val averageTemp = (minimumArray.sum() + maximumArray.sum()) / (2 * dayArray.size)
            detailedInfo.append("Average Temperature for the week: $averageTemp")
        } else {
            detailedInfo.text = "No detailed information available"
        }

        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        mainScreenButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
