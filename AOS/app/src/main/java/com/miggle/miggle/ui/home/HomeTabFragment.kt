package com.miggle.miggle.ui.home

import HorizontalItemDecorator
import VerticalItemDecorator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.miggle.miggle.BottomSheetFragment
import com.miggle.miggle.MainActivity
import com.miggle.miggle.base.BaseFragment
import com.miggle.miggle.databinding.FragmentHomeBinding
import com.miggle.miggle.model.Category
import com.miggle.miggle.model.Movie
import com.miggle.miggle.server.IkcAPI
import com.miggle.miggle.server.RetrofitClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit

class HomeTabFragment : BaseFragment<FragmentHomeBinding>() {
    lateinit var movieAdapter: MovieAdapter
    lateinit var foodAdapter: FoodAdapter
    lateinit var beautyAdapter: BeautyAdapter

    lateinit var retrofit: Retrofit
    lateinit var ikcApi: IkcAPI

    val movieDatas = mutableListOf<Category>()
    val usDatas = mutableListOf<Category>()
    val koreaDatas = mutableListOf<Category>()

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.homeAppbar.appbarSearchButton.visibility = View.INVISIBLE
        binding.homeAppbar.appbarSettingButton.visibility = View.INVISIBLE

        initServer()
        initRecycler()
    }


    override fun initClickListener() {
        binding.homeAppbar.appbarBellButton.setOnClickListener {
            val bottomSheetFragment = BottomSheetFragment()
            bottomSheetFragment.show(parentFragmentManager, bottomSheetFragment.tag)
        }
    }


    private fun initRecycler() {
        movieAdapter = MovieAdapter(requireContext())
        val layoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        binding.movieRecycler.layoutManager = layoutManager
        binding.movieRecycler.adapter = movieAdapter
        binding.movieRecycler.addItemDecoration(VerticalItemDecorator(20))
        binding.movieRecycler.addItemDecoration(HorizontalItemDecorator(20))
        binding.movieRecycler.setHasFixedSize(true)


        val layoutManager2: RecyclerView.LayoutManager =
            LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        foodAdapter = FoodAdapter(requireContext())
        binding.usRecycler.layoutManager = layoutManager2
        binding.usRecycler.adapter = foodAdapter
        binding.usRecycler.addItemDecoration(VerticalItemDecorator(20))
        binding.usRecycler.addItemDecoration(HorizontalItemDecorator(20))
        binding.usRecycler.setHasFixedSize(true)

        val layoutManager3: RecyclerView.LayoutManager =
            LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        beautyAdapter = BeautyAdapter(requireContext())
        binding.koreaRecycler.layoutManager = layoutManager3
        binding.koreaRecycler.adapter = foodAdapter
        binding.koreaRecycler.addItemDecoration(VerticalItemDecorator(20))
        binding.koreaRecycler.addItemDecoration(HorizontalItemDecorator(20))
        binding.koreaRecycler.setHasFixedSize(true)
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
                        movieDatas.add(
                            Category(
                                response.body()?.result!![i].image,
                                response.body()?.result!![i].title
                            )
                        )
                        movieAdapter.datas = movieDatas
                    }
                    for(i in response.body()?.result?.size!!-1 downTo 0)
                        koreaDatas.add(
                            Category(
                                response.body()?.result!![i].image,
                                response.body()?.result!![i].title
                            )
                        )
                        beautyAdapter.datas = koreaDatas

                    movieAdapter.notifyDataSetChanged()
                    beautyAdapter.notifyDataSetChanged()
                }
            })
        }.run()

        Runnable {
            ikcApi.getMovieUS(
            ).enqueue(object : retrofit2.Callback<Movie?> {
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
                        usDatas.add(
                            Category(
                                response.body()?.result!![i].image,
                                        response.body()?.result!![i].title
                            )
                        )

                        foodAdapter.datas = usDatas
                    }
                    foodAdapter.notifyDataSetChanged()
                }
            })
        }.run()

    }
}


//TODO 검색 키워드 :  okttp, retrofit logger 라이브러리를 이용하면 로그켓으로 찍어줌