package zx.myapplication.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by lin on 2016/7/26.
 */
public class SplashAdapter extends PagerAdapter {
    List<View> list;
    Context context;

    public SplashAdapter(List<View> list, Context context) {
        this.list = list;
        this.context = context;
    }
   public View getView(int position){
       return list.get(position);
   }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return object==view;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view=list.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list.get(position));
    }
}
