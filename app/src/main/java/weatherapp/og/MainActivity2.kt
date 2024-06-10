package weatherapp.og

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    // Declarations
    private lateinit var dayTxt: EditText
    private lateinit var minTxt: EditText
    private lateinit var maxTxt: EditText
    private lateinit var weathConTxt: EditText
    private lateinit var saveButton: Button
    private lateinit var clearButton: Button
    private lateinit var nextButton: Button
    private lateinit var errorMsg: TextView
    private val dayArray = mutableListOf<String>()
    private val minimumArray = mutableListOf<Float>()
    private val maximumArray = mutableListOf<Float>()
    private val weatherConditionArray = mutableListOf<String>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        // Initialising
        dayTxt = findViewById(R.id.dayTxt)
        minTxt = findViewById(R.id.minTxt)
        maxTxt = findViewById(R.id.maxTxt)
        weathConTxt = findViewById(R.id.weathConTxt)
        saveButton = findViewById(R.id.saveButton)
        clearButton = findViewById(R.id.clearButton)
        nextButton = findViewById(R.id.nextButton)
        errorMsg = findViewById(R.id.errorMsg)

        // Process for a button to clear input data
        clearButton.setOnClickListener {
            dayTxt.setText("")
            minTxt.setText("")
            maxTxt.setText("")
            weathConTxt.setText("")
        }

        // Process for saving inputted data when pressing the save button
        saveButton.setOnClickListener {
            val day = dayTxt.text.toString()
            val minimum = minTxt.text.toString()
            val maximum = maxTxt.text.toString()
            val weatherCondition = weathConTxt.text.toString()

            if (day.isNotEmpty() && minimum.isNotEmpty() && maximum.isNotEmpty() && weatherCondition.isNotEmpty()) {
                try {
                    dayArray.add(day)
                    minimumArray.add(minimum.toFloat())
                    maximumArray.add(maximum.toFloat())
                    weatherConditionArray.add(weatherCondition)
                    dayTxt.text.clear()
                    minTxt.text.clear()
                    maxTxt.text.clear()
                    weathConTxt.text.clear()
                } catch (e: NumberFormatException) {
                    errorMsg.text = "Please enter a valid data type"
                }
            } else {
                errorMsg.text = "Input cannot be empty"
            }
        }

        // Process to take the data across to the next screen for more details when pressing the more details next button
        nextButton.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            intent.putExtra("dayArray", dayArray.toTypedArray())
            intent.putExtra("minimumArray", minimumArray.toFloatArray())
            intent.putExtra("maximumArray", maximumArray.toFloatArray())
            intent.putExtra("weatherConditionArray", weatherConditionArray.toTypedArray())
            startActivity(intent)
        }
    }
}
