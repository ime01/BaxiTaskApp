package com.flowz.baxitaskapp.userlogin.ui

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.flowz.baxitaskapp.R
import com.flowz.baxitaskapp.userlogin.data.local.LoginRequestModel
import com.flowz.baxitaskapp.databinding.FragmentLoginBinding
import com.flowz.byteworksjobtask.util.getConnectionType
import com.flowz.byteworksjobtask.util.showSnackbar
import com.flowz.byteworksjobtask.util.takeWords
import com.flowz.sixtjobapp2.presentation.cars_list.UserApiStatus
import com.flowz.sixtjobapp2.presentation.cars_list.UsersViewModel
import com.plcoding.cryptocurrencyappyt.common.Constants
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val userViewModel: UsersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentLoginBinding.bind(view)
        observeState()

//        val userloginRequest = LoginRequestModel("debbyoffor", "Password@2", "android")


        binding.apply {

            loginButton.setOnClickListener {

                if (TextUtils.isEmpty(userName.text.toString())) {
                    userName.setError(getString(R.string.enter_valid_input))
                    return@setOnClickListener
                } else if (TextUtils.isEmpty(password.text.toString())) {
                    password.setError(getString(R.string.enter_password))
                    return@setOnClickListener
                } else {
                    val firstName = userName.takeWords()
                    val password = password.takeWords()

                    val userloginRequest = LoginRequestModel(firstName, password, Constants.CHANNEL)

                    if (getConnectionType(requireContext())) {

                        userViewModel.LoginUser(userloginRequest)
//
                    } else {
                        showSnackbar(loginButton, "Ensure you have proper internet connection and try again")

                    }
                }
            }

        }
    }

    fun observeState(){

        binding.apply {

            userViewModel.requestLoginNetworkStatus.observe(viewLifecycleOwner, Observer { state ->

                state?.also {
                    when (it) {
                        UserApiStatus.ERROR -> {

                            progressBar.visibility = View.INVISIBLE

                            showSnackbar(loginButton, getString(R.string.login_error))

                        }
                        UserApiStatus.LOADING -> {

                            progressBar.visibility = View.VISIBLE

                        }

                        UserApiStatus.DONE -> {
                            progressBar.visibility = View.INVISIBLE
                            userViewModel.userResponseFromNetwork.observe(viewLifecycleOwner, Observer {

                                lifecycleScope.launch {
                                        userViewModel.saveUserToken(it.userToken)
                                        userViewModel.saveRefreshUserToken(it.refreshToken)
                                }

                                    Navigation.findNavController(requireView()).navigate(R.id.action_loginFragment_to_transactionHistoryFragment)

                            })

                        }

                    }
                }

            })
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}