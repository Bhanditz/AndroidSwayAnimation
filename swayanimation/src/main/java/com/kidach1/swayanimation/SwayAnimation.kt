package com.kidach1.swayanimation

import android.content.Context
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.animation.*
import android.widget.ImageView
import android.widget.RelativeLayout

import java.util.*

/**
 * Created by daiki.taniguchi on 16/03/07.
 */
class SwayAnimation {

    companion object {
        private val SCALE_DURATION = 500L
        private val ALPHA_DURATION = 3000L
        private val ROTATE_DURATION = 750L
        private val TRANSLATE_DURATION = 2000L
        private val MIN_TRANSLATE_DURATION = 500L
        private val SCALE_RATE = 0.7f
        private val ADJUST_TOUCH_POINT_FOR_LEFT_MARGIN = 120
        private val ADJUST_TOUCH_POINT_FOR_TOP_MARGIN = 120
        private val ROTATE_RAND_SEED = 60
        private val FOR_MINUS_ROTATE = -30
        private val TRANSLATE_TO_X_DELTA_RAND_SEED = 200
        private val TRANSLATETO_Y_DELTA_RAND_SEED = 1200

        var drawables = Arrays.asList(
                R.drawable.flower_pink, R.drawable.star_blue, R.drawable.heart_pink,
                R.drawable.star_yellow, R.drawable.music, R.drawable.star_orange)
            @JvmStatic set(drawables) {
                field = drawables
            }

        var actionBarHeight = 168
            @JvmStatic set(actionBarHeight) {
                field = actionBarHeight
            }

        var withActionBar: Boolean = false
            @JvmStatic set(withActionBar) {
                field = withActionBar
            }

        @JvmStatic fun ready(animatedZone: ViewGroup, touchedZone: View, mContext: Context) {
            touchedZone.setOnTouchListener { v, event ->
                val mAnimImage = ImageView(mContext)
                mAnimImage.setImageResource(getDrawable())
                mAnimImage.layoutParams = getLayoutParams(event)
                mAnimImage.startAnimation(getAnimSet(mAnimImage))
                animatedZone.addView(mAnimImage)
                false
            }
        }

        private fun getDrawable(): Int {
            return drawables[Random().nextInt(drawables.size)]
        }

        private fun getLayoutParams(event: MotionEvent): RelativeLayout.LayoutParams {
            val layoutParams = RelativeLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            layoutParams.leftMargin = event.rawX.toInt() - ADJUST_TOUCH_POINT_FOR_LEFT_MARGIN
            val adjustY = if (withActionBar) ADJUST_TOUCH_POINT_FOR_TOP_MARGIN + actionBarHeight else ADJUST_TOUCH_POINT_FOR_TOP_MARGIN
            layoutParams.topMargin = event.rawY.toInt() - adjustY
            return layoutParams
        }

        private fun getAnimSet(mAnimImage: ImageView): AnimationSet {
            val animSet = AnimationSet(true)
            animSet.addAnimation(getScaleAnim())
            animSet.addAnimation(getRotateAnim())
            animSet.addAnimation(getTranslateAnim(mAnimImage))
            animSet.addAnimation(getAlphaAnim())
            return animSet
        }

        private fun getTranslateAnim(mAnimImage: ImageView): TranslateAnimation {
            val randTranslateToXDeltaVal = Math.random().toFloat() * TRANSLATE_TO_X_DELTA_RAND_SEED
            val randTranslateToYDeltaVal = Math.random().toFloat() * TRANSLATETO_Y_DELTA_RAND_SEED
            val translate = TranslateAnimation(
                    0.0f,
                    randTranslateToXDeltaVal,
                    0.0f,
                    -(randTranslateToYDeltaVal + MIN_TRANSLATE_DURATION))
            translate.duration = TRANSLATE_DURATION
            translate.fillAfter = true
            translate.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation) {
                }

                override fun onAnimationEnd(animation: Animation) {
                    mAnimImage.visibility = View.GONE
                }

                override fun onAnimationRepeat(animation: Animation) {
                }
            })
            return translate
        }

        private fun getRotateAnim(): RotateAnimation {
            val randRotateVal = Math.random().toFloat() * ROTATE_RAND_SEED
            val rotate = RotateAnimation(
                    0.0f,
                    randRotateVal + FOR_MINUS_ROTATE)
            rotate.duration = ROTATE_DURATION
            return rotate
        }

        private fun getAlphaAnim(): AlphaAnimation {
            val alpha = AlphaAnimation(1.0f, 0.0f)
            alpha.duration = ALPHA_DURATION
            return alpha
        }

        private fun getScaleAnim(): ScaleAnimation {
            val scale = ScaleAnimation(
                    0.0f,
                    SCALE_RATE,
                    0.0f,
                    SCALE_RATE,
                    Animation.RELATIVE_TO_SELF,
                    0.5f,
                    Animation.RELATIVE_TO_SELF,
                    0.5f)
            scale.duration = SCALE_DURATION
            return scale
        }
    }

}
