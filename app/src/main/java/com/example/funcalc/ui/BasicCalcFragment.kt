package com.example.funcalc.ui

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.funcalc.R
import com.example.funcalc.logic.BasicCalculatorViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_basic_calc.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class BasicCalcFragment : Fragment() {

    private val myBasicCalcVM : BasicCalculatorViewModel by activityViewModels()

    //val myBasicCalcVM = ViewModelProvider(requireActivity()).get(BasicCalculatorViewModel::class.java)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        setHasOptionsMenu(true)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_basic_calc, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myBasicCalcVM.setViewElements(operand1View, operand2View, operatorView)


        view.findViewById<Button>(R.id.button_0).setOnClickListener {
            myBasicCalcVM.appendOperand1(requireView(),"0", operand1View, operand2View)
        }

        view.findViewById<Button>(R.id.button_1).setOnClickListener {
            myBasicCalcVM.appendOperand1(requireView(),"1", operand1View, operand2View)
        }

        view.findViewById<Button>(R.id.button_2).setOnClickListener {
            myBasicCalcVM.appendOperand1(requireView(),"2", operand1View, operand2View)
        }

        view.findViewById<Button>(R.id.button_3).setOnClickListener {
            myBasicCalcVM.appendOperand1(requireView(),"3", operand1View, operand2View)
        }

        view.findViewById<Button>(R.id.button_4).setOnClickListener {
            myBasicCalcVM.appendOperand1(requireView(),"4", operand1View, operand2View)
        }

        view.findViewById<Button>(R.id.button_5).setOnClickListener {
            myBasicCalcVM.appendOperand1(requireView(),"5", operand1View, operand2View)
        }

        view.findViewById<Button>(R.id.button_6).setOnClickListener {
            myBasicCalcVM.appendOperand1(requireView(),"6", operand1View, operand2View)
        }

        view.findViewById<Button>(R.id.button_7).setOnClickListener {
            myBasicCalcVM.appendOperand1(requireView(),"7", operand1View, operand2View)
        }

        view.findViewById<Button>(R.id.button_8).setOnClickListener {
            myBasicCalcVM.appendOperand1(requireView(),"8", operand1View, operand2View)
        }

        view.findViewById<Button>(R.id.button_9).setOnClickListener {
            myBasicCalcVM.appendOperand1(requireView(),"9", operand1View, operand2View)
        }

        view.findViewById<Button>(R.id.button_plus).setOnClickListener {
            myBasicCalcVM.setOperator('+', operatorView)
        }

        view.findViewById<Button>(R.id.button_minus).setOnClickListener {
            myBasicCalcVM.setOperator('-', operatorView)
        }

        view.findViewById<Button>(R.id.button_multiply).setOnClickListener {
            myBasicCalcVM.setOperator('*', operatorView)
        }

        view.findViewById<Button>(R.id.button_divide).setOnClickListener {
            myBasicCalcVM.setOperator('/', operatorView)
        }

        view.findViewById<Button>(R.id.button_equal).setOnClickListener {
            myBasicCalcVM.computeResult(requireView(), operand1View, operand2View, operatorView)
        }

        view.findViewById<Button>(R.id.button_C).setOnClickListener {
            myBasicCalcVM.clearAll(operand1View, operand2View, operatorView)
        }

        view.findViewById<Button>(R.id.button_decimal).setOnClickListener {
            myBasicCalcVM.appendDecimal(operand1View, operand2View,)
        }






    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        activity?.menuInflater?.inflate(R.menu.menu_basic, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_switch_to_scientific -> {

                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }



}