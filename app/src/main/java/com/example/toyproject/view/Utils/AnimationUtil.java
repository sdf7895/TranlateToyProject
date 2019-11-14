package com.example.toyproject.view.Utils;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

public class AnimationUtil {

    public static AlphaAnimation AlpahAnimationutil(){
        AlphaAnimation animation = new AlphaAnimation(0,1);
        animation.setDuration(500);
        animation.setRepeatMode(Animation.REVERSE);

        return animation;
    }
}
