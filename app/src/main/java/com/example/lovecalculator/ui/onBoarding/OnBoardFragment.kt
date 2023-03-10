package com.example.lovecalculator.ui.onBoarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentOnBoardBinding
import com.example.lovecalculator.ui.utils.Preferences

class OnBoardFragment : Fragment(), OnBoardPageFragment.OnBoardListener {

    private var binding: FragmentOnBoardBinding? = null
    private var boardAdapter: OnBoardAdapter? = null
    private var boardModels = listOf(

        BoardModel(
            imageResId = R.drawable.image6,
            title = "Have a good time",
            description = "You should take the time to help those\n who need you"
        ),

        BoardModel(
            imageResId = R.drawable.image7,
            title = "Cherishing love",
            description = "It is now no longer possible for\n you to cherish love ",
        ),
        BoardModel(
            imageResId = R.drawable.image8,
            title = "Have a breakup?",
            description = "We have made the correction for you\n don't worry "
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentOnBoardBinding.inflate(
            LayoutInflater.from(context), container, false)
        return binding!!.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }
    private fun initViews(){
        boardAdapter = OnBoardAdapter(
            childFragmentManager, lifecycle, boardModels
        )
        binding?.viewPager?.adapter = boardAdapter
    }

    override fun onStartClicked() {
        findNavController().navigate(R.id.mainFragment)
        Preferences(requireContext()).apply {
            setHaveSeenOnBoarding()
        }
    }

    override fun getViewPager(): ViewPager2 {
        return binding?.viewPager!!
    }
}