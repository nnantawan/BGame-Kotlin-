package com.example.baogameapp

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.baogameapp.utils.ConditionUtils
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var mCountSuccess = 0
    private var mCountFail = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        button0.setOnClickListener(this)
        buttonAsterisk.setOnClickListener(this)
        buttonSharp.setOnClickListener(this)
        buttonCall.setOnClickListener(this)
        buttonRestart.setOnClickListener(this)
        buttonDelete.setOnClickListener(this)
        buttonDelete.setOnLongClickListener {
            phoneTextView.text = ""
            false
        }
    }

    override fun onClick(view: View?) {

        val viewId = view?.id
        if (viewId == R.id.buttonCall){
            if (!TextUtils.isEmpty(phoneTextView.text)){

                val matchFound = (ConditionUtils()).checkCondition(phoneTextView.text.toString().trim())

                if (matchFound) {
                    mCountSuccess += 1
                    successTextView.text = mCountSuccess.toString()

                } else {
                    mCountFail += 1
                    failTextView.text = mCountFail.toString()
                }

                phoneTextView.text = ""
            }

        }else if (viewId == R.id.buttonRestart){
            phoneTextView.text = ""
            successTextView.text = "0"
            failTextView.text = "0"
            mCountSuccess = 0
            mCountFail = 0

        }else if (viewId == R.id.buttonDelete){
            if (!TextUtils.isEmpty(phoneTextView.text)){
                phoneTextView.text = phoneTextView.text.substring(0, phoneTextView.text.toString().length -1)
            }

        }else {
            val btClick:Button = view as Button
            phoneTextView.text = phoneTextView.text.toString() + btClick.text.toString()
        }
    }

}