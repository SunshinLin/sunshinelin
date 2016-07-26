package zx.myapplication.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import zx.myapplication.R;

/**
 * Created by lin on 2016/7/26.
 */
public class page2 extends FrameLayout {
    public page2(Context context) {
        super(context);
        init();
    }

    public void init(){
        LayoutInflater.from(getContext()).inflate(R.layout.content_pager_2,this,true);
    }
}
