package com.aguas.myapplication.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.aguas.myapplication.R
import com.aguas.myapplication.databinding.ItemNasaBinding
import com.aguas.myapplication.ui.entities.NasaDataUI

class NasaAdapter(
    private val onClickItem: (NasaDataUI) -> Unit
) :
    RecyclerView.Adapter<NasaAdapter.NasaViewHolder>() {
    var itemList: List<NasaDataUI> = emptyList()


    class NasaViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = ItemNasaBinding.bind(view)

        fun render(
            data: NasaDataUI,
            onClickItem: (NasaDataUI) -> Unit
        ) {

            Log.d("Img", "img_src: ${data.img_src}")
            binding.imgNasa
                .load(data.img_src) {
//                .load("https://mars.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01000/opgs/edr/rcam/RRB_486265291EDR_F0481570RHAZ00323M_.JPG") {
                    placeholder(R.drawable.space_shuttle)
                }
            binding.txtEarthDate.text = data.earth_date
            binding.txtRover.text = data.rover
            binding.txtSol.text = data.sol.toString()


            itemView.setOnClickListener {
                onClickItem(data)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NasaViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NasaViewHolder(
            inflater.inflate(
                R.layout.item_nasa,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: NasaViewHolder, position: Int) {
        holder.render(
            itemList[position],
            onClickItem
        )
    }
}