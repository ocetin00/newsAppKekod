package com.oguzhancetin.newsappkekod

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.oguzhancetin.newsappkekod.databinding.FragmentOneBinding
import com.oguzhancetin.newsappkekod.databinding.FragmentThreeBinding
import com.oguzhancetin.newsappkekod.databinding.FragmentTwoBinding

open abstract class BaseFragment() : Fragment(), NewInstance{
    open lateinit var mainActivity: MainActivity;

}
interface NewInstance{
    fun newInstance(): Fragment
}

class FragmentOne : BaseFragment(){

    private lateinit var binding: FragmentOneBinding
    override fun onAttach(context: Context) {
        super.onAttach(context)
         super.mainActivity = context as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOneBinding.inflate(inflater)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cardOne.setOnClickListener {
            (mainActivity as CallBackListener).onClick(this)
        }
    }

    override fun newInstance(): Fragment {
        return FragmentOne()
    }

    companion object{
        fun newInstance() = FragmentOne()
    }
}
class FragmentTwo : BaseFragment(){

    private lateinit var binding: FragmentTwoBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        super.mainActivity = context as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTwoBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cardTwo.setOnClickListener {
            (mainActivity as CallBackListener).onClick(this)
        }
    }

    override fun newInstance(): Fragment {
        return FragmentTwo()
    }
}



class FragmentThre : BaseFragment(){

    private lateinit var binding: FragmentThreeBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        super.mainActivity = context as MainActivity
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThreeBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cardThree.setOnClickListener {
            (mainActivity as CallBackListener).onClick(this)
        }
    }

    override fun newInstance(): Fragment {
        return FragmentThre()
    }


}


