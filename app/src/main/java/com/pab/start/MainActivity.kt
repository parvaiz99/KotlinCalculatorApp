package com.pab.start

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {

    lateinit var edtTxt :TextView
    lateinit var edtTxtr :TextView
    lateinit var eqq : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edtTxtr= findViewById(R.id.edTxt2)
        edtTxt= findViewById(R.id.edTxt)
        edtTxt.text="0"
    }
    var op ="^"
    var oldNo = ""
    var isNewOp = true



    fun buNoEvent(view: View) {

        if (isNewOp){
            edtTxt.text = ""
        }
        isNewOp = false

        val buSelect =view as Button
        var buClickValue:String = edtTxt.text.toString()

        when(buSelect.id){

            R.id.b1 ->{ buClickValue+="1"}
            R.id.b0 ->{ buClickValue+="0"}
            R.id.b2 ->{ buClickValue+="2"}
            R.id.b3 ->{ buClickValue+="3"}
            R.id.b4 ->{ buClickValue+="4"}
            R.id.b5 ->{ buClickValue+="5"}
            R.id.b6 ->{ buClickValue+="6"}
            R.id.b7 ->{ buClickValue+="7"}
            R.id.b8 ->{ buClickValue+="8"}
            R.id.b9 ->{ buClickValue+="9"}
            R.id.bdot ->{ if("." in edtTxt.text ){

                         }else{
                            buClickValue+="."}
                        }
            }
        edtTxt.text = buClickValue
    }


    fun buOp(view: View) {
        if(edtTxt.text =="0" || edtTxt.text.toString().last() == '*' ||edtTxt.text.toString().last() == '+' ||
            edtTxt.text.toString().last() == '-' ||edtTxt.text.toString().last() == '/' ||
            edtTxt.text.toString().last() == '%'){

        }else {
            eqq = findViewById(R.id.bequal)
            if (edtTxt.text.any { it == '*' || it == '/' || it == '%' || it == '+' || it == '-' }) {

                buequal(eqq)
                val buselect = view as Button

                when (buselect.id) {

                    R.id.multiply -> {
                        op = "*"

                        edtTxtr.text = edtTxt.text
                        edtTxt.text = op
                    }
                    R.id.add -> {
                        op = "+"
                        edtTxtr.text = edtTxt.text
                        edtTxt.text = op
                    }
                    R.id.subtract -> {
                        op = "-"
                        edtTxtr.text = edtTxt.text
                        edtTxt.text = op
                    }
                    R.id.division -> {
                        op = "/"
                        edtTxtr.text = edtTxt.text
                        edtTxt.text = op
                    }
                    R.id.modulus -> {
                        op = "%"
                        edtTxtr.text = edtTxt.text
                        edtTxt.text = op
                    }
                    R.id.pm -> {
                        var a = edtTxt.text.toString().toDouble()
                        a = a * (-1)
                        edtTxt.text = a.toString()

                    }

                }
                oldNo = edtTxtr.text.toString()

            } else {
                val buselect = view as Button

                when (buselect.id) {

                    R.id.multiply -> {
                        op = "*"

                        edtTxtr.text = edtTxt.text
                        edtTxt.text = op
                    }
                    R.id.add -> {
                        op = "+"
                        edtTxtr.text = edtTxt.text
                        edtTxt.text = op
                    }
                    R.id.subtract -> {
                        op = "-"
                        edtTxtr.text = edtTxt.text
                        edtTxt.text = op
                    }
                    R.id.division -> {
                        op = "/"
                        edtTxtr.text = edtTxt.text
                        edtTxt.text = op
                    }
                    R.id.modulus -> {
                        op = "%"
                        edtTxtr.text = edtTxt.text
                        edtTxt.text = op
                    }
                    R.id.pm -> {
                        var a = edtTxt.text.toString().toDouble()
                        a = a * (-1)
                        edtTxt.text = a.toString()

                    }

                }
                oldNo = edtTxtr.text.toString()
            }

        }

    }

    fun buequal(view: View) {

        if(op=="^"||edtTxt.text.toString().last()=='*'||edtTxt.text.toString().last()=='+'
            ||edtTxt.text.toString().last()=='-'||edtTxt.text.toString().last()=='/'
            ||edtTxt.text.toString().last()=='%' ||edtTxt.text.toString().last()=='.'){

        }else {
            var tNo = edtTxt.text.toString()
            var finNo: BigDecimal? = null
            when (op) {
                "*" -> {
                    var i = tNo.indexOf("*") + 1
                    var newNo = tNo.substring(startIndex = i)
                    finNo = (oldNo.toFloat() * newNo.toFloat()).toBigDecimal()
                }
                "/" -> {
                    var i = tNo.indexOf("/") + 1
                    var newNo = tNo.substring(startIndex = i)
                    finNo = (oldNo.toFloat() / newNo.toFloat()).toBigDecimal()
                }
                "+" -> {
                    var i = tNo.indexOf("+") + 1
                    var newNo = tNo.substring(startIndex = i)
                    finNo = (oldNo.toFloat() + newNo.toFloat()).toBigDecimal()
                }
                "-" -> {
                    var i = tNo.indexOf("-") + 1
                    var newNo = tNo.substring(startIndex = i)
                    finNo = (oldNo.toFloat() - newNo.toFloat()).toBigDecimal()
                }
                "%" -> {
                    var i = tNo.indexOf("%") + 1
                    var newNo = tNo.substring(startIndex = i)
                    finNo = ((oldNo.toFloat() / 100) * newNo.toFloat()).toBigDecimal()
//                var a = (oldNo.toDouble()/newNo.toDouble()).toString()
//                var ss = a.indexOf(".")
//                val b=  a.substring(startIndex = ss)
//                finNo = b.toDouble()*oldNo.toDouble()
                }

            }
            edtTxt.text = finNo.toString()
            edtTxtr.text=""
            op="^"
        }
    }

    fun cllear(view: View) {

        edtTxt.text = "0"
        edtTxtr.text=""
        isNewOp=true
    }
}