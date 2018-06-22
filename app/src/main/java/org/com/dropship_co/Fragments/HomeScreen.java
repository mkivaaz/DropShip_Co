package org.com.dropship_co.Fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.com.dropship_co.Adapter.BannerAdapter;
import org.com.dropship_co.Data.Banner;
import org.com.dropship_co.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeScreen extends Fragment {

    ViewPager bannerPager;
    TabLayout bannerTab;
    RecyclerView categ_recycler, prod_recycler;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_screen,container,false);

        iniateItems(view);

        return view;
    }

    private void iniateItems(View view) {
        bannerPager = view.findViewById(R.id.bannerPager);
        bannerTab = view.findViewById(R.id.bannerTabs);
        categ_recycler = view.findViewById(R.id.categoryRecycler);
        prod_recycler = view.findViewById(R.id.prodRecycler);

        addPromo(bannerPager);
    }

    private void addPromo(ViewPager bannerPager) {
        List<Banner> bannerList = getBanners();
        BannerAdapter bannerAdapter = new BannerAdapter(getContext(),bannerList);
        bannerPager.setAdapter(bannerAdapter);
        bannerTab.setupWithViewPager(bannerPager,true);
        slideTimer(5000,bannerAdapter,bannerPager);
    }

    private List<Banner> getBanners() {
        List<Banner> bannerList = new ArrayList<>();
        bannerList.add(new Banner("Guess and Win", "http://www.google.com/", "https://c.76.my/UserImages/BannerCMS/186211030__23979.jpg"));
        bannerList.add(new Banner("Speacial Seasonal Offer", "http://www.123videomagic.com/SpecialOffers.asp", "http://www.123videomagic.com/images/new_offer_banner.jpg"));
        bannerList.add(new Banner("#MYCYBER Sale", "https://www.ecinsider.my/2016/06/10-tips-for-merchants-to-make-most-of-mycybersale.html", "https://3.bp.blogspot.com/-3zHJKDAJbL8/VxdPTfMDXVI/AAAAAAAAK2c/V1r-owgANLQ2YImbv086g7WUDpvkDraQgCLcB/s1600/%2523mycybersale-2015-deals-sample.jpg"));

        return bannerList;
    }

    private void  slideTimer(final int interval, final BannerAdapter adapter, final ViewPager viewPager){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                TimerMethod(adapter, viewPager);
            }

        }, interval, interval);
    }

    private void TimerMethod(BannerAdapter adapter, final ViewPager viewPager) {
        final int currentPos = viewPager.getCurrentItem();

        if (currentPos < adapter.getCount()){
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    viewPager.setCurrentItem(currentPos+1,true);
                }
            });

        }
    }

    private class SliderTimer extends TimerTask{
        private int delay;
        private int pagerIndex = -1;
        BannerAdapter adapter;
        ViewPager viewPager;
        public SliderTimer(int delay, BannerAdapter adapter, ViewPager viewPager) {
            this.delay = delay;
            this.adapter = adapter;
            this.viewPager = viewPager;
        }

        @Override
        public void run() {
            Handler h = new Handler();

            h.postDelayed(new Runnable() {
                @Override
                public void run() {
                    pagerIndex++;
                    if (pagerIndex >= adapter.getCount()){
                        pagerIndex = 0;
                    }
                    viewPager.setCurrentItem(pagerIndex);
                }
            },delay);
        }
    }
}
