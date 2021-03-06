package com.prongbang.animrv

import android.view.View
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import androidx.recyclerview.widget.RecyclerView
import java.util.*

/**
 * Created by prongbang on 2/15/2018 AD.
 */
class AnimatedRecyclerView {

	abstract class Adapter<T : RecyclerView.ViewHolder> : RecyclerView.Adapter<T>() {

		override fun getItemCount(): Int = 0

		protected var mLastPosition = -1

		override fun onBindViewHolder(holder: T, position: Int) {
			startAnimation(holder.itemView, position)
		}

		protected fun startAnimation(viewToAnimate: View, position: Int) {
			if (position > mLastPosition) {
				val anim = ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f,
						Animation.RELATIVE_TO_SELF, 0.5f)
				// make duration between [0, 600]
				anim.duration = Random().nextInt(600)
						.toLong()
				viewToAnimate.startAnimation(anim)
				mLastPosition = position
			}
		}

		protected fun restartAnimation() {
			mLastPosition = -1
		}

	}

}