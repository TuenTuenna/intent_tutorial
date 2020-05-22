package com.jeongdaeri.intenttutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.jeongdaeri.intenttutorial.Constants.FAIL
import com.jeongdaeri.intenttutorial.Constants.OKAY
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    val TAG: String = "로그"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        Log.d(TAG, "SecondActivity - onCreate() called")


        if(intent.extras != null){
            val receivedData = intent.extras?.get("data") as String
            Log.d(TAG, "SecondActivity - receivedData : $receivedData ")

        }


        done_btn.setOnClickListener {
            Log.d(TAG, "SecondActivity - 작업완료 버튼이 클릭 되었다.")


            // 완료가 되면 즉 오케이면
            setResult(OKAY)
//
//            // 실패가 되면
//            setResult(FAIL)


            finish()
        }

    }






}
