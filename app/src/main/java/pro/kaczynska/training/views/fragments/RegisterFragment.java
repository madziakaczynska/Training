package pro.kaczynska.training.views.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pro.kaczynska.training.R;
import pro.kaczynska.training.databinding.FragmentRegisterBinding;
import pro.kaczynska.training.viewModels.RegisterViewModel;

/**
 * Created by mky on 09.06.2017.
 */

public class RegisterFragment extends Fragment {

    FragmentRegisterBinding registerBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        registerBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false);
        RegisterViewModel registerViewModel = new RegisterViewModel();
        registerBinding.setRegisterViewModel(registerViewModel);
        return registerBinding.getRoot();
    }
}
