package pro.kaczynska.training.views.fragments;

import android.arch.lifecycle.LifecycleFragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pro.kaczynska.training.R;
import pro.kaczynska.training.databinding.FragmentLoginBinding;
import pro.kaczynska.training.viewModels.LoginViewModel;

/**
 * Created by mky on 12.06.2017.
 */

public class LoginFragment extends LifecycleFragment {

    FragmentLoginBinding loginBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        loginBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);
        LoginViewModel loginViewModel = new LoginViewModel();
        loginBinding.setLoginViewModel(loginViewModel);
        return loginBinding.getRoot();
    }
}
