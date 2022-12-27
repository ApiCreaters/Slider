package com.example.slider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewFlipper flipper;
    ViewPager viewPager;
    ImageView back ,next;
    ArrayList<Integer> arrayList = new ArrayList<Integer>();
    int image[] ={R.drawable.a,R.drawable.b,R.drawable.a,R.drawable.b,R.drawable.a,R.drawable.b,R.drawable.a};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flipper = findViewById(R.id.flipper);
        viewPager = findViewById(R.id.viewPager);
        back = (ImageView) findViewById(R.id.left);
        next = (ImageView) findViewById(R.id.right);


        arrayList.add(R.drawable.a);
        arrayList.add(R.drawable.b);
        arrayList.add(R.drawable.a);
        arrayList.add(R.drawable.b);
        arrayList.add(R.drawable.a);
        arrayList.add(R.drawable.b);
        arrayList.add(R.drawable.a);
        arrayList.add(R.drawable.b);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(viewPager.getCurrentItem()==0){
                    back.setVisibility(View.GONE);
                }
                else {
                    back.setVisibility(View.VISIBLE);
                }

                if(viewPager.getCurrentItem()==arrayList.size()-1){
                    next.setVisibility(View.GONE);
                }else{
                    next.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(getItem(-1),true);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(getItem(+1),true);
            }
        });

        MyAdapter adapter = new MyAdapter(this,arrayList);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(1);

        for(int i=0; i<image.length; i++) {
            showImage(image[i]);
        }
    }

    private int getItem(int i){
        return viewPager.getCurrentItem()+i;
    }

    private void showImage(int img) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(img);
        flipper.addView(imageView);
        flipper.setFlipInterval(3000);
        flipper.setAutoStart(true);
        flipper.setInAnimation(this, android.R.anim.slide_out_right);
        flipper.setOutAnimation(this, android.R.anim.slide_out_right);

    }
}