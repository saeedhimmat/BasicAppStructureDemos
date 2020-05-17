package com.hs_worms.android.basicappstructuredemo

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

private const val EXTRA_TEXT = "com.hs_worms.android.basicappstructuredemo.text"
private const val EXTRA_RESULT = "com.hs_worms.android.basicappstructuredemo.result"

class SecondActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var goBackToMainActivityButton: Button

    companion object {
        fun newIntent(packageContext: Context, text: String): Intent {
            return Intent(packageContext, SecondActivity::class.java).apply {
                putExtra(EXTRA_TEXT, text)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val text = intent.getStringExtra(EXTRA_TEXT)

        textView = findViewById(R.id.textView)
        textView.text = text
        goBackToMainActivityButton = findViewById(R.id.go_back_button)

        goBackToMainActivityButton.setOnClickListener {
            val intent = Intent().apply {
                putExtra(EXTRA_RESULT, "Greetings back")
            }
            setResult(Activity.RESULT_OK, intent)
        }

    }
}
