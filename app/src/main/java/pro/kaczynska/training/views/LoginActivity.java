package pro.kaczynska.training.views;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import pro.kaczynska.training.R;
import pro.kaczynska.training.databinding.ActivityLoginBinding;
import pro.kaczynska.training.viewModels.LoginViewModel;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        ActivityLoginBinding loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        LoginViewModel loginViewModel = new LoginViewModel(this);
        loginBinding.setLoginViewModel(loginViewModel);
    }
}
