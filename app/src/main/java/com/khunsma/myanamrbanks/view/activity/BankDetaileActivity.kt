package com.khunsma.myanamrbanks.view.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import com.khunsma.myanamrbanks.R
import com.khunsma.myanamrbanks.data.model.Bank
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_bank_detail.*

class BankDetaileActivity : BaseActivity() {

    companion object {
        fun newInstance(context: Context, bank: Bank): Intent {
            val intent = Intent(context, BankDetaileActivity::class.java)
            intent.putExtra("bank", bank)
            return intent
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bank_detail)
        val bank = intent.getSerializableExtra("bank") as Bank
        if (bank.logoUrl != null)
            Picasso.get().load(bank.logoUrl).into(ivBankLogo)
        else {
            ivBankLogo.setImageDrawable(
                ResourcesCompat.getDrawable(
                    resources,
                    R.drawable.ic_bank_gray_24,
                    null
                )
            )
        }
        tvBankName.text = bank.name
        tvType.text = "Type: ${bank.type}"
        tvDescription.text = bank.description


    }
}