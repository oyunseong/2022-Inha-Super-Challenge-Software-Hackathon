package com.miggle.miggle.ui.category

import HorizontalItemDecorator
import VerticalItemDecorator
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.miggle.miggle.R
import com.miggle.miggle.base.BaseFragment
import com.miggle.miggle.databinding.FragmentDetailBoardBinding
import com.miggle.miggle.databinding.FragmentDetailCategoryBinding
import com.miggle.miggle.model.Category
import com.miggle.miggle.model.Movie
import com.miggle.miggle.server.IkcAPI
import com.miggle.miggle.server.RetrofitClient
import com.miggle.miggle.ui.home.FoodAdapter
import com.miggle.miggle.ui.home.MovieAdapter
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit

class DetailCategoryFragment :BaseFragment<FragmentDetailCategoryBinding>(){
    lateinit var categoryAdapter: CategoryAdapter
    val datas = mutableListOf<Category>()

    lateinit var retrofit: Retrofit
    lateinit var ikcApi: IkcAPI


    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailCategoryBinding {
        return FragmentDetailCategoryBinding.inflate(inflater,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initServer()
        initRecycler()
    }

    override fun initClickListener() {
        binding.searchBtn.setOnClickListener {
            view?.findNavController()?.navigate(R.id.SearchFragment)
        }

    }

    private fun initRecycler(){
        categoryAdapter = CategoryAdapter(requireContext())
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(layoutInflater.context,2)
        binding.detailCategoryRecycler.layoutManager = layoutManager
        binding.detailCategoryRecycler.adapter = categoryAdapter
        binding.detailCategoryRecycler.addItemDecoration(VerticalItemDecorator(20))
        binding.detailCategoryRecycler.addItemDecoration(HorizontalItemDecorator(20))
        binding.detailCategoryRecycler.setHasFixedSize(true)
    }

    private fun initServer() {
        retrofit = RetrofitClient.getInstance()
        ikcApi = retrofit.create(IkcAPI::class.java)

        Runnable {
            ikcApi.getMovie(
            )!!.enqueue(object : retrofit2.Callback<Movie?> {
                override fun onFailure(call: Call<Movie?>, t: Throwable) {
                    Log.d("homeFragment", t.message.toString())
                }

                override fun onResponse(call: Call<Movie?>, response: Response<Movie?>) {
                    Log.d("homeFragment", "response : ${response.errorBody()}")
                    Log.d("homeFragment", "response : ${response.message()}")
                    Log.d("homeFragment", "response : ${response.code()}")
                    Log.d("homeFragment", "response : ${response.raw().request.url}")
                    Log.d("homeFragment", "response : ${response.body()}")
                    Log.d(
                        "homeFragment",
                        "response : ${response.body()?.result?.get(0)?.image}"
                    )
                    Log.d("homeFragment", "response : ${response.body()?.result?.size}")

                    for (i in 0 until response.body()?.result?.size!!) {
                        Log.d("homeFragment", "response : ${response.body()?.result!![i].title}")
                        datas.add(
                            Category(
                                response.body()?.result!![i].image,
                                response.body()?.result!![i].title
                            )
                        )
                        categoryAdapter.datas = datas
                    }
                    categoryAdapter.notifyDataSetChanged()
                }
            })
        }.run()
    }
}