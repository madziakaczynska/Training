package pro.kaczynska.training.viewModels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import pro.kaczynska.training.R;
import pro.kaczynska.training.views.fragments.LoginFragment;
import pro.kaczynska.training.views.fragments.RegisterFragment;

/**
 * Created by mky on 12.06.2017.
 */

public class MainViewModel extends BaseObservable {
    @Bindable
    private ViewPagerAdapter pagerAdapter;


    public MainViewModel(FragmentActivity activity) {
        setUpPagerAdapter(activity);
    }

    @BindingAdapter("pagerAdapter")
    public static void setPagerAdapter(ViewPager viewPager, ViewPagerAdapter pagerAdapter) {
        viewPager.setAdapter(pagerAdapter);
    }

    public ViewPagerAdapter getPagerAdapter() {
        return pagerAdapter;
    }

    private void setUpPagerAdapter(FragmentActivity activity) {
        pagerAdapter = new ViewPagerAdapter(activity.getSupportFragmentManager());
        pagerAdapter.addFragment(new LoginFragment(), activity.getString(R.string.login_tab_title));
        pagerAdapter.addFragment(new RegisterFragment(), activity.getString(R.string.register_tab_title));
    }


    public class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
