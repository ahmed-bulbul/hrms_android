package com.walton.smarthrm.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.walton.smarthrm.adapter.UserListAdapter
import com.walton.smarthrm.databinding.ActivityUserListBinding
import com.walton.smarthrm.model.User2
import com.walton.smarthrm.model.UserListResponse
import com.walton.smarthrm.retrofit.ApiConfig
import com.walton.smarthrm.retrofit.ClientInstance
import com.walton.smarthrm.utils.SharedPreferenceInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UserListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserListBinding
    lateinit var adapter: UserListAdapter
    private lateinit var preferenceInfo: SharedPreferenceInfo
    private var userList = mutableListOf<User2>()
    var pageNum = 1
    var pageSize = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferenceInfo = SharedPreferenceInfo(this)
        getUserList(pageNum, pageSize)
    }

    private fun getUserList(page_num: Int, page_size: Int) {
        val config = ClientInstance().getRetrofitInstance()!!.create(ApiConfig::class.java)
        val call: Call<UserListResponse> =
            config.getUserList(
                preferenceInfo.getToken("token")!!,
                page_num,
                page_size,
                "User",
                "getListData"
            )
        call.enqueue(object : Callback<UserListResponse> {
            override fun onResponse(
                call: Call<UserListResponse?>,
                response: Response<UserListResponse>
            ) {
                if (response.isSuccessful) {

                    /*for(user in response.body()!!.data)*/ userList.addAll(response.body()!!.data)

                    //userList = response.body()!!.data
                    adapter = UserListAdapter(userList)
                    binding.userListRecyclerview.adapter = adapter
                    binding.userListRecyclerview.layoutManager =
                        LinearLayoutManager(this@UserListActivity)



                    binding.userListRecyclerview.addOnScrollListener(object :
                        RecyclerView.OnScrollListener() {
                        override fun onScrollStateChanged(
                            recyclerView: RecyclerView,
                            newState: Int
                        ) {
                            super.onScrollStateChanged(recyclerView, newState)
                            if (!recyclerView.canScrollVertically(1)) {
                                if (pageNum <= response.body()!!.totalPages) {
                                    pageNum++
                                    pageSize += 10
                                    loadMoreData(pageNum, pageSize)
                                }
                            }
                        }
                    })

                }
            }

            override fun onFailure(call: Call<UserListResponse>, t: Throwable) {
                Log.d("error", t.message!!)
            }
        })
    }

    private fun loadMoreData(page_num: Int, page_size: Int) {
        val config = ClientInstance().getRetrofitInstance()!!.create(ApiConfig::class.java)
        val call: Call<UserListResponse> =
            config.getUserList(
                preferenceInfo.getToken("token")!!,
                page_num,
                page_size,
                "User",
                "getListData"
            )
        call.enqueue(object : Callback<UserListResponse> {
            override fun onResponse(
                call: Call<UserListResponse?>,
                response: Response<UserListResponse>
            ) {
                if (response.isSuccessful) {

                    for(user in response.body()!!.data) userList.add(user)

                    //userList = userList+ response.body()!!.data
                    adapter = UserListAdapter(userList)
                    binding.userListRecyclerview.adapter = adapter

                }
            }

            override fun onFailure(call: Call<UserListResponse>, t: Throwable) {
                Log.d("error", t.message!!)
            }
        })
    }
}