package com.khunsma.myanamrbanks.view.activity

import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.khunsma.myanamrbanks.R
import com.khunsma.myanamrbanks.action
import com.khunsma.myanamrbanks.snack
import com.khunsma.myanamrbanks.view.adapter.BankListAdapter
import com.khunsma.myanamrbanks.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private lateinit var mainViewModel: MainViewModel
    private val adapter = BankListAdapter(mutableListOf()) {
        startActivity(BankDetaileActivity.newInstance(this@MainActivity, it))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        recyclerBank.adapter = adapter
        getBankList()
    }

    private fun showLoading() {
        progress.visibility = View.VISIBLE
        recyclerBank.isEnabled = false
    }

    private fun hideLoading() {
        progress.visibility = View.GONE
        recyclerBank.isEnabled = true
    }

    private fun showMessage() {
        mainLayout.snack(getString(R.string.network_error), Snackbar.LENGTH_INDEFINITE) {
            action(getString(R.string.ok)) {
                getBankList()
            }
        }
    }

    private fun getBankList() {
        showLoading()
        mainViewModel.getBankList().observe(this, {
            hideLoading()
            if (it == null) {
                showMessage()
            } else {
                adapter.setBanks(it)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

}