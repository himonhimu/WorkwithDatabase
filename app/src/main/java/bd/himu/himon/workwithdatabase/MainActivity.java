package bd.himu.himon.workwithdatabase;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
        Button howTo, LetsStart;
    ViewPager viewPager;
    SwipeInstruction swipeInstruction;
    RelativeLayout howToLayout;
    static String Instructions[];

    int a =1;

    ImageView [] dots;
    int dotCounts;
    LinearLayout SlideDots;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        SlideDots = (LinearLayout)findViewById(R.id.DotsShow);
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        Instructions = getResources().getStringArray(R.array.Instructions);
        howTo = (Button)findViewById(R.id.HowTo);
        LetsStart = (Button)findViewById(R.id.LetsStart);
        howToLayout = (RelativeLayout)findViewById(R.id.HowToLayout);
        howToLayout.setVisibility(View.GONE);

        swipeInstruction = new SwipeInstruction(this);



        StartFunction();


    }

    public void creatDots(){
        for (int i=0;i<dotCounts;i++){
            dots[i]= new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nonactive_dot));
           LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
           params.setMargins(8,0,8,0);
           SlideDots.addView(dots[i],params);
        }
        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.active_dot));
    }
public void changeDots(){
       viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
           @Override
           public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

           }

           @Override
           public void onPageSelected(int position) {
               for (int i=0; i<dotCounts;i++){
                   dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nonactive_dot));
               }
               dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.active_dot));
           }

           @Override
           public void onPageScrollStateChanged(int state) {

           }
       });
}

public void StartFunction(){
        final ImageButton CloseB = (ImageButton)findViewById(R.id.imageButton);

        LetsStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent himon = new Intent(MainActivity.this, MainFunction.class);
                startActivity(himon);
            }
        });

        howTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Animation leftanim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.left);
                final Animation rightanim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.right);
                final Animation leftanimtwo = AnimationUtils.loadAnimation(MainActivity.this, R.anim.lefttwo);
                final Animation rightanimtwo = AnimationUtils.loadAnimation(MainActivity.this, R.anim.righttwo);

                if (!howToLayout.isShown()){
                    howToLayout.setVisibility(View.VISIBLE);
                    howToLayout.setAnimation(leftanim);


                }else {
                    howToLayout.setVisibility(View.GONE);
                    howToLayout.setAnimation(rightanim);
                    viewPager.removeView(view);
                }
                if (a==1){
                viewPager.setAdapter(swipeInstruction);
                dotCounts = Instructions.length;
                dots = new ImageView[dotCounts];
                creatDots();
                changeDots();
                a++;
                }
        CloseB.setOnClickListener(new View.OnClickListener() {
            final Animation rightanim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.right);
            @Override
            public void onClick(View view) {
                howToLayout.setVisibility(View.GONE);
                howToLayout.setAnimation(rightanim);
            }
        });


            }

        });


}

    @Override
    protected void onPause() {
        howToLayout.setVisibility(View.GONE);
        super.onPause();
    }
}