package com.khunsma.myanamrbanks.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.khunsma.myanamrbanks.R
import com.khunsma.myanamrbanks.data.model.Bank
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_bank.view.*

class BankListAdapter(
  private val banks: MutableList<Bank>,
  private var listener: (Bank) -> Unit
) : RecyclerView.Adapter<BankListAdapter.BankHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BankHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_bank, parent, false)
        return BankHolder(view)
    }

    override fun getItemCount(): Int = banks.size

    override fun onBindViewHolder(holder: BankHolder, position: Int) =
        holder.bind(banks[position], position)

    fun setBanks(bankList: List<Bank>) {
        this.banks.clear()
        this.banks.addAll(bankList)
        notifyDataSetChanged()
    }

    inner class BankHolder(val view: View) : RecyclerView.ViewHolder(view) {
        @SuppressLint("SetTextI18n")
        fun bind(bank: Bank, position: Int) = with(view) {
            tvBankName.text = bank.name
            tvType.text = "Type : ${bank.type}"
            tvDateTime.text = bank.updated_at
            view.setOnClickListener {
                listener(banks[position])
            }
            if (bank.logoThumbnail != null)
                Picasso.get().load(bank.logoThumbnail).into(ivBankLogo)
            else {
                ivBankLogo.setImageDrawable(
                  ResourcesCompat.getDrawable(
                    resources,
                    R.drawable.ic_bank_gray_24,
                    null
                  )
                )
            }
        }
    }
}