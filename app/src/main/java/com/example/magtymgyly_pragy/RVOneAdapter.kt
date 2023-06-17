package com.example.magtymgyly_pragy

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RVOneAdapter    // Parameterized constructor of this class to initialize tutorialList
    ( // Main-list item titles will be stored here
    private val gosgyList: ArrayList<RVOneModel>
) :
    RecyclerView.Adapter<RVOneAdapter.ViewHolder>() {
    // Need this clickListener for the Main-list item onClick events
    private var listener: OnItemsClickListener? = null
    private var onClickListener: OnClickListener? = null


    // Main-list item clickListener is initialized
    // This will be used in MainActivity
    fun setWhenClickListener(listener: OnItemsClickListener?) {
        this.listener = listener
    }

    // Attach the item layout with the proper xml file
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_design, parent, false)
        return ViewHolder(view)
    }

    // It deals with the setting of different data and methods
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val modelItems = gosgyList[position]

        holder.setData(gosgyList[position].name)
        holder.Image.setImageResource(modelItems.image)
        holder.singleItemCardView.setOnClickListener {
            if (listener != null) {
                listener!!.onItemClick(position)
            }
        }

        holder.itemView.setOnClickListener {
            if (onClickListener != null) {
                onClickListener!!.onClick(position, modelItems )
            }
        }

    }

    // It returns the length of the RecyclerView
    override fun getItemCount(): Int {
        return gosgyList.size
    }



    // The ViewHolder is a java class that stores
    // the reference to the item layout views
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var singleItemCardView: LinearLayout
        var singleItemTextView: TextView
        val Image : ImageView
       // val title : TextView = itemView.findViewById(R.id.singleItemTextView)

        // Link up the Main-List items layout components with their respective id
        init {
            Image = itemView.findViewById(R.id.imageView)
            singleItemCardView = itemView.findViewById(R.id.singleItemCardView)
            singleItemTextView = itemView.findViewById(R.id.singleItemTextView)
        }

        // setText in Main-List title text
        fun setData(name: String?) {
            singleItemTextView.text = name
        }

    }

    // Interface to perform events on Main-List item click
    interface OnItemsClickListener {
        fun onItemClick(position: Int)
    }
    // onClickListener Interface
    interface OnClickListener {
        fun onClick(position: Int, model: RVOneModel)
    }
    var onItemClick: (Int) -> Unit = {}

}
