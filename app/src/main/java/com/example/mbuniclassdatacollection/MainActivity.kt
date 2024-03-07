package com.example.mbuniclassdatacollection
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.DatePicker
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TimePicker
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }//

        //Code Here
        //Find Views By ID
        val surname = findViewById<EditText>(R.id.surname)
        val others = findViewById<EditText>(R.id.others)
        val kenyan = findViewById<RadioButton>(R.id.kenyan)
        val ugandan = findViewById<RadioButton>(R.id.ugandan)
        val pizza = findViewById<CheckBox>(R.id.pizza)
        val rice = findViewById<CheckBox>(R.id.rice)
        val date = findViewById<DatePicker>(R.id.date)
        val time = findViewById<TimePicker>(R.id.time)

        //Button
        val send = findViewById<Button>(R.id.send)
        //set Button Listener
        send.setOnClickListener{
              //After Finding Views, Now Get the Inputs as Entered By User and Store them in variables
              //Get the inputs of an Edit Texts
              val surnameText = surname.text.toString()
              val othersText = others.text.toString()

              //Check which Radio was Selected, Only One can be selected
              var radioText = "" // To be updated
              if(kenyan.isChecked) radioText = "Kenyan"
              if(ugandan.isChecked) radioText = "Ugandan"

               //Check which CheckBox was Selected, Both can be selected, hence we use +=
              var  checkboxText = "" //To be updated Later
              if (pizza.isChecked) checkboxText += "Pizza"
              if (rice.isChecked) checkboxText += "Rice"
              //Date
              // Retrieve selected date
              val dayOfMonth = date.dayOfMonth
              val monthOfYear = date.month
              val year = date.year

              // Retrieve selected time
              val hour = time.hour
              val minute = time.minute

            //We Toast Our Variables in 3 Different Toasts
            Toast.makeText(applicationContext, "Name is $surnameText  Other Names $othersText Nationality $radioText",
                Toast.LENGTH_SHORT).show()
            Toast.makeText(applicationContext, "Food $checkboxText \n Date $dayOfMonth $monthOfYear $year",
                Toast.LENGTH_SHORT).show()
            Toast.makeText(applicationContext, "Time $hour  :  $minute",
                Toast.LENGTH_SHORT).show()


        }

    }
}