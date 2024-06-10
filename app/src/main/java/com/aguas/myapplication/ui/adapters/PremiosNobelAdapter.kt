package com.aguas.myapplication.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aguas.myapplication.R
import com.aguas.myapplication.databinding.ItemNobelBinding
import com.aguas.myapplication.ui.entities.PremiosNobelDataUI

class PremiosNobelAdapter(
    private val onClickItem: (PremiosNobelDataUI) -> Unit
) :
    RecyclerView.Adapter<PremiosNobelAdapter.NobelViewHolder>() {
    var itemList: List<PremiosNobelDataUI> = emptyList()
    class NobelViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = ItemNobelBinding.bind(view)

        fun render(
            data: PremiosNobelDataUI,
            onClickItem: (PremiosNobelDataUI) -> Unit
        ) {

            binding.txtAwaryear.text = data.awardYear
            binding.txtPrizeAmount.text = data.prizeAmount.toString()

            itemView.setOnClickListener {
                onClickItem(data)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NobelViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NobelViewHolder(
            inflater.inflate(
                R.layout.item_nobel,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: NobelViewHolder, position: Int) {
        holder.render(
            itemList[position],
            onClickItem
        )
    }
}