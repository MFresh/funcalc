package com.example.funcalc

import android.content.Context
import android.widget.TextView
import androidx.test.core.app.ApplicationProvider
import com.example.funcalc.logic.BasicCalculatorViewModel

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    /*

    private val myBasicCalcVM_test = BasicCalculatorViewModel()

    @Before
    fun clear_BasicCalcVM(){
        myBasicCalcVM_test.operand1 = null
        myBasicCalcVM_test.operand2 = null
        myBasicCalcVM_test.operator = null
        myBasicCalcVM_test.gotAResult = false
        myBasicCalcVM_test.isOprSet = false
        myBasicCalcVM_test.isDecimal1Set= false
        myBasicCalcVM_test.isDecimal2Set= false
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun subtraction_isCorrect() {
        assertNotEquals(2, 4 - 1)
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

     */


}