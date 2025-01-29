package com.example.e_commerce

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.e_commerce.categories.ui.CategoriesFragment
import com.example.e_commerce.databinding.FragmentMainBinding
import com.example.e_commerce.home.ui.HomeFragment


class MainFragment : Fragment() {


  private lateinit var binding:FragmentMainBinding
    private val args:MainFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMainBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBottomNavClicked()
    }

    private fun onBottomNavClicked() {
//        binding.bottomNav.setOnItemSelectedListener {
//           val fragment:Fragment=  when(it.itemId)
//            {
//                R.id.home -> HomeFragment()
//                R.id.category -> CategoriesFragment()
//                R.id.favourite -> HomeFragment()
//               else -> HomeFragment()
//
//            }
            pushFragment(HomeFragment())
//            true
//        }
//        binding.bottomNav.selectedItemId= R.id.home
    }

    private fun pushFragment(fragment:Fragment)
    {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.main_fragment_container,fragment)
            .commit()
    }


}