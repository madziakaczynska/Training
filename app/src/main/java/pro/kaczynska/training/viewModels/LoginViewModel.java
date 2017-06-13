package pro.kaczynska.training.viewModels;

import android.arch.lifecycle.ViewModel;
import android.databinding.BindingConversion;
import android.databinding.Observable;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableInt;
import android.view.View;
import android.widget.EditText;

import pro.kaczynska.training.ObservableString;
import pro.kaczynska.training.R;
import pro.kaczynska.training.strategy.EmailValidationStrategy;
import pro.kaczynska.training.strategy.PasswordValidationStrategy;


public class LoginViewModel extends ViewModel {


    public ObservableString emailError = new ObservableString();
    public ObservableString passwordError = new ObservableString();
    public ObservableString email = new ObservableString();
    public ObservableString password = new ObservableString();
    private ObservableInt textStyle = new ObservableInt(R.style.textinput_inprogress);
    private ObservableBoolean errorEnabled = new ObservableBoolean(false);
    private EmailValidationStrategy emailValidationStrategy;
    private PasswordValidationStrategy passwordValidationStrategy;

    public LoginViewModel() {
        init();
    }

    @BindingConversion
    public static String convertBindableToString(
            ObservableString observableString) {
        return observableString.get();
    }

    public ObservableInt getTextStyle() {
        return textStyle;
    }

    public ObservableBoolean getErrorEnabled() {
        return errorEnabled;
    }

    private void init() {
        emailValidationStrategy = new EmailValidationStrategy();
        emailValidationStrategy.setCheckNotRequired(true);
        passwordValidationStrategy = new PasswordValidationStrategy();
        email.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                emailValidationStrategy.checkField(email, emailError);
            }
        });
        password.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                passwordValidationStrategy.checkField(password, passwordError);
            }
        });
    }

    public EditText.OnFocusChangeListener setOnFocusChanged() {
        return new EditText.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    emailValidationStrategy.setCheckNotRequired(false);
                    emailValidationStrategy.checkField(email, emailError);
                }
            }
        };
    }
}
