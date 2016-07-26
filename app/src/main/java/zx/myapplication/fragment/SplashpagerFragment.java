package zx.myapplication.fragment;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.YoYo;

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
    //页面滑动监听
    private ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        ArgbEvaluator argbEvaluator = new ArgbEvaluator();//该函数返回计算在中间的彩色定的整数，代表在四个字节的32位int的开始值和结束值的值

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
             //通过判断页面的偏移量来改变颜色（偏移量,改变之前颜色,改变之后的颜色）
            if (position == 0) {
                int color = (int) argbEvaluator.evaluate(positionOffset, colorGreen, colorRed);//通过偏移量修改颜色的方法
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
    //页面滑动动画加载
    private ViewPager.OnPageChangeListener phoneChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
           if(position==0){
               //计算偏移量来修改layoutphone的大小，0.3为初始大小
               float scale=0.3f +positionOffset*0.7f;
               //x，y轴进行同时变化
               layoutPhone.setScaleX(scale);
               layoutPhone.setScaleY(scale);
               //疑问
               int scroll=(int)((positionOffset-0.7)*360);
               layoutPhone.setTranslationX(scroll);
               ivPhoneFont.setAlpha(positionOffset);
               return;
           }
            if(position==1){
                //疑问
                layoutPhone.setTranslationX(-positionOffsetPixels);
            }
        }

        @Override
        public void onPageSelected(int position) {
             if(position==2){
                 //判断如果为最后一个页面则获得pg2添加动画，动画写在page中
                 page2 p2= (page2) splashadapter.getView(position);
                 p2.showAnimation();
             }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


}
