package com.example.lovecalculator.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.app.KeysObject
import com.example.lovecalculator.databinding.FragmentResultBinding
import com.example.lovecalculator.model.CalculateModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResultFragment : Fragment() {

    private var binding: FragmentResultBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentResultBinding.inflate(LayoutInflater.from(context), container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model = arguments?.getSerializable(KeysObject.KEY_FOR_BUNDLE) as CalculateModel

        binding?.txtMe?.text = model.firstName
        binding?.txtYou?.text = model.secondName
        val attach = "${model.percentage}%"
        binding?.tvPercentage?.text = attach

        val str = "${model.result}%"
        binding?.tvResult?.text = str


        binding?.btnTryAgain?.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}