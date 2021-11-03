package com.flowz.baxitaskapp.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.flowz.baxitaskapp.R
import com.flowz.baxitaskapp.data.local.LoginRequestModel
import com.flowz.baxitaskapp.databinding.FragmentLoginBinding
import com.flowz.byteworksjobtask.util.getConnectionType
import com.flowz.byteworksjobtask.util.showSnackbar
import com.flowz.sixtjobapp2.presentation.cars_list.UserApiStatus
import com.flowz.sixtjobapp2.presentation.cars_list.UsersViewModel
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

        val userloginRequest = LoginRequestModel("debbyoffor", "Password@2", "android")


        binding.loginButton.setOnClickListener {

            if (getConnectionType(requireContext())){

                userViewModel.LoginUser(userloginRequest)

//                userViewModel.requestLoginNetworkStatus.observe(viewLifecycleOwner, Observer {state->
//
//                    state?.also {
//                        when(it.status){
//
//                            UserApiStatus.ERROR->{
//                                plainText.setText(it.toString())
//
////                    Snackbar.make(text, "Error in Logging in").show()
//                            }
//                            UserApiStatus.LOADING->{
//                                progressBar.visibility = View.VISIBLE
//                            }
//
//                            UserApiStatusDONE->{
//                                progressBar.visibility = View.GONE
//                                Log.e("done", "Request worked")
////                            loginViewModel.loginResponse.observe(this@LoginActivity, Observer {it
//                                val res = it.data
//                                plainText.text = res?.userToken
//                                Log.e("test", "${res.toString()}")
//
//                                lifecycleScope.launch {
//                                    res?.user?.userToken?.let { it1 ->
//                                        loginViewModel.saveUserToken(
//                                            it1
//                                        )
//                                    }
//                                }
////                                navMainActivity()
//
////                              Snackbar.make(button, "${res.toString()}").show()
////                            })
//                            }
//                        }
//                    }
//
//                })
//                navMainActivity()
//
            }else{
                showSnackbar( binding.loginButton, "Ensure you have proper internet connection and try again")
            }
        }

    }

    fun observeState(){

        binding.apply {

            userViewModel.requestLoginNetworkStatus.observe(viewLifecycleOwner, Observer { state ->

                state?.also {
                    when (it) {
                        UserApiStatus.ERROR -> {

//                            errorImage.isVisible = true
//                            errorText.isVisible = true
                            progressBar.visibility = View.INVISIBLE

                            showSnackbar(loginButton, "Error on Login Process")

                        }
                        UserApiStatus.LOADING -> {

//                            shimmerFrameLayout.startShimmer()
//                            shimmerFrameLayout.visibility = View.VISIBLE
                            progressBar.visibility = View.VISIBLE

                        }

                        UserApiStatus.DONE -> {
                            progressBar.visibility = View.INVISIBLE
                            userViewModel.userResponseFromNetwork.observe(viewLifecycleOwner, Observer {
                                userdetails.text = it.userToken

                                lifecycleScope.launch {
                                        userViewModel.saveUserToken(it.userToken)
                                }




                            })

                        }

                    }
                }

            })
        }

    }


}