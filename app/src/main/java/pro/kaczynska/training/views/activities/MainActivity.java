package pro.kaczynska.training.views.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import pro.kaczynska.training.R;
import pro.kaczynska.training.databinding.ActivityMainBinding;
import pro.kaczynska.training.viewModels.MainViewModel;


public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainViewModel mainViewModel = new MainViewModel(this);

        ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.setViewModel(mainViewModel);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.fragment_tabs);
        ViewPager viewPager = (ViewPager) findViewById(R.id.login_register_view_pager);
        tabLayout.setupWithViewPager(viewPager);
    }
}
