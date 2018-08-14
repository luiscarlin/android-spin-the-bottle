package com.luchoc.spinthebottle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private float fromDegrees = 0;
    private Random random = new Random();
    private ImageView bottle;
    private boolean spinning = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottle = findViewById(R.id.bottle);
    }

    public void spinBottle(View view) {

        if (!spinning) {
            float pivotX = bottle.getWidth() / 2;
            float pivotY = bottle.getHeight() / 2;

            float toDegrees = random.nextFloat() * 5 * 365;


            Animation rotate = new RotateAnimation(fromDegrees, toDegrees, pivotX, pivotY);
            rotate.setDuration(2000);
            rotate.setFillAfter(true);
            rotate.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    spinning = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    spinning = false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

            fromDegrees = toDegrees;

            bottle.startAnimation(rotate);

        }
    }
}
