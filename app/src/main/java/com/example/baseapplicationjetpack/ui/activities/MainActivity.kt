package com.example.baseapplicationjetpack.ui.activities

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.baseapplicationjetpack.R
import com.example.baseapplicationjetpack.data.entities.PostEntity
import com.example.baseapplicationjetpack.databinding.ActivityMainBinding
import com.example.baseapplicationjetpack.ui.adapters.PostListAdapter
import com.example.baseapplicationjetpack.ui.base.BaseActivity
import com.example.baseapplicationjetpack.utility.createFor
import com.example.baseapplicationjetpack.viewmodel.MainActivityViewModel
import javax.inject.Inject

class MainActivity : BaseActivity() {
    @Inject
    lateinit var mainActivityViewModel: MainActivityViewModel
    var postListAdapter : PostListAdapter? = null

    override fun getLayout(): Int = R.layout.activity_main
    override fun isDataBindingEnabled(): Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityViewModel =
                ViewModelProviders.of(this, createFor(mainActivityViewModel)).get(MainActivityViewModel::class.java)

        insertPosts()
        setUpRecyclerView()
    }

    fun getBinding(): ActivityMainBinding = binding as ActivityMainBinding
    fun insertPosts() {
        mainActivityViewModel.insertPost(PostEntity(0, "reema"))
    }

    fun setUpRecyclerView(){
        with(getBinding().recyclerview){
            layoutManager = LinearLayoutManager(this@MainActivity)
            postListAdapter = PostListAdapter()
            adapter = postListAdapter
        }
        fetchData()
    }

    fun fetchData(){
        mainActivityViewModel.getPosts().subscribe ({
            if(it!=null)
                postListAdapter?.swapData(it)
        },{
            it.stackTrace
        },{

        })
    }
}
