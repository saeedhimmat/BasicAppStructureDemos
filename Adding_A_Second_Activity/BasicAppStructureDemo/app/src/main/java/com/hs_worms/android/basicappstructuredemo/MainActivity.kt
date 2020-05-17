package com.hs_worms.android.basicappstructuredemo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

private const val REQUEST_CODE = 0
private const val EXTRA_RESULT = "com.hs_worms.android.basicappstructuredemo.result"

class MainActivity : AppCompatActivity() {

    private lateinit var goToSecondActivityButton: Button
    private lateinit var goToSecondActivityButtonForResult: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        goToSecondActivityButton = findViewById(R.id.go_to_second_activity_button)
        goToSecondActivityButtonForResult = findViewById(R.id.go_to_second_activity_button_for_result)

        goToSecondActivityButton.setOnClickListener {
            val intent = SecondActivity.newIntent(this, "Greetings from Main Activity!")
            startActivity(intent)
        }

        goToSecondActivityButtonForResult.setOnClickListener {
            val intent = SecondActivity.newIntent(this, "Greetings from Main Activity!")
            startActivityForResult(intent, REQUEST_CODE)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode != Activity.RESULT_OK) {
            return
        }

        val result = data?.getStringExtra(EXTRA_RESULT)

        val toast = Toast.makeText(applicationContext, result, Toast.LENGTH_LONG)
        toast.show()
    }

}
