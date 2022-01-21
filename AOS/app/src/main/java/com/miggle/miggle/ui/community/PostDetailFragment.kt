package com.miggle.miggle.ui.community

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.miggle.miggle.base.BaseFragment
import com.miggle.miggle.databinding.FragmentDetailBoardBinding
import com.miggle.miggle.model.DartResponse
import com.miggle.miggle.server.PostAPI
import com.miggle.miggle.server.RetrofitAPI
import com.miggle.miggle.server.RetrofitClient
import com.miggle.miggle.server.RetrofitClient2
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class PostDetailFragment : BaseFragment<FragmentDetailBoardBinding>() {

    val postApiClient: PostAPI by lazy {
        RetrofitClient2.getPostService()
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailBoardBinding {
        return FragmentDetailBoardBinding.inflate(inflater, container, false)
    }

    override fun initClickListener() {
        postApiClient.getDart(
            crtfc_key = "b2ee4ac66008d7ebb5e87165604bae92cf554783",
            corp_code = "00164779",
            bsns_year = 2020,
            reprt_code = 11011,
        )!!.enqueue(object : retrofit2.Callback<DartResponse?> {
            override fun onResponse(call: Call<DartResponse?>, response: Response<DartResponse?>) {
                val response: DartResponse? = response.body()
                Log.d("dartResponse", postApiClient.toString())
            }

            override fun onFailure(call: Call<DartResponse?>, t: Throwable) {
                Log.d("dartResponse", t.message.toString())
            }

        }
        )

    }
}