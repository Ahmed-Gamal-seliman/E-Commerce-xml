package com.example.e_commerce.authentication.signin.ui

import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import com.example.domain.models.user.User
import com.example.e_commerce.R
import com.example.e_commerce.authentication.signin.viewmodel.SinginViewModel

import com.example.e_commerce.authentication.signup.viewmodel.SingupViewModel
import com.example.e_commerce.databinding.FragmentSinginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SinginFragment : Fragment() {

    private lateinit var binding:FragmentSinginBinding
    private val viewModel: SinginViewModel by viewModels<SinginViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding= FragmentSinginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onClicks()

        observeLiveData()

    }

    private fun observeLiveData() {
        viewModel.userLive.observe(viewLifecycleOwner)
        {user->
            navigateToHomePage(user)
        }
        viewModel.isLoading.observe(viewLifecycleOwner)
        {
            isLoading->
            showLoading(isLoading)

        }
        viewModel.error.observe(viewLifecycleOwner)
        {
            errorMessage->
            showDialog(errorMessage)
        }
    }

    private fun showDialog(errorMessage: String?) {

        AlertDialog.Builder(requireActivity())
            .setOnCancelListener{
                it.dismiss()
            }
            .setPositiveButton(R.string.ok
            ) { p1,p2->
                p1.dismiss()
            }
            .setNegativeButton(R.string.cancel)
            {
                p1,p2->
                p1.dismiss()
            }
            .setTitle(errorMessage)
            .show()

    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.isVisible= isLoading

    }

    private fun navigateToHomePage(user:User?) {
       val action= SinginFragmentDirections.actionSigninFragmentToMainFragment(user)
        findNavController().navigate(action)
    }

    private fun onClicks() {
        onCreateAccountClicked()
        onLoginButtonClicked()
    }
    private fun onCreateAccountClicked(){
        binding.tvCreateAccount.setOnClickListener{
            findNavController().navigate(R.id.action_signinFragment_to_singupFragment)
        }
    }
    private fun onLoginButtonClicked(){
        binding.btnLogin.setOnClickListener{
            binding.textInputEditTextPassword.onEditorAction(EditorInfo.IME_ACTION_DONE)
            binding.textInputEditTextUserName.onEditorAction(EditorInfo.IME_ACTION_DONE)
            viewModel.loginUser(
                User(
                    email = binding.textInputEditTextUserName.text.toString(),
                    password = binding.textInputEditTextPassword.text.toString()
                )
            )
        }
    }


}