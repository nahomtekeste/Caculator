package com.example.style_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Numbers

        tvOne.setOnClickListener{appendOnExpression("1",true)}
        tvTwo.setOnClickListener{appendOnExpression("2",true)}
        tvthree.setOnClickListener{appendOnExpression("3",true)}
        tvFour.setOnClickListener{appendOnExpression("4",true)}
        tvFive.setOnClickListener{appendOnExpression("5",true)}
        tvSix.setOnClickListener{appendOnExpression("6",true)}
        tvSeven.setOnClickListener{appendOnExpression("7",true)}
        tvEaight.setOnClickListener{appendOnExpression("8",true)}
        tvZero.setOnClickListener{appendOnExpression("0",true)}
        tvNin.setOnClickListener{appendOnExpression("9",true)}
        tvDot.setOnClickListener{appendOnExpression(".",true)}

        // Opertors

        tvPlus.setOnClickListener{appendOnExpression("+" , false)}
        tvDiv.setOnClickListener{appendOnExpression("/" , false)}
        tvMinus.setOnClickListener{appendOnExpression("-" , false)}
        tvMultip.setOnClickListener{appendOnExpression("*" , false)}
        tvOpenBrace.setOnClickListener{appendOnExpression("(" , false)}
        tvCloseBraces.setOnClickListener{appendOnExpression(")" , false)}

        tvClear.setOnClickListener{
            tvexpression.text= " "
            tvResult.text= " "
        }
        tvBack.setOnClickListener{
            val string = tvexpression.text.toString()
            if (string.isNotEmpty()){
                tvexpression.text = string.substring(0,string.length-1)
            }
            tvResult.text= " "
        }
        tvEqual.setOnClickListener{
            try{
                val expression = ExpressionBuilder(tvexpression.text.toString()). builder()
                val result = expression.evalute()
                val longResult = result.toLong()
                if(result == longResult.toDouble()){
                    tvResult.text = longResult.toString()
                }else{
                    tvResult.text = result.toString()
                }

            }catch(e:Exception){

            }

        }

    }
    fun appendOnExpression(string :String , canClear :Boolean){
        if(tvResult.text.isNotEmpty()){
            tvexpression.text = " "
        }
        if(canClear){
            tvResult.text =" "
            tvexpression.append(string)
        }else{
            tvexpression.append(tvResult.text)
            tvResult.append(string)
            tvResult.text= ""
        }
    }
}
