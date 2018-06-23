package org.com.dropship_co.Fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.com.dropship_co.Adapter.BannerAdapter;
import org.com.dropship_co.Adapter.HomeCategoryAdapter;
import org.com.dropship_co.Data.Banner;
import org.com.dropship_co.Data.Category;
import org.com.dropship_co.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeScreen extends Fragment {

    ViewPager bannerPager;
    TabLayout bannerTab;
    RecyclerView categ_recycler, prod_recycler;
    Runnable runnable;

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
        loadCategRecycler(addPopCategory());
    }

    private void loadCategRecycler(List<Category> categories) {
        HomeCategoryAdapter adapter = new HomeCategoryAdapter(getContext(),categories);
        categ_recycler.setAdapter(adapter);
        categ_recycler.setLayoutManager(new GridLayoutManager(getContext(),2));
    }

    private List<Category> addPopCategory() {
        List<Category> dataList = new ArrayList<>();
        dataList.add(new Category("Shirts"));
        dataList.add(new Category("T-Shirts"));
        dataList.add(new Category("Pants"));
        dataList.add(new Category("Shoes"));
        dataList.add(new Category("Hats"));
        dataList.add(new Category("Watches"));

        return dataList;
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
        runnable = new Runnable() {
            @Override
            public void run() {
                new Runnable() {
                    @Override
                    public void run() {
                        viewPager.setCurrentItem(currentPos+1,true);
                    }
                };
            }
        };
        if (currentPos < adapter.getCount()){
            if (getActivity() ==  null){
                return;
            }else {
                getActivity().runOnUiThread(runnable);
            }

        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}
