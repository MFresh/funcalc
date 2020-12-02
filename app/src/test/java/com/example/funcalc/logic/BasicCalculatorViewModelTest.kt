package com.example.funcalc.logic

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.test.core.app.ApplicationProvider
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class BasicCalculatorViewModelTest {

    private val myBasicCalcVM_test = BasicCalculatorViewModel()

    @Before
    fun setUp() {
        myBasicCalcVM_test.operand1 = null
        myBasicCalcVM_test.operand2 = null
        myBasicCalcVM_test.operator = null
        myBasicCalcVM_test.gotAResult = false
        myBasicCalcVM_test.isOprSet = false
        myBasicCalcVM_test.isDecimal1Set= false
        myBasicCalcVM_test.isDecimal2Set= false

        myBasicCalcVM_test.operand1Float = null
        myBasicCalcVM_test.operand2Float= null
        myBasicCalcVM_test.result= null
    }

    @Test
    fun test_setOperator_op1IsNotNull_oprNotSet() {

        val context_test = ApplicationProvider.getApplicationContext<Context>()
        val myViewOpr_test = TextView(context_test)
        myBasicCalcVM_test.operand1 = "21"

        myBasicCalcVM_test.setOperator('*', myViewOpr_test)

        assertEquals(myBasicCalcVM_test.operator, '*')
        assertEquals(myViewOpr_test.text, "*")

    }

    @Test
    fun test_setOperator_op1IsNotNull_oprSet() {

        val context_test = ApplicationProvider.getApplicationContext<Context>()
        val myViewOpr_test = TextView(context_test)
        myBasicCalcVM_test.operand1 = "21"
        myBasicCalcVM_test.operator = '-'
        myBasicCalcVM_test.isOprSet = true

        myBasicCalcVM_test.setOperator('*', myViewOpr_test)

        assertEquals(myBasicCalcVM_test.operator, '-')
        assertEquals(myViewOpr_test.text, "")

    }

    @Test
    fun test_setOperator_op1IsNull_oprNotSet() {

        val context_test = ApplicationProvider.getApplicationContext<Context>()
        val myViewOpr_test = TextView(context_test)

        myBasicCalcVM_test.setOperator('*', myViewOpr_test)

        assertEquals(myBasicCalcVM_test.operator, null)
        assertEquals(myViewOpr_test.text, "")

    }

    @Test
    fun test_setOperator_op1IsNull_oprSet() {

        val context_test = ApplicationProvider.getApplicationContext<Context>()
        val myViewOpr_test = TextView(context_test)
        myBasicCalcVM_test.operator = '-'
        myBasicCalcVM_test.isOprSet = true

        myBasicCalcVM_test.setOperator('*', myViewOpr_test)

        assertEquals(myBasicCalcVM_test.operator, '-')
        assertEquals(myViewOpr_test.text, "")

    }

    @Test
    fun test_compareResult_op2IsNull() {

        val context_test = ApplicationProvider.getApplicationContext<Context>()
        val myViewOp1_test = TextView(context_test)
        val myViewOp2_test = TextView(context_test)
        val myViewOpr_test = TextView(context_test)
        val myView_test = View(context_test)

        myBasicCalcVM_test.operand1 = "21.3"
        myBasicCalcVM_test.operator = '-'
        myBasicCalcVM_test.gotAResult = true
        myBasicCalcVM_test.isOprSet = true
        myBasicCalcVM_test.isDecimal1Set= true

        myViewOp1_test.text = "21.3"
        myViewOpr_test.text = "-"

        myBasicCalcVM_test.computeResult(myView_test, myViewOp1_test, myViewOp2_test, myViewOpr_test)

        assertEquals(myBasicCalcVM_test.operand1, "21.3")
        assertEquals(myBasicCalcVM_test.operand2, null)
        assertEquals(myBasicCalcVM_test.operator, '-')
        assertEquals(myBasicCalcVM_test.gotAResult, true)
        assertEquals(myBasicCalcVM_test.isOprSet, true)
        assertEquals(myBasicCalcVM_test.isDecimal1Set, true)
        assertEquals(myBasicCalcVM_test.isDecimal2Set, false)
        assertEquals(myBasicCalcVM_test.operand1Float, null)
        assertEquals(myBasicCalcVM_test.operand2Float, null)
        assertEquals(myBasicCalcVM_test.result, null)

        assertEquals(myViewOp1_test.text, "21.3")
        assertEquals(myViewOp2_test.text, "")
        assertEquals(myViewOpr_test.text, "-")

    }

    @Test
    fun test_compareResult_op2Correct_Division() {

        val context_test = ApplicationProvider.getApplicationContext<Context>()
        val myViewOp1_test = TextView(context_test)
        val myViewOp2_test = TextView(context_test)
        val myViewOpr_test = TextView(context_test)
        val myView_test = View(context_test)

        myBasicCalcVM_test.operand1 = "21.3"
        myBasicCalcVM_test.operand2 = "10"
        myBasicCalcVM_test.operator = '/'
        myBasicCalcVM_test.gotAResult = false
        myBasicCalcVM_test.isOprSet = true
        myBasicCalcVM_test.isDecimal1Set= true
        myBasicCalcVM_test.isDecimal2Set= true

        myViewOp1_test.text = "21.3"
        myViewOp2_test.text = "10"
        myViewOpr_test.text = "/"

        myBasicCalcVM_test.computeResult(myView_test, myViewOp1_test, myViewOp2_test, myViewOpr_test)

        assertEquals(myBasicCalcVM_test.operand1, "2.1299999")
        assertEquals(myBasicCalcVM_test.operand2, null)
        assertEquals(myBasicCalcVM_test.operator, null)
        assertEquals(myBasicCalcVM_test.gotAResult, true)
        assertEquals(myBasicCalcVM_test.isOprSet, false)
        assertEquals(myBasicCalcVM_test.isDecimal1Set, false)
        assertEquals(myBasicCalcVM_test.isDecimal2Set, false)
        assertEquals(myBasicCalcVM_test.operand1Float, 21.3F)
        assertEquals(myBasicCalcVM_test.operand2Float, 10F)
        assertEquals(myBasicCalcVM_test.result, 2.1299999F)

        assertEquals(myViewOp1_test.text, "2.1299999")
        assertEquals(myViewOp2_test.text, "")
        assertEquals(myViewOpr_test.text, "")

    }

    @Test
    fun test_compareResult_op2Correct_Multiplication() {

        val context_test = ApplicationProvider.getApplicationContext<Context>()
        val myViewOp1_test = TextView(context_test)
        val myViewOp2_test = TextView(context_test)
        val myViewOpr_test = TextView(context_test)
        val myView_test = View(context_test)

        myBasicCalcVM_test.operand1 = "21.3"
        myBasicCalcVM_test.operand2 = "10"
        myBasicCalcVM_test.operator = '*'
        myBasicCalcVM_test.gotAResult = false
        myBasicCalcVM_test.isOprSet = true
        myBasicCalcVM_test.isDecimal1Set= true
        myBasicCalcVM_test.isDecimal2Set= true

        myViewOp1_test.text = "21.3"
        myViewOp2_test.text = "10"
        myViewOpr_test.text = "*"

        myBasicCalcVM_test.computeResult(myView_test, myViewOp1_test, myViewOp2_test, myViewOpr_test)

        assertEquals(myBasicCalcVM_test.operand1, "213.0")
        assertEquals(myBasicCalcVM_test.operand2, null)
        assertEquals(myBasicCalcVM_test.operator, null)
        assertEquals(myBasicCalcVM_test.gotAResult, true)
        assertEquals(myBasicCalcVM_test.isOprSet, false)
        assertEquals(myBasicCalcVM_test.isDecimal1Set, false)
        assertEquals(myBasicCalcVM_test.isDecimal2Set, false)
        assertEquals(myBasicCalcVM_test.operand1Float, 21.3F)
        assertEquals(myBasicCalcVM_test.operand2Float, 10F)
        assertEquals(myBasicCalcVM_test.result, 213F)

        assertEquals(myViewOp1_test.text, "213.0")
        assertEquals(myViewOp2_test.text, "")
        assertEquals(myViewOpr_test.text, "")

    }

    @Test
    fun test_compareResult_op2Correct_Sum() {

        val context_test = ApplicationProvider.getApplicationContext<Context>()
        val myViewOp1_test = TextView(context_test)
        val myViewOp2_test = TextView(context_test)
        val myViewOpr_test = TextView(context_test)
        val myView_test = View(context_test)

        myBasicCalcVM_test.operand1 = "21.3"
        myBasicCalcVM_test.operand2 = "10"
        myBasicCalcVM_test.operator = '+'
        myBasicCalcVM_test.gotAResult = false
        myBasicCalcVM_test.isOprSet = true
        myBasicCalcVM_test.isDecimal1Set= true
        myBasicCalcVM_test.isDecimal2Set= true

        myViewOp1_test.text = "21.3"
        myViewOp2_test.text = "10"
        myViewOpr_test.text = "+"

        myBasicCalcVM_test.computeResult(myView_test, myViewOp1_test, myViewOp2_test, myViewOpr_test)

        assertEquals(myBasicCalcVM_test.operand1, "31.3")
        assertEquals(myBasicCalcVM_test.operand2, null)
        assertEquals(myBasicCalcVM_test.operator, null)
        assertEquals(myBasicCalcVM_test.gotAResult, true)
        assertEquals(myBasicCalcVM_test.isOprSet, false)
        assertEquals(myBasicCalcVM_test.isDecimal1Set, false)
        assertEquals(myBasicCalcVM_test.isDecimal2Set, false)
        assertEquals(myBasicCalcVM_test.operand1Float, 21.3F)
        assertEquals(myBasicCalcVM_test.operand2Float, 10F)
        assertEquals(myBasicCalcVM_test.result, 31.3F)

        assertEquals(myViewOp1_test.text, "31.3")
        assertEquals(myViewOp2_test.text, "")
        assertEquals(myViewOpr_test.text, "")

    }

    @Test
    fun test_compareResult_op2Correct_Subtraction() {

        val context_test = ApplicationProvider.getApplicationContext<Context>()
        val myViewOp1_test = TextView(context_test)
        val myViewOp2_test = TextView(context_test)
        val myViewOpr_test = TextView(context_test)
        val myView_test = View(context_test)

        myBasicCalcVM_test.operand1 = "21.3"
        myBasicCalcVM_test.operand2 = "10.2"
        myBasicCalcVM_test.operator = '-'
        myBasicCalcVM_test.gotAResult = false
        myBasicCalcVM_test.isOprSet = true
        myBasicCalcVM_test.isDecimal1Set= true
        myBasicCalcVM_test.isDecimal2Set= true

        myViewOp1_test.text = "21.3"
        myViewOp2_test.text = "10.2"
        myViewOpr_test.text = "-"

        myBasicCalcVM_test.computeResult(myView_test, myViewOp1_test, myViewOp2_test, myViewOpr_test)

        assertEquals(myBasicCalcVM_test.operand1, "11.099999")
        assertEquals(myBasicCalcVM_test.operand2, null)
        assertEquals(myBasicCalcVM_test.operator, null)
        assertEquals(myBasicCalcVM_test.gotAResult, true)
        assertEquals(myBasicCalcVM_test.isOprSet, false)
        assertEquals(myBasicCalcVM_test.isDecimal1Set, false)
        assertEquals(myBasicCalcVM_test.isDecimal2Set, false)
        assertEquals(myBasicCalcVM_test.operand1Float, 21.3F)
        assertEquals(myBasicCalcVM_test.operand2Float, 10.2F)
        assertEquals(myBasicCalcVM_test.result, 11.099999F)

        assertEquals(myViewOp1_test.text, "11.099999")
        assertEquals(myViewOp2_test.text, "")
        assertEquals(myViewOpr_test.text, "")

    }

    /*

    @Test
    fun test_compareResult_divideByZero() {

        val context_test = ApplicationProvider.getApplicationContext<Context>()
        val myViewOp1_test = TextView(context_test)
        val myViewOp2_test = TextView(context_test)
        val myViewOpr_test = TextView(context_test)
        val myView_test = View(context_test)

        myBasicCalcVM_test.operand1 = "21.3"
        myBasicCalcVM_test.operand2 = "0."
        myBasicCalcVM_test.operator = '/'
        myBasicCalcVM_test.gotAResult = true
        myBasicCalcVM_test.isOprSet = true
        myBasicCalcVM_test.isDecimal1Set= true
        myBasicCalcVM_test.isDecimal2Set= true

        myBasicCalcVM_test.operand1Float = 21.3F
        myBasicCalcVM_test.operand2Float = 0F
        myBasicCalcVM_test.result = 21.3F

        myViewOp1_test.text = "21.3"
        myViewOp2_test.text = "0."
        myViewOpr_test.text = "/"

        myBasicCalcVM_test.computeResult(myView_test, myViewOp1_test, myViewOp2_test, myViewOpr_test)

        assertEquals(myBasicCalcVM_test.operand1, "21.3")
        assertEquals(myBasicCalcVM_test.operand2, "0.")
        assertEquals(myBasicCalcVM_test.operator, '/')
        assertEquals(myBasicCalcVM_test.gotAResult, true)
        assertEquals(myBasicCalcVM_test.isOprSet, true)
        assertEquals(myBasicCalcVM_test.isDecimal1Set, true)
        assertEquals(myBasicCalcVM_test.isDecimal2Set, true)

        assertEquals(myViewOp1_test.text, "21.3")
        assertEquals(myViewOp2_test.text, "0.")
        assertEquals(myViewOpr_test.text, "/")

    }


     */

    @Test
    fun test_appendDecimal_op1AlreadyDecimal_op2AlreadyDecimal() {

        val context_test = ApplicationProvider.getApplicationContext<Context>()
        val myView1_test = TextView(context_test)
        val myView2_test = TextView(context_test)

        myBasicCalcVM_test.operand1 = "23.1"
        myBasicCalcVM_test.isDecimal1Set = true
        myBasicCalcVM_test.operand2 = "10.3"
        myBasicCalcVM_test.isDecimal2Set = true
        myBasicCalcVM_test.operator = '*'
        myBasicCalcVM_test.isOprSet = true

        myView1_test.text = "23.1"
        myView2_test.text = "10.3"


        myBasicCalcVM_test.appendDecimal(myView1_test, myView2_test)

        assertEquals(myView1_test.text, "23.1")
        assertEquals(myView2_test.text, "10.3")


    }

    @Test
    fun test_appendDecimal_op1AlreadyDecimal_oprNotSet() {

        val context_test = ApplicationProvider.getApplicationContext<Context>()
        val myView1_test = TextView(context_test)
        val myView2_test = TextView(context_test)

        myBasicCalcVM_test.operand1 = "23.1"
        myBasicCalcVM_test.isDecimal1Set = true

        myView1_test.text = "23.1"

        myBasicCalcVM_test.appendDecimal(myView1_test, myView2_test)

        assertEquals(myView1_test.text, "23.1")
        assertEquals(myView2_test.text, "")


    }

    @Test
    fun test_appendDecimal_op1AlreadyDecimal_op2Empty() {

        val context_test = ApplicationProvider.getApplicationContext<Context>()
        val myView1_test = TextView(context_test)
        val myView2_test = TextView(context_test)

        myBasicCalcVM_test.operand1 = "23.1"
        myBasicCalcVM_test.isDecimal1Set = true
        myBasicCalcVM_test.operator = '*'
        myBasicCalcVM_test.isOprSet = true

        myView1_test.text = "23.1"


        myBasicCalcVM_test.appendDecimal(myView1_test, myView2_test)

        assertEquals(myView1_test.text, "23.1")
        assertEquals(myView2_test.text, "")


    }

    @Test
    fun test_clearAll(){

        val context_test = ApplicationProvider.getApplicationContext<Context>()
        val myView1_test = TextView(context_test)
        val myView2_test = TextView(context_test)
        val myViewOpr_test = TextView(context_test)

        myBasicCalcVM_test.operand1 = "21.3"
        myBasicCalcVM_test.operand2 = "10.1"
        myBasicCalcVM_test.operator = '-'
        myBasicCalcVM_test.gotAResult = true
        myBasicCalcVM_test.isOprSet = true
        myBasicCalcVM_test.isDecimal1Set= true
        myBasicCalcVM_test.isDecimal2Set= true

        myView1_test.text = "21.3"
        myView2_test.text = "10.1"
        myViewOpr_test.text = "-"


        myBasicCalcVM_test.clearAll(myView1_test, myView2_test, myViewOpr_test)

        assertEquals(myBasicCalcVM_test.operand1, null)
        assertEquals(myBasicCalcVM_test.operand2, null)
        assertEquals(myBasicCalcVM_test.operator, null)
        assertEquals(myBasicCalcVM_test.gotAResult, false)
        assertEquals(myBasicCalcVM_test.isOprSet, false)
        assertEquals(myBasicCalcVM_test.isDecimal1Set, false)
        assertEquals(myBasicCalcVM_test.isDecimal2Set, false)

        assertEquals(myView1_test.text, "")
        assertEquals(myView2_test.text, "")
        assertEquals(myViewOpr_test.text, "")


    }

    @Test
    fun test_setViewElements_opsAreNull() {

        val context_test = ApplicationProvider.getApplicationContext<Context>()
        val myView1_test = TextView(context_test)
        val myView2_test = TextView(context_test)
        val myViewOpr_test = TextView(context_test)

        myBasicCalcVM_test.setViewElements(myView1_test, myView2_test, myViewOpr_test)

        assertEquals(myView1_test.text, "")
        assertEquals(myView2_test.text, "")
        assertEquals(myViewOpr_test.text, "")


    }

    @Test
    fun test_setViewElements_opsAreNotNull() {

        val context_test = ApplicationProvider.getApplicationContext<Context>()
        val myView1_test = TextView(context_test)
        val myView2_test = TextView(context_test)
        val myViewOpr_test = TextView(context_test)
        myBasicCalcVM_test.operand1 = "21"
        myBasicCalcVM_test.operand2 = "10"
        myBasicCalcVM_test.operator = '-'

        myBasicCalcVM_test.setViewElements(myView1_test, myView2_test, myViewOpr_test)

        assertEquals(myView1_test.text, "21")
        assertEquals(myView2_test.text, "10")
        assertEquals(myViewOpr_test.text, "-")


    }

    @Test
    fun test_whichOpToModify_op1() {

        val result = myBasicCalcVM_test.whichOpToModify()

        assertEquals(result, "OP1")


    }

    @Test
    fun test_whichOpToModify_op2() {

        myBasicCalcVM_test.operator = '-'

        val result = myBasicCalcVM_test.whichOpToModify()

        assertEquals(result, "OP2")


    }

    @Test
    fun test_whichOpToModify_none() {

        myBasicCalcVM_test.gotAResult = true

        val result = myBasicCalcVM_test.whichOpToModify()

        assertEquals(result, null)


    }


    @Test
    fun test_howToWriteOp1_notZero_viewEmpty() {

        val context_test = ApplicationProvider.getApplicationContext<Context>()
        val myView1_test = TextView(context_test)

        myBasicCalcVM_test.howToWriteOp1("5", myView1_test)

        assertEquals(myBasicCalcVM_test.operand1, "5")

    }

    @Test
    fun test_howToWriteOp1_notZero_viewNotEmpty() {

        val context_test = ApplicationProvider.getApplicationContext<Context>()
        val myView1_test = TextView(context_test)

        myBasicCalcVM_test.operand1 = "21"
        myView1_test.text = "21"

        myBasicCalcVM_test.howToWriteOp1("7", myView1_test)

        assertEquals(myBasicCalcVM_test.operand1, "217")

    }

    @Test
    fun test_howToWriteOp1_zeroNotDecimal_viewNotEmpty() {

        val context_test = ApplicationProvider.getApplicationContext<Context>()
        val myView1_test = TextView(context_test)

        myBasicCalcVM_test.operand1 = "2"
        myView1_test.text = "2"

        myBasicCalcVM_test.howToWriteOp1("0", myView1_test)

        assertEquals(myBasicCalcVM_test.operand1, "20")

    }

    @Test
    fun test_howToWriteOp1_zeroNotDecimal_viewEmpty() {

        val context_test = ApplicationProvider.getApplicationContext<Context>()
        val myView1_test = TextView(context_test)

        myBasicCalcVM_test.howToWriteOp1("0", myView1_test)

        assertEquals(myBasicCalcVM_test.operand1, "0.")

    }

    @Test
    fun test_howToWriteOp1_zeroDecimal_viewNotEmpty() {

        val context_test = ApplicationProvider.getApplicationContext<Context>()
        val myView1_test = TextView(context_test)

        myBasicCalcVM_test.operand1 = "0.3"
        myBasicCalcVM_test.isDecimal1Set = true
        myView1_test.text = "0.3"

        myBasicCalcVM_test.howToWriteOp1("0", myView1_test)

        assertEquals(myBasicCalcVM_test.operand1, "0.30")

    }

    @Test
    fun test_howToWriteOp1_zeroOnUnity() {

        val context_test = ApplicationProvider.getApplicationContext<Context>()
        val myView1_test = TextView(context_test)

        myBasicCalcVM_test.operand1 = "0"
        myView1_test.text = "0"

        myBasicCalcVM_test.howToWriteOp1("0", myView1_test)

        assertEquals(myBasicCalcVM_test.operand1, "0")

    }

    @Test
    fun test_howToWriteOp2_notZero_viewEmpty() {

        val context_test = ApplicationProvider.getApplicationContext<Context>()
        val myView2_test = TextView(context_test)

        myBasicCalcVM_test.howToWriteOp2("5", myView2_test)

        assertEquals(myBasicCalcVM_test.operand2, "5")

    }

    @Test
    fun test_howToWriteOp2_notZero_viewNotEmpty() {

        val context_test = ApplicationProvider.getApplicationContext<Context>()
        val myView2_test = TextView(context_test)

        myBasicCalcVM_test.operand2 = "21"
        myView2_test.text = "21"

        myBasicCalcVM_test.howToWriteOp2("7", myView2_test)

        assertEquals(myBasicCalcVM_test.operand2, "217")

    }

    @Test
    fun test_howToWriteOp2_zeroNotDecimal_viewNotEmpty() {

        val context_test = ApplicationProvider.getApplicationContext<Context>()
        val myView2_test = TextView(context_test)

        myBasicCalcVM_test.operand2 = "2"
        myView2_test.text = "2"

        myBasicCalcVM_test.howToWriteOp2("0", myView2_test)

        assertEquals(myBasicCalcVM_test.operand2, "20")

    }

    @Test
    fun test_howToWriteOp2_zeroNotDecimal_viewEmpty() {

        val context_test = ApplicationProvider.getApplicationContext<Context>()
        val myView2_test = TextView(context_test)

        myBasicCalcVM_test.howToWriteOp2("0", myView2_test)

        assertEquals(myBasicCalcVM_test.operand2, "0.")

    }

    @Test
    fun test_howToWriteOp2_zeroDecimal_viewNotEmpty() {

        val context_test = ApplicationProvider.getApplicationContext<Context>()
        val myView2_test = TextView(context_test)

        myBasicCalcVM_test.operand2 = "0.3"
        myBasicCalcVM_test.isDecimal2Set = true
        myView2_test.text = "0.3"

        myBasicCalcVM_test.howToWriteOp2("0", myView2_test)

        assertEquals(myBasicCalcVM_test.operand2, "0.30")

    }

    @Test
    fun test_howToWriteOp2_zeroOnUnity() {

        val context_test = ApplicationProvider.getApplicationContext<Context>()
        val myView2_test = TextView(context_test)

        myBasicCalcVM_test.operand2 = "0"
        myView2_test.text = "0"

        myBasicCalcVM_test.howToWriteOp2("0", myView2_test)

        assertEquals(myBasicCalcVM_test.operand2, "0")

    }

    @Test
    fun test_writeOperand_op1Correct() {

        val context_test = ApplicationProvider.getApplicationContext<Context>()
        val myView1_test = TextView(context_test)
        val myView_test = View(context_test)

        myBasicCalcVM_test.operand1 = "21"

        myBasicCalcVM_test.writeOperand(myView_test, myView1_test, "OP1")

        assertEquals(myView1_test.text, "21")


    }

    @Test
    fun test_writeOperand_op2Correct() {

        val context_test = ApplicationProvider.getApplicationContext<Context>()
        val myView2_test = TextView(context_test)
        val myView_test = View(context_test)

        myBasicCalcVM_test.operand2 = "21"

        myBasicCalcVM_test.writeOperand(myView_test, myView2_test, "OP2")

        assertEquals(myView2_test.text, "21")


    }

    @Test
    fun test_writeOperand_wrongOp() {

        val context_test = ApplicationProvider.getApplicationContext<Context>()
        val myView2_test = TextView(context_test)
        val myView_test = View(context_test)

        myBasicCalcVM_test.operand1 = "11"
        myBasicCalcVM_test.operand2 = "21"

        myBasicCalcVM_test.writeOperand(myView_test, myView2_test, "OPX")

        assertEquals(myView2_test.text, "")


    }






}