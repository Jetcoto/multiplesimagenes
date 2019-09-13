package com.yoxman.unilibre.multiplesimagenes;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.squareup.picasso.Picasso;


import de.hdodenhof.circleimageview.CircleImageView;
//copy slider



import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import java.util.Timer;
import java.util.TimerTask;

import com.yoxman.unilibre.multiplesimagenes.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    //-------------------

    //---------------------

    //copy slider

    public ActivityMainBinding mBinding;
    ViewPager viewPager;
    LinearLayout sliderDots;
    public int dotCounts;
    public ImageView[] dots;
//
    CircleImageView perfil;
    ImageView like;
    boolean likee=false;
    int likes=0;
    TextView liketxt;
    LottieAnimationView animacionnn;
    int i=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //copy slider code

        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        viewPager=mBinding.viewPager;
        sliderDots=mBinding.SliderDots;


        ViewPageAdapter viewPageAdapter=new ViewPageAdapter(this);
        viewPager.setAdapter(viewPageAdapter);
        dotCounts=viewPageAdapter.getCount();
        dots = new ImageView[dotCounts];

        for(int i=0;i<dotCounts;i++){
            dots[i]=new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nonactive_dot));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8, 0, 8, 0);
            sliderDots.addView(dots[i], params);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for(int i = 0; i< dotCounts; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new myTimerTask(), 4000 ,4000);
        //FIN SLIDER CODE


       // String []idspublicacionesimagenes={"1","2","3","4","5","6"};
        ViewPager imagenn=(ViewPager) findViewById(R.id.viewPager);

      /*  perfil=(CircleImageView) findViewById(R.id.post_profile_image);
        Picasso.get().load("http://52.14.140.160/noctus_app/users/"+1+"/foto_perfil.jpg").placeholder(R.drawable.loading3r).error(R.drawable.sinconexion).into(perfil);
*/
       like = (ImageView) findViewById(R.id.likeic);
       liketxt = (TextView) findViewById(R.id.txtlikes);
       animacionnn = (LottieAnimationView) findViewById(R.id.animation_view);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        imagenn.getLayoutParams().height = (width);
        animacionnn.getLayoutParams().height = (width);
        if(likee){
            like.setImageDrawable(getResources().getDrawable(R.drawable.star2));
        }else{
            like.setImageDrawable(getResources().getDrawable(R.drawable.star1));
        }
        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(likee){
                    likee=false;
                    likes=0;
                    //ejecutamos dislike
                }else{
                    likee=false;
                    likes=1;
                    //ejecutamos like
                }
                if(likee){
                    like.setImageDrawable(getResources().getDrawable(R.drawable.star2));
                }else{
                    like.setImageDrawable(getResources().getDrawable(R.drawable.star1));
                }
                if(likes>0){
                    liketxt.setVisibility(View.VISIBLE);
                    liketxt.setText(likes+" Me gusta");
                }else{
                    liketxt.setVisibility(View.GONE);
                }
            }
        });
        imagenn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                Handler handler = new Handler();
                Runnable run = new Runnable() {
                    @Override
                    public void run() {
                        i = 0;
                    }
                };
                if(i==1){
                    handler.postDelayed(run,400);
                }else{
                    if(i==2){
                        animacionnn.setVisibility(View.VISIBLE);
                        if(likee){
                            animacionnn.playAnimation();
                        }else{
                            likee=true;
                            likes=1;
                            animacionnn.playAnimation();
                            //ejecutamos like
                        }
                        if(likee){
                            like.setImageDrawable(getResources().getDrawable(R.drawable.star2));
                        }else{
                            like.setImageDrawable(getResources().getDrawable(R.drawable.star1));
                        }
                        if(likes>0){
                            liketxt.setVisibility(View.VISIBLE);
                            liketxt.setText(likes+" Me gusta");
                        }else{
                            liketxt.setVisibility(View.GONE);
                        }
                    }
                }
            }
        });
        animacionnn.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Log.e("Animation:","start");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.e("Animation:","end");
                animacionnn.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Log.e("Animation:","cancel");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.e("Animation:","repeat");
            }
        });

    }
    //--------------

    //---------------


    //copy slider

    //------



    //---------

    public class myTimerTask extends TimerTask {
        @Override
        public void run() {

            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if(viewPager.getCurrentItem() == 0){
                        viewPager.setCurrentItem(1);
                    } else if(viewPager.getCurrentItem() == 1){
                        viewPager.setCurrentItem(2);
                    } else
                    {
                        viewPager.setCurrentItem(0);
                    }

                }
            });
        }
    }

}
