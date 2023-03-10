package com.example.lovecalculator.ui.onBoarding

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.lovecalculator.databinding.FragmentOnBoardPageBinding

class OnBoardPageFragment : Fragment() {

    companion object {
        const val IS_LAST_ARG = "is_last"
    }

    private var binding: FragmentOnBoardPageBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentOnBoardPageBinding.inflate(LayoutInflater.from(context), container, false)
        return binding!!.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
        initViews()
    }

    private fun initListeners() {
        binding?.btnStart?.setOnClickListener {
            (parentFragment as OnBoardListener).onStartClicked()
        }
    }

    private fun initViews() {
        binding?.springDotsIndicator?.attachTo(
            (parentFragment as OnBoardListener).getViewPager()
        )

        val data = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getSerializable(BoardModel.ARG_KEY, BoardModel::class.java)
        } else {
            arguments?.getSerializable(BoardModel.ARG_KEY) as BoardModel
        }
        val isLast = arguments?.getBoolean(IS_LAST_ARG)

        if (isLast == true) {
            binding?.apply {
                btnStart.visibility = View.VISIBLE
            }
        }

        binding?.textView1?.text = data?.title
        binding?.textView2?.text = data?.description
        binding?.imageView?.setImageResource(data!!.imageResId)

    }

    interface OnBoardListener {
        fun onStartClicked()
        fun getViewPager(): ViewPager2

    }
}