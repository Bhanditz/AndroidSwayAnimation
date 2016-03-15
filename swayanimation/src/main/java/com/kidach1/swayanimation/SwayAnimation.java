package com.kidach1.swayanimation;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.*;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.*;

/**
 * Created by daiki.taniguchi on 16/03/07.
 */
public class SwayAnimation {

    private static Long SCALE_DURATION = 500L;
    private static Long ALPHA_DURATION = 3000L;
    private static Long ROTATE_DURATION = 750L;
    private static Long TRANSLATE_DURATION = 2300L;
    private static Long MIN_TRANSLATE_DURATION = 500L;
    private static Float SCALE_RATE = 0.7f;
    private static int ROTATE_RAND_SEED = 60;
    private static int FOR_MINUS_ROTATE = -30;
    private static int TRANSLATE_TO_X_DELTA_RAND_SEED = 200;
    private static int TRANSLATETO_Y_DELTA_RAND_SEED = 1200;
    private static Float ADJUST_TOUCH_POINT_FOR_LEFT_MARGIN = 120f;
    private static Float ADJUST_TOUCH_POINT_FOR_TOP_MARGIN = 120f;
    private static List<Integer> drawables = Arrays.asList(
            R.drawable.flower_pink, R.drawable.star_blue, R.drawable.heart_pink,
            R.drawable.star_yellow, R.drawable.music, R.drawable.star_orange
    );

    public static void setDrawables(List<Integer> ds) {
        drawables = ds;
    }

    public static void set(final ViewGroup addedLayout, View touchedView, final Context mContext) {
        touchedView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ImageView mAnimImage = new ImageView(mContext);
                mAnimImage.setImageResource(getDrawable());
                mAnimImage.setLayoutParams(getLayoutParams(event));
                mAnimImage.startAnimation(getAnimSet(mAnimImage));
                addedLayout.addView(mAnimImage);
                return false;
            }
        });
    }

    private static int getDrawable() {
        return drawables.get(new Random().nextInt(drawables.size()));
    }

    private static RelativeLayout.LayoutParams getLayoutParams(MotionEvent event) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.leftMargin = ((int) (event.getRawX() - ADJUST_TOUCH_POINT_FOR_LEFT_MARGIN));
        layoutParams.topMargin = ((int) (event.getRawY() - ADJUST_TOUCH_POINT_FOR_TOP_MARGIN));
        return layoutParams;
    }

    private static AnimationSet getAnimSet(ImageView mAnimImage) {
        AnimationSet animSet = new AnimationSet(true);
        animSet.addAnimation(getScaleAnim());
        animSet.addAnimation(getRotateAnim());
        animSet.addAnimation(getTranslateAnim(mAnimImage));
        animSet.addAnimation(getAlphaAnim());
        return animSet;
    }

    private static TranslateAnimation getTranslateAnim(final ImageView mAnimImage) {
        Float randTranslateToXDeltaVal = (float) Math.random() * TRANSLATE_TO_X_DELTA_RAND_SEED;
        Float randTranslateToYDeltaVal = (float) Math.random() * TRANSLATETO_Y_DELTA_RAND_SEED;
        TranslateAnimation translate = new TranslateAnimation(
                0.0f,
                randTranslateToXDeltaVal,
                0.0f,
                -(randTranslateToYDeltaVal + MIN_TRANSLATE_DURATION)
        );
        translate.setDuration(TRANSLATE_DURATION);
        translate.setFillAfter(true);
        translate.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mAnimImage.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        return translate;
    }

    private static RotateAnimation getRotateAnim() {
        Float randRotateVal = (float) Math.random() * ROTATE_RAND_SEED;
        RotateAnimation rotate = new RotateAnimation(
                0.0f,
                randRotateVal + FOR_MINUS_ROTATE
        );
        rotate.setDuration(ROTATE_DURATION);
        return rotate;
    }

    private static AlphaAnimation getAlphaAnim() {
        AlphaAnimation alpha = new AlphaAnimation(1.0f, 0.0f);
        alpha.setDuration(ALPHA_DURATION);
        return alpha;
    }

    private static ScaleAnimation getScaleAnim() {
        ScaleAnimation scale = new ScaleAnimation(
                0.0f,
                SCALE_RATE,
                0.0f,
                SCALE_RATE,
                Animation.RELATIVE_TO_SELF,
                0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f
        );
        scale.setDuration(SCALE_DURATION);
        return scale;
    }
}
