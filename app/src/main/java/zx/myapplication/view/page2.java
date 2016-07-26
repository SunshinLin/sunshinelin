package zx.myapplication.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import butterknife.Bind;
import butterknife.ButterKnife;
import zx.myapplication.R;

/**
 * Created by lin on 2016/7/26.
 */
public class page2 extends FrameLayout {
    @Bind(R.id.ivBubble1)
    ImageView ivBubble1;
    @Bind(R.id.ivBubble2)
    ImageView ivBubble2;
    @Bind(R.id.ivBubble3)
    ImageView ivBubble3;
    @Bind(R.id.tvTitle)
    TextView tvTitle;
    @Bind(R.id.tvIntroduction)
    TextView tvIntroduction;

    public page2(Context context) {
        super(context);
        init();
    }

    public void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.content_pager_2, this, true);
        ButterKnife.bind(this);
        ivBubble1.setVisibility(View.GONE);
        ivBubble2.setVisibility(View.GONE);
        ivBubble3.setVisibility(View.GONE);
    }

    /** 用来显示当前页面内三张图像的进入动画，只显示一次*/
    public void showAnimation(){
        if(ivBubble1.getVisibility() != View.VISIBLE){
            //post线程，通过设置休眠时间的不同达到，动画的层次播放
            postDelayed(new Runnable() {
                @Override public void run() {
                    ivBubble1.setVisibility(View.VISIBLE);
                    YoYo.with(Techniques.FadeInLeft).duration(300).playOn(ivBubble1);
                }
            }, 50);
            postDelayed(new Runnable() {
                @Override public void run() {
                    ivBubble2.setVisibility(View.VISIBLE);
                    YoYo.with(Techniques.FadeInLeft).duration(300).playOn(ivBubble2);
                    //yoyo导入方法，类容参考xml，动画；
                }
            }, 550);
            postDelayed(new Runnable() {
                @Override public void run() {
                    ivBubble3.setVisibility(View.VISIBLE);
                    YoYo.with(Techniques.FadeInLeft).duration(300).playOn(ivBubble3);
                }
            }, 1050);
        }
    }

}
