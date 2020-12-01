package com.example.funcalc.logic

import android.content.Context
import android.widget.TextView
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
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
    }

    @Test
    fun test_clearAll(){

        val context_test = ApplicationProvider.getApplicationContext<Context>()
        val myView1_test = TextView(context_test)
        val myView2_test = TextView(context_test)
        val myViewOpr_test = TextView(context_test)

        myBasicCalcVM_test.operand1 = "21"
        myBasicCalcVM_test.operand2 = "10"
        myBasicCalcVM_test.operator = '-'
        myBasicCalcVM_test.gotAResult = true
        myBasicCalcVM_test.isOprSet = true
        myBasicCalcVM_test.isDecimal1Set= true
        myBasicCalcVM_test.isDecimal2Set= true

        myView1_test.text = "21"
        myView2_test.text = "10"
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




}