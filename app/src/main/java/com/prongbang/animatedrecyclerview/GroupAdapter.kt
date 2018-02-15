package com.prongbang.animatedrecyclerview

import android.content.Context
import android.graphics.Color
import android.support.v4.content.ContextCompat
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.prongbang.widget.AnimatedRecyclerView

/**
 * Created by prongbang on 2/15/2018 AD.
 */
class GroupAdapter(private val context: Context) : AnimatedRecyclerView.Adapter<GroupAdapter.ViewHolder>() {

    private var onClickListener: OnClickListener? = null
    private var mGroups = ArrayList<String>()

    fun setData(mGroups: ArrayList<String>) {
        this.mGroups = mGroups
        this.restartAnimation()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder? {
        val v = LayoutInflater.from(context).inflate(R.layout.item_group, parent, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)

        holder.onBind(context, mGroups[position])
    }

    override fun getItemCount(): Int {
        return mGroups.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val view = itemView
        private val tvName = itemView.findViewById<AppCompatTextView>(R.id.tvName)

        fun onBind(context: Context, group: String) {
            tvName.text = group
            view.setOnClickListener {
                onClickListener?.onClick(it, group)
            }
            view.setBackgroundColor(generateColor())
        }
    }

    private fun generateColor(): Int {
        val red = (Math.random() * 200).toInt()
        val green = (Math.random() * 200).toInt()
        val blue = (Math.random() * 200).toInt()
        return Color.rgb(red, green, blue)
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    interface OnClickListener {
        fun onClick(v: View, group: String)
    }
}