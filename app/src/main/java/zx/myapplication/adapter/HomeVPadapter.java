package zx.myapplication.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by lin on 2016/7/27.
 */
public class HomeVPadapter extends FragmentPagerAdapter {
    List<String> titleList;
    List<Fragment> list;

    public HomeVPadapter(FragmentManager fm, List<String> titleList, List<Fragment> list) {
        super(fm);
        this.titleList = titleList;
        this.list = list;
    }


    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}
