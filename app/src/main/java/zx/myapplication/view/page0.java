package zx.myapplication.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import zx.myapplication.R;

/**
 * Created by lin on 2016/7/26.
 */
public class page0 extends FrameLayout {

    public page0(Context context) {
        super(context);
        init();
    }
    private void init(){
        LayoutInflater.from(getContext()).inflate(R.layout.content_pager_0,this,true);
    }
}
