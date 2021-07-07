package com.danisable.appdatapersistence

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.danisable.appdatapersistence.utils.Utils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //PUBLICA 1 PRIVADA 0 COMPRATIDA  2
        //Private: 0
        //Public: 1
        //Share:2



        swPer.setOnCheckedChangeListener{ buttonView, isChecked ->
            if(isChecked){
                Utils.setPreferencesAppData(this, Utils.PREF_DARK_MODE,true)
                /*val sharedPreferences: SharedPreferences = getSharedPreferences("PREF_USER", 0)
                val editor = sharedPreferences.edit()
                editor.putBoolean("isDark",true)
                editor.apply()*/
                changeBackgroundColor(Color.BLACK)
            }else{
                Utils.setPreferencesAppData(this, Utils.PREF_DARK_MODE,false)

                /*val sharedPreferences: SharedPreferences = getSharedPreferences("PREF_USER", 0)
                val editor = sharedPreferences.edit()
                editor.putBoolean("isDark",false)
                editor.apply()*/
                changeBackgroundColor(Color.WHITE)
            }
            val result: String? = Utils.getPreferencesAppData(this, Utils.PREF_DARK_MODE)
            Log.e("TAG",result.toString())
            tvText.text = "PREF_DARK_MODE: $result"
        }
    }

    override fun onStart() {
        super.onStart()
        val result: String? = Utils.getPreferencesAppData(this, Utils.PREF_DARK_MODE)
        Log.e("TAG",result.toString())
        if (result=="true") {
            changeBackgroundColor(Color.BLACK)
        }else{
            changeBackgroundColor(Color.WHITE)
        }
    }

    private fun changeBackgroundColor(color: Int){
        viewLayout.setBackgroundColor(color)
        if(color==Color.BLACK) {
            tvText.setTextColor(Color.WHITE)
        }else{
            tvText.setTextColor(Color.BLACK)
        }
    }

    /*private fun getSharedPreferences(): Boolean {

        val sharePreferences: SharedPreferences = getSharedPreferences("PREF_USER",0)
        return sharePreferences.getBoolean("isDark",false)

    }*/
}