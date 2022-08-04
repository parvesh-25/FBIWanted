package com.altaf.fbiwanted

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.altaf.fbiwanted.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    private var _viewModel: MainViewModel? = null
    private val viewModel get() = _viewModel as MainViewModel

    private lateinit var rvWanted: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // hubungin ke MainViewModel
       _viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
       // ambil data dari ViewModel
        viewModel.getWantedData()

        viewModel.wantedResponse.observe(this){showData(it)}
        viewModel.isLoading.observe(this){showLoading(it)}
        //viewModel.isError.observe(this){showError(it)}
    }

    private fun showData(data: List<ItemsItem>?) {
        binding.rvWanted.apply {
            val mAdapter = WantedAdapter()
            mAdapter.setData(data)
            // rv ditampilkan dlmbentuk grid
            layoutManager = GridLayoutManager(this@MainActivity,2)
            adapter = mAdapter
        }
    }

    private fun showLoading(isLoading: Boolean?) {
        if (isLoading == true){
            binding.progressMain.visibility = View.VISIBLE
            binding.rvWanted.visibility = View.INVISIBLE
        }else{
            binding.progressMain.visibility = View.INVISIBLE
            binding.rvWanted.visibility = View.VISIBLE
        }
    }

//    private fun showError(isError: Throwable?) {
//        Log.e("MainActivity", "showError: ${error()?.message}")
//    }

}