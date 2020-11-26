package com.example.funcalc.logic

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.google.android.material.snackbar.Snackbar

class BasicCalculatorViewModel: ViewModel() {

    var operand1 : String? = null
    var operand2 : String? = null
    var operator : Char? = null
    var isOprSet : Boolean = false
    var gotAResult : Boolean = false
    var isDecimal1Set: Boolean = false
    var isDecimal2Set: Boolean = false


    fun appendOperand1(myText: String, myView1: TextView, myView2: TextView){

        if(!gotAResult){ // we don't have a result yet

            if(!isOprSet){  // operand1 and operator not set yet

                if(myText == "0"){

                    if(!isDecimal1Set){

                        if(myView1.text.isEmpty()){
                            operand1 = myText.plus(".")
                            isDecimal1Set = true
                        } else if(myView1.text.first() != '0'){
                            operand1 = operand1.plus(myText)
                        }

                    }
                    else{
                        operand1 = operand1.plus(myText)
                    }


                }
                else{
                    operand1 = if(myView1.text.isEmpty()){
                        myText
                    } else{
                        operand1.plus(myText)
                    }
                }

                myView1.text = operand1
            }
            else{   // already set operand1 and operator

                if(myText == "0"){

                    if(!isDecimal2Set){

                        if(myView2.text.isEmpty()){
                            operand2 = myText.plus(".")
                            isDecimal2Set = true
                        } else if(myView2.text.first() != '0'){
                            operand2 = operand2.plus(myText)
                        }

                    }
                    else{
                        operand2 = operand2.plus(myText)
                    }

                }
                else{
                    operand2 = if(myView2.text.isEmpty()){
                        myText
                    } else{
                        operand2.plus(myText)
                    }
                }


                myView2.text = operand2


            }

        }
        else{   // we got a previous result

            if(isOprSet){

                if(myText == "0"){

                    if(!isDecimal2Set){

                        if(myView2.text.isEmpty()){
                            operand2 = myText.plus(".")
                            isDecimal2Set = true
                        } else if(myView2.text.first() != '0'){
                            operand2 = operand2.plus(myText)
                        }

                    }
                    else{
                        operand2 = operand2.plus(myText)
                    }

                }
                else{
                    operand2 = if(myView2.text.isEmpty()){
                        myText
                    } else{
                        operand2.plus(myText)
                    }
                }



                myView2.text = operand2

            }

        }





    }

    fun setOperator(opr: Char, myView : TextView){

        if(!isOprSet && operand1 != null){
            operator = opr
            isOprSet = true
            myView.text = opr.toString()
        }

    }

    fun computeResult(myView: View, myView1 : TextView, myView2 : TextView, myViewOpr : TextView){

        if(operand2 != null){
            val operand1Float : Float? = operand1?.toFloat()
            val operand2Float : Float? = operand2?.toFloat()
            var result : Float? = null

            if(operand2Float == 0F && operator == '/'){
                Snackbar.make(myView, "Error: Cannot divide by zero!", Snackbar.LENGTH_LONG).show()
            }
            else{
                when(operator){
                    '+' -> result = operand1Float!! + operand2Float!!
                    '-' -> result = operand1Float!! - operand2Float!!
                    '*' -> result = operand1Float!! * operand2Float!!
                    '/' -> result = operand1Float!! / operand2Float!!
                }

                operand1 = result.toString()
                operand2 = null
                operator = null
                myView1.text = operand1
                myView2.text = null
                myViewOpr.text = null
                isOprSet = false
                isDecimal1Set = false
                isDecimal2Set = false
                gotAResult = true
            }



        }




    }

    fun appendDecimal(myView1 : TextView, myView2 : TextView){

        if(!isDecimal1Set && !gotAResult && !isOprSet && myView1.text.isNotEmpty() && !myView1.text.contains('.')){

            operand1 = operand1.plus(".")
            myView1.text = operand1
            isDecimal1Set = true

        }
        else if(!isDecimal2Set && isOprSet && myView2.text.isNotEmpty()){

            operand2 = operand2.plus(".")
            myView2.text = operand2
            isDecimal2Set = true

        }

    }

    fun clearAll(myView1 : TextView, myView2 : TextView, myViewOpr : TextView){

        operand1 = null
        operand2 = null
        operator = null
        isOprSet = false
        gotAResult = false
        isDecimal1Set = false
        isDecimal2Set = false

        myView1.text = null
        myView2.text = null
        myViewOpr.text = null

    }




}