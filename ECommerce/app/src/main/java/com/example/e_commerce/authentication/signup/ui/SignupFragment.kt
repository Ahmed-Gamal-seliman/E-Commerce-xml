package com.example.e_commerce.authentication.signup.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.domain.models.user.User
import com.example.e_commerce.R
import com.example.e_commerce.authentication.signup.viewmodel.SingupViewModel
import com.example.e_commerce.databinding.FragmentSignupBinding
import com.example.e_commerce.home.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignupFragment : Fragment() {

private lateinit var binding: FragmentSignupBinding
private val viewModel: SingupViewModel by viewModels<SingupViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSignupBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSignup.setOnClickListener{

            viewModel.registerUser(
                User(
                    name = binding.textInputEditTextUserName.text.toString(),
                    email = binding.textInputEditTextEmailAddress.text.toString(),
                    phone = binding.textInputEditTextMobileNumber.text.toString(),
                    password = binding.textInputEditTextPassword.text.toString(),
                    rePassword = binding.textInputEditTextConfimrPassword.text.toString()

                )
            )
        }
    }

}