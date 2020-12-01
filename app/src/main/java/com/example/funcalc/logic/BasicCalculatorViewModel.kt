package com.example.funcalc.logic

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.google.android.material.snackbar.Snackbar

class BasicCalculatorViewModel: ViewModel() {

    val TOO_MANY_NUMBERS_STRING = "Sorry, too many numbers..."

    var operand1 : String? = null
    var operand2 : String? = null
    var operator : Char? = null
    var isOprSet : Boolean = false
    var gotAResult : Boolean = false
    var isDecimal1Set: Boolean = false
    var isDecimal2Set: Boolean = false


    fun appendOperand(myView: View, myText: String, myOp1View: TextView, myOp2View: TextView){


        val opToWrite = whichOpToModify()

        if(opToWrite == "OP1"){

            howToWriteOp1(myText, myOp1View)
            writeOperand(myView, myOp1View, "OP1")

        }
        else if (opToWrite == "OP2"){

            howToWriteOp2(myText, myOp2View)
            writeOperand(myView, myOp2View, "OP2")


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
                Snackbar.make(myView, "Error: Cannot divide by zero!", Snackbar.LENGTH_SHORT).show()
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

    fun setViewElements(myView1: TextView, myView2: TextView, myViewOpr: TextView){

        if(operand1 != null)
            myView1.text = operand1
        if(operand2 != null)
            myView2.text = operand2
        if(operator != null)
            myViewOpr.text = operator.toString()

    }


    fun whichOpToModify(): String?{

        return if(!gotAResult && operator == null ){
            "OP1"
        }
        else if( operator != null ){
            "OP2"
        }
        else null


    }

    fun howToWriteOp1(myText: String, myOp1View: TextView){

        if(myText == "0"){

            if(!isDecimal1Set){

                if(myOp1View.text.isEmpty()){
                    operand1 = myText.plus(".")
                    isDecimal1Set = true
                } else if(myOp1View.text.first() != '0'){
                    operand1 = operand1.plus(myText)
                }

            }
            else{
                operand1 = operand1.plus(myText)
            }


        }
        else{
            operand1 = if(myOp1View.text.isEmpty()){
                myText
            } else{
                operand1.plus(myText)
            }
        }


    }


    fun howToWriteOp2(myText: String, myOp2View: TextView){

        if(myText == "0"){

            if(!isDecimal2Set){

                if(myOp2View.text.isEmpty()){
                    operand2 = myText.plus(".")
                    isDecimal2Set = true
                } else if(myOp2View.text.first() != '0'){
                    operand2 = operand2.plus(myText)
                }

            }
            else{
                operand2 = operand2.plus(myText)
            }

        }
        else{
            operand2 = if(myOp2View.text.isEmpty()){
                myText
            } else{
                operand2.plus(myText)
            }
        }


    }


    fun writeOperand(myView: View, viewToWrite: TextView, myOperand: String){

        if(myOperand == "OP1"){
            if(operand1?.length!! > 8){
                operand1 = operand1!!.subSequence(0, operand1!!.length-1).toString()
                Snackbar.make(myView, TOO_MANY_NUMBERS_STRING, Snackbar.LENGTH_SHORT).show()
            }
            viewToWrite.text = operand1
        }
        else if(myOperand == "OP2"){
                if(operand2?.length!! > 8){
                    operand2 = operand2!!.subSequence(0, operand2!!.length-1).toString()
                    Snackbar.make(myView, TOO_MANY_NUMBERS_STRING, Snackbar.LENGTH_SHORT).show()
                }
                viewToWrite.text = operand2
        }



    }




}