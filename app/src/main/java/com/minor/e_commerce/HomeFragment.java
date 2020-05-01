package com.minor.e_commerce;


import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    /////Banner slider
    private ViewPager bannerSliderViewPager;
    private List<SliderModel> sliderModelList;
    private int currentPage =2;
    private Timer timer;
    final private  long DELAY_TIME =2000;
    final private  long PERIOD_TIME = 2000;


    ////Banner slider


    //////Horizontal layout
    private TextView horizontalayoutTitle;
    private Button viewAllBtn;
    private RecyclerView horizontalRecyclerView;



    /////Horizontal layout

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //////Banner slider
        bannerSliderViewPager = view.findViewById(R.id.banner_slider_view_pager);

        sliderModelList = new ArrayList<>();

        sliderModelList.add(new SliderModel(R.drawable.banner_1));
        sliderModelList.add(new SliderModel(R.drawable.pic_2));


        sliderModelList.add(new SliderModel(R.drawable.pic_5));
        sliderModelList.add(new SliderModel(R.drawable.pic_1));
        sliderModelList.add(new SliderModel(R.drawable.pic_2));
        sliderModelList.add(new SliderModel(R.drawable.pic_3));
        sliderModelList.add(new SliderModel(R.drawable.pic_4));
        sliderModelList.add(new SliderModel(R.drawable.pic_6));
        sliderModelList.add(new SliderModel(R.drawable.pic_7));
        sliderModelList.add(new SliderModel(R.drawable.pic_8));

        sliderModelList.add(new SliderModel(R.drawable.pic_5));
        sliderModelList.add(new SliderModel(R.drawable.pic_1));


        SliderAdapter sliderAdapter = new SliderAdapter(sliderModelList);
        bannerSliderViewPager.setAdapter(sliderAdapter);
        bannerSliderViewPager.setClipToPadding(false);
        bannerSliderViewPager.setPageMargin(20);

        ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
               currentPage = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

                if (state == ViewPager.SCROLL_STATE_IDLE){
                    pageLooper();
                }
            }
        };
        bannerSliderViewPager.addOnPageChangeListener(onPageChangeListener);

        startbannerSlideShow();

        bannerSliderViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                pageLooper();
                stopbannerSlideshow();
                if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    stopbannerSlideshow();
                }
                return false;
            }
        });

        /////Banner slider


        ///Horizontal product layout
       horizontalayoutTitle = view.findViewById(R.id.horizont_scroll_layout_title_1);
       viewAllBtn = view.findViewById(R.id.horizont_scroll_layout_button_1);
       horizontalRecyclerView = view.findViewById(R.id.horizont_scroll_layout_recyclerView_1);

       List<HorizontProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();
       horizontalProductScrollModelList.add(new HorizontProductScrollModel(R.drawable.veg_1,"Onion[2 kg]","20% off","Rs 48"));

        horizontalProductScrollModelList.add(new HorizontProductScrollModel(R.drawable.veg_2,"Tomato","20% off","Rs 50"));

        horizontalProductScrollModelList.add(new HorizontProductScrollModel(R.drawable.veg_3_cauliflower,"cauliflower[2 kg]","20% of ","Rs 45"));

        horizontalProductScrollModelList.add(new HorizontProductScrollModel(R.drawable.veg_4,"Bhindi[2 kg]","20%fof","Rs 70"));

        horizontalProductScrollModelList.add(new HorizontProductScrollModel(R.drawable.veg_4_lauki,"Lauki[2 kg]","20% off","Rs 48"));

        horizontalProductScrollModelList.add(new HorizontProductScrollModel(R.drawable.veg_4_potato,"Potato[2 kg]","20% off ","Rs 40"));

        horizontalProductScrollModelList.add(new HorizontProductScrollModel(R.drawable.veg_1,"Onion","20%fof","Rs 48"));

        horizontalProductScrollModelList.add(new HorizontProductScrollModel(R.drawable.veg_1,"Onion","20%fof","Rs 48"));


        HorizontalProductScrollAdapter horizontalProductScrollAdapter = new HorizontalProductScrollAdapter(horizontalProductScrollModelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        horizontalRecyclerView.setLayoutManager(linearLayoutManager);

        horizontalRecyclerView.setAdapter(horizontalProductScrollAdapter);
        horizontalProductScrollAdapter.notifyDataSetChanged();



        ///horizont product layout

      return view;
    }

    //////Banner slider
    private  void pageLooper(){
        if (currentPage == sliderModelList.size() - 2){
            currentPage = 2;
            bannerSliderViewPager.setCurrentItem(currentPage,false);
        }
        if(currentPage ==1){
            currentPage = sliderModelList.size() - 3;
            bannerSliderViewPager.setCurrentItem(currentPage,false);
        }
    }
    private  void startbannerSlideShow(){
        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if(currentPage >= sliderModelList.size()){
                    currentPage =1;
                }
                bannerSliderViewPager.setCurrentItem(currentPage++,true);

            }
        };
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        },DELAY_TIME,PERIOD_TIME);
    }
    private  void stopbannerSlideshow(){
        timer.cancel();
    }

    ////Banner slider

}
