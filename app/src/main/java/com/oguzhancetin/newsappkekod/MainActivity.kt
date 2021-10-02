package com.oguzhancetin.newsappkekod

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.oguzhancetin.newsappkekod.databinding.ActivityMainBinding
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity(), CallBackListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        if (savedInstanceState == null) {
            initializeFragments();
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }

    private fun initializeFragments(){
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<FragmentOne>(binding.fragmentOneContainer.id)
            add<FragmentTwo>(binding.fragmentTwoContainer.id)
            add<FragmentThre>(binding.fragmentThreeContainer.id)
        }
    }

    override fun onClick(fragment: BaseFragment) {
        Toast.makeText(fragment.requireContext(), "${fragment.id}", Toast.LENGTH_SHORT).show()
        clearFragments()
        binding.topCardView.visibility = View.GONE;
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(binding.fragmentFocus.id,fragment.newInstance())

        }

    }
    private fun clearFragments(){
        for (fragment in supportFragmentManager.fragments) {
            supportFragmentManager.beginTransaction().remove(fragment).commit()
        }

    }

    override fun onBackPressed() {
        if(supportFragmentManager.fragments.size > 1){
            this.finish()
            exitProcess(0);
        }
        clearFragments()
        binding.topCardView.visibility = View.VISIBLE
        initializeFragments()


    }
}

interface CallBackListener{
    fun onClick(fragment: BaseFragment)
}