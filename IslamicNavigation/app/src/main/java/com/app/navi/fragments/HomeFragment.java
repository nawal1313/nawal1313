package com.app.navi.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.app.navi.R;
import com.app.navi.databinding.FragmentHomeBinding;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initComponent();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater, container, false);



        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    private void initComponent() {
        initSlider();


       /* R.drawable.splash0, R.drawable.splash1, R.drawable.splash2,
                R.drawable.splash3, R.drawable.splash4, R.drawable.splash5,
                R.drawable.splash6, R.drawable.splash7, R.drawable.splash8,
                R.drawable.splash9, R.drawable.splash10, R.drawable.splash11,
                R.drawable.splash12*/


    }

    private void initSlider() {

        ImageCarousel carousel = binding.carousel;
        carousel.registerLifecycle(getLifecycle());
        List<CarouselItem> list = new ArrayList<>();
        list.add(
                new CarouselItem(
                        R.drawable.splash0,
                        ""
                )
        );

        list.add(
                new CarouselItem(
                        R.drawable.splash1,
                        ""
                )
        );
        list.add(
                new CarouselItem(
                        R.drawable.splash2,
                        ""
                )
        );
        list.add(
                new CarouselItem(
                        R.drawable.splash3,
                        ""
                )
        );
        list.add(
                new CarouselItem(
                        R.drawable.splash4,
                        ""
                )
        );
        list.add(
                new CarouselItem(
                        R.drawable.splash5,
                        ""
                )
        );
        list.add(
                new CarouselItem(
                        R.drawable.splash6,
                        ""
                )
        );
        list.add(
                new CarouselItem(
                        R.drawable.splash7,
                        ""
                )
        );

        carousel.setData(list);
    }}