package com.example.pureattire_capstoneproject_info6134.fragments.categories

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.pureattire_capstoneproject_info6134.data.Category
import com.example.pureattire_capstoneproject_info6134.util.Resource
import com.example.pureattire_capstoneproject_info6134.viewmodel.BaseCategoryViewModelFactoryFactory
import com.example.pureattire_capstoneproject_info6134.viewmodel.CategoryViewModel
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@AndroidEntryPoint
class HijabFragment : BaseCategoryFragment() {
    @Inject
    lateinit var firestore: FirebaseFirestore

    private val viewModel: CategoryViewModel by viewModels {
        val category: Category = Category.Hijab
        BaseCategoryViewModelFactoryFactory(firestore, category)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenStarted {
            viewModel.offerProducts.collectLatest {
                when (it) {
                    is Resource.Loading -> showOfferLoading()
                    is Resource.Success -> {
                        offerAdapter.differ.submitList(it.data)
                        hideOfferLoading()
                    }
                    is Resource.Error -> {
                        Snackbar.make(requireView(), it.message.toString(), Snackbar.LENGTH_LONG).show()
                        hideOfferLoading()
                    }

                    else -> {}
                }
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.bestProducts.collectLatest {
                when (it) {
                    is Resource.Loading -> showBestProductsLoading()
                    is Resource.Success -> {
                        bestProductsAdapter.differ.submitList(it.data)
                        hideBestProductsLoading()
                    }
                    is Resource.Error -> {
                        Snackbar.make(requireView(), it.message.toString(), Snackbar.LENGTH_LONG).show()
                        hideBestProductsLoading()
                    }

                    else -> {}
                }
            }
        }
    }
    override fun onBestProductsPagingRequest() {

    }

    override fun onOfferPagingRequest() {

    }
}