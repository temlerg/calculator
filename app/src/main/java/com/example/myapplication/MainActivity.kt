package com.example.myapplication


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        but_0.setOnClickListener { setTextFieldes("0") }
        but_1.setOnClickListener { setTextFieldes("1") }
        but_2.setOnClickListener { setTextFieldes("2") }
        but_3.setOnClickListener { setTextFieldes("3") }
        but_4.setOnClickListener { setTextFieldes("4") }
        but_5.setOnClickListener { setTextFieldes("5") }
        but_6.setOnClickListener { setTextFieldes("6") }
        but_7.setOnClickListener { setTextFieldes("7") }
        but_8.setOnClickListener { setTextFieldes("8") }
        but_9.setOnClickListener { setTextFieldes("9") }

        sum.setOnClickListener { setTextFieldes("+") }
        vich.setOnClickListener { setTextFieldes("-") }
        ym.setOnClickListener { setTextFieldes("*") }
        div.setOnClickListener { setTextFieldes("/") }
        open_s.setOnClickListener { setTextFieldes("(") }
        close_s.setOnClickListener { setTextFieldes(")") }
        dot.setOnClickListener{setTextFieldes(".")}
        AS.setOnClickListener {
            math_oper.text = ""
            ans.text = ""
        }
        back.setOnClickListener {
            val str = math_oper.text.toString()
            if (str.isNotEmpty())
                math_oper.text = str.substring(0, str.length - 1)
            ans.text = ""

        }

        rav.setOnClickListener {
            try {
                val ex = ExpressionBuilder(math_oper.text.toString()).build()
                val res = ex.evaluate()

                val longRes = res.toLong()
                if (res == longRes.toDouble())
                    ans.text = longRes.toString()
                else
                    ans.text = res.toString()

            } catch (e: Exception) {
                Log.d("Ошибка", "сообщение: ${e.message}")
            }
        }

    }


    fun setTextFieldes(str: String) {
        if(ans.text != ""){
            math_oper.text = ans.text
            ans.text = ""
        }
        math_oper.append(str)
    }

}
