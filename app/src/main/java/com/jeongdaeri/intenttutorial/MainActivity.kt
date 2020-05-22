package com.jeongdaeri.intenttutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.jeongdaeri.intenttutorial.Constants.FORTH_ACTIVITY
import com.jeongdaeri.intenttutorial.Constants.OKAY
import com.jeongdaeri.intenttutorial.Constants.SECOND_ACTIVITY
import com.jeongdaeri.intenttutorial.Constants.THIRD_ACTIVITY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val TAG: String = "로그"

    // 화면이 메모리에 올라간다.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "MainActivity - onCreate() called")

        next_btn.setOnClickListener {
            Log.d(TAG, "MainActivity - 다음버튼이 클릭 되었다.")

            val intent = Intent(this, SecondActivity::class.java)

            intent.putExtra("data", "하하하")

            startActivity(intent)

        }


        next_with_result_btn.setOnClickListener {
            Log.d(TAG, "MainActivity - onCreate() called")

            val intent = Intent(this, SecondActivity::class.java)

//            intent.putExtra("data", "하하하")

            // 부메랑 같이 던진다
            startActivityForResult(intent, SECOND_ACTIVITY)
        }

        third_with_result_btn.setOnClickListener {
            Log.d(TAG, "MainActivity - 세번쨰 버튼 클릭 ")
            val intent = Intent(this, ThirdActivity::class.java)

            // 부메랑 같이 던진다
            startActivityForResult(intent, THIRD_ACTIVITY)
        }

        forth_with_result_btn.setOnClickListener {
            Log.d(TAG, "MainActivity - 네번쨰 버튼 클릭 ")
            val intent = Intent(this, ForthActivity::class.java)

            // 부메랑 같이 던진다
            startActivityForResult(intent, FORTH_ACTIVITY)
        }


    }


    // 부메랑을 받는 곳
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d(TAG, "MainActivity - onActivityResult() called / requestCode: $requestCode")

        when(requestCode) {
            // 종료된 액티비티가 쎄컨드액티비티라면
            SECOND_ACTIVITY -> {

                Log.d(TAG, "MainActivity - 쎄컨드 액티비티가 종료 되었다. resultCode : $resultCode")


                if(resultCode == OKAY){
                    // 뭔가 를 한다.
                    Log.d(TAG, "MainActivity - 성공적이다!")
                }


            }

            THIRD_ACTIVITY -> {

                Log.d(TAG, "MainActivity - 세번째 액티비티가 종료 되었다. resultCode : $resultCode")

            }

            FORTH_ACTIVITY -> {

                Log.d(TAG, "MainActivity - 네번째 액티비티가 종료 되었다. resultCode : $resultCode")

            }
        }


    }








}
