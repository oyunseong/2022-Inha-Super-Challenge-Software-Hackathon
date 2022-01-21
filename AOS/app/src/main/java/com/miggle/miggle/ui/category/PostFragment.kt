package com.miggle.miggle.ui.category

import HorizontalItemDecorator
import VerticalItemDecorator
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.miggle.miggle.R
import com.miggle.miggle.base.BaseFragment
import com.miggle.miggle.databinding.FragmentDetailCategoryBinding
import com.miggle.miggle.databinding.FragmentPost2Binding
import com.miggle.miggle.model.Category
import com.miggle.miggle.model.Movie
import com.miggle.miggle.model.MovieDetail
import com.miggle.miggle.server.IkcAPI
import com.miggle.miggle.server.RetrofitClient
import com.miggle.miggle.ui.home.MovieAdapter
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit

class PostFragment :BaseFragment<FragmentPost2Binding>() {
    lateinit var categoryAdapter: CategoryAdapter
    val datas = mutableListOf<Category>()

    lateinit var retrofit: Retrofit
    lateinit var ikcApi: IkcAPI

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPost2Binding {
        return FragmentPost2Binding.inflate(inflater,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.appbar.appbarSearchButton.visibility = View.INVISIBLE
        binding.appbar.appbarSettingButton.visibility = View.INVISIBLE
        binding.appbar.appbarBellButton.visibility = View.INVISIBLE

        initServer()
        initRecycler()
    }

    override fun initClickListener() {

    }

    private fun initRecycler(){
        categoryAdapter = CategoryAdapter(requireContext())
        val layoutManager: RecyclerView.LayoutManager =LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        binding.recycler.layoutManager = layoutManager
        binding.recycler.adapter = categoryAdapter
        binding.recycler.addItemDecoration(VerticalItemDecorator(20))
        binding.recycler.addItemDecoration(HorizontalItemDecorator(20))
        binding.recycler.setHasFixedSize(true)

        datas.apply {

            categoryAdapter.datas = datas
            categoryAdapter.notifyDataSetChanged()
        }
    }

    private fun initServer() {
        retrofit = RetrofitClient.getInstance()
        ikcApi = retrofit.create(IkcAPI::class.java)

        Runnable {
            ikcApi.getDetail(

            ).enqueue(object : retrofit2.Callback<MovieDetail?> {
                override fun onFailure(call: Call<MovieDetail?>, t: Throwable) {
                    Log.d("homeFragment", t.message.toString())
                }

                override fun onResponse(call: Call<MovieDetail?>, response: Response<MovieDetail?>) {
                    Log.d("homeFragment", "response : ${response.errorBody()}")
                    Log.d("homeFragment", "response : ${response.message()}")
                    Log.d("homeFragment", "response : ${response.code()}")
                    Log.d("homeFragment", "response : ${response.raw().request.url}")
                    Log.d("homeFragment", "response : ${response.body()}")

                    val imageUrl :String = response.body()!!.result.get(0).image

                    Glide.with(requireContext()).load(imageUrl)
                        .placeholder(R.color.white)
                        .error(R.color.white)
                        .into(binding.image)
                    binding.title.text = response.body()?.result!!.get(0).eTitle+","
                    binding.ktitle.text = response.body()?.result!!.get(0).kTitle
                    binding.contentsTv.text =response.body()?.result!!.get(0).englishExplain
                }
            })
        }.run()


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

                    for (i in 1 until response.body()?.result?.size!!) {
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