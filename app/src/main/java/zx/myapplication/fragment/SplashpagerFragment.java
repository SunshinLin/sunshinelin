package zx.myapplication.fragment;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.BindColor;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;
import zx.myapplication.R;
import zx.myapplication.adapter.SplashAdapter;
import zx.myapplication.view.page0;
import zx.myapplication.view.page1;
import zx.myapplication.view.page2;

/**
 * Created by lin on 2016/7/26.
 */
public class SplashpagerFragment extends Fragment {
    @Bind(R.id.viewPager)
    ViewPager viewPager;
    @Bind(R.id.indicator)
    CircleIndicator indicator;
    @Bind(R.id.content)
    FrameLayout content;
    @BindColor(R.color.colorGreen)
    int colorGreen;
    @BindColor(R.color.colorRed)
    int colorRed;
    @BindColor(R.color.colorYellow)
    int colorYellow;
    List<View> list = new ArrayList<View>();
    SplashAdapter splashadapter;
    @Bind(R.id.ivPhoneBlank)
    ImageView ivPhoneBlank;
    @Bind(R.id.ivPhoneFont)
    ImageView ivPhoneFont;
    @Bind(R.id.layoutPhone)
    FrameLayout layoutPhone;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash_pager, container, false);
        ButterKnife.bind(this, view);
        setView();
        return view;
    }

    public void setView() {
        list.add(new page0(getContext()));
        list.add(new page1(getContext()));
        list.add(new page2(getContext()));
        splashadapter = new SplashAdapter(list, getContext());
        indicator.setViewPager(viewPager);
        viewPager.setAdapter(splashadapter);
        viewPager.addOnPageChangeListener(pageChangeListener);
        viewPager.addOnPageChangeListener(phoneChangeListener);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    private ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        ArgbEvaluator argbEvaluator = new ArgbEvaluator();

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            if (position == 0) {
                int color = (int) argbEvaluator.evaluate(positionOffset, colorGreen, colorRed);
                content.setBackgroundColor(color);
                return;
            }
            if (position == 1) {
                int color = (int) argbEvaluator.evaluate(positionOffset, colorRed, colorYellow);
                content.setBackgroundColor(color);
            }

        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
    private ViewPager.OnPageChangeListener phoneChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
           if(position==0){
               float scale=0.3f +positionOffset*0.7f;
               layoutPhone.setScaleX(scale);
               layoutPhone.setScaleY(scale);
               int scroll=(int)((positionOffset-0.7)*360);
               layoutPhone.setTranslationX(scroll);
               ivPhoneFont.setAlpha(positionOffset);
               return;
           }
            if(position==1){
                layoutPhone.setTranslationX(-positionOffsetPixels);
            }
        }

        @Override
        public void onPageSelected(int position) {
             if(position==2){
                 page2 p2= (page2) splashadapter.getView(position);
             }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
