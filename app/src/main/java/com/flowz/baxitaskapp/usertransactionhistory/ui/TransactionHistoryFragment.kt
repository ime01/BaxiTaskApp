package com.flowz.baxitaskapp.usertransactionhistory.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.LinearLayout.VERTICAL
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.flowz.baxitaskapp.R
import com.flowz.baxitaskapp.databinding.FragmentTransactionHistoryBinding
import com.flowz.baxitaskapp.usertransactionhistory.adapter.UserHistoryAdapter
import com.flowz.baxitaskapp.usertransactionhistory.data.local.DataX
import com.flowz.byteworksjobtask.util.getConnectionType
import com.flowz.byteworksjobtask.util.showSnackbar
import com.flowz.sixtjobapp2.presentation.cars_list.UserHistoryApiStatus
import com.flowz.sixtjobapp2.presentation.cars_list.UserHistoryViewModel
import com.plcoding.cryptocurrencyappyt.common.Constants
import dagger.hilt.android.AndroidEntryPoint

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

@AndroidEntryPoint
class TransactionHistoryFragment : Fragment(R.layout.fragment_transaction_history){

    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentTransactionHistoryBinding? = null
    private val binding get() = _binding!!
    private lateinit var userHistoryAdapter: UserHistoryAdapter
    private val viewModel: UserHistoryViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentTransactionHistoryBinding.bind(view)

        observeState()

        userHistoryAdapter = UserHistoryAdapter{
            showSnackbar(binding.rvTransactionHistory, "Transaction with amount ${it.transactionAmount} Clicked")
        }

        if (getConnectionType(requireContext())){

            viewModel.getUserHistory(Constants.PNUM)

        }else{
            showSnackbar(binding.floatingActionButton, "Ensure you have proper internet connection and try again")

        }

    }



    private fun observeState() {

        binding.apply {
            viewModel.requestHistoryNetworkStatus.observe(viewLifecycleOwner, Observer { state ->

                state?.also {
                    when (it) {
                        UserHistoryApiStatus.ERROR -> {

                            errorText.visibility = View.VISIBLE
//                            errorText.text =
//                            shimmerFrameLayout.startShimmer()
                            shimmerFrameLayout.visibility = View.INVISIBLE

                            showSnackbar(binding.floatingActionButton, "Error Fetching Transaction History")

                            buttonRetry.visibility = View.VISIBLE

                            buttonRetry.setOnClickListener {
                                viewModel.getUserHistory(Constants.PNUM)
                            }

                        }
                        UserHistoryApiStatus.LOADING -> {

                            shimmerFrameLayout.startShimmer()
                            shimmerFrameLayout.visibility = View.VISIBLE
                        }

                        UserHistoryApiStatus.DONE -> {
                            viewModel.historyResponseFromNetwork.observe(viewLifecycleOwner, {

                                Log.e("HISTORY", " History Data is: $it")

                                    val details = it.data.data.last()

                                    errorText.visibility = View.INVISIBLE

                                    loadRecyclerView(it.data.data)

                                    errorText.text = "${details.transactionDescription}, ${details.transactionAmount}, ${details.transactionDate}"

                                })

                        }

                    }
                }

            })

        }
    }

    private fun loadRecyclerView(transactionData: List<DataX>) {

        userHistoryAdapter.submitList(transactionData)

                binding.apply {
                    errorText.visibility = View.INVISIBLE
                    rvTransactionHistory.layoutManager = LinearLayoutManager(requireContext())
                    rvTransactionHistory.adapter = userHistoryAdapter
                    val decoration = DividerItemDecoration(requireContext(), VERTICAL)
                    rvTransactionHistory.addItemDecoration(decoration)

                    shimmerFrameLayout.stopShimmer()
                    shimmerFrameLayout.visibility = View.GONE
                }

    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TransactionHistoryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TransactionHistoryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}