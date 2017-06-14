package pro.kaczynska.training.viewModels;

import android.arch.lifecycle.ViewModel;
import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableInt;
import android.view.View;
import android.widget.EditText;

import pro.kaczynska.training.ObservableString;
import pro.kaczynska.training.R;
import pro.kaczynska.training.strategy.EmailValidationStrategy;
import pro.kaczynska.training.strategy.PasswordValidationStrategy;
import pro.kaczynska.training.strategy.ValidateFieldStrategy;


public class LoginViewModel extends ViewModel {

    public FieldViewModel emailViewModel;
    public FieldViewModel passwordViewModel;
//    private ObservableInt textStyle = new ObservableInt(R.style.textinput_inprogress);


    public LoginViewModel() {
        init();
    }

    @BindingConversion
    public static String convertBindableToString(
            ObservableString observableString) {
        return observableString.get();
    }

    @BindingAdapter("onFocusChange")
    public static void setOnFocusChange(EditText editText,
                                        View.OnFocusChangeListener listener) {
        if (listener != null) {
            editText.setOnFocusChangeListener(listener);
        }
    }



    private void init() {
        ValidateFieldStrategy emailValidationStrategy = new EmailValidationStrategy();
        ValidateFieldStrategy passwordValidationStrategy = new PasswordValidationStrategy();
//        email.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
//            @Override
//            public void onPropertyChanged(Observable observable, int i) {
//                emailValidationStrategy.checkField(email, emailError);
//            }
//        });
//        password.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
//            @Override
//            public void onPropertyChanged(Observable observable, int i) {
//                passwordValidationStrategy.checkField(password, passwordError);
//            }
//        });
//
//        onFocusChange = new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if (hasFocus) {
//                    emailValidationStrategy.setCheckNotRequired(false);
//                    emailValidationStrategy.checkField(email, emailError);
//                }
//            }
//        };
        emailViewModel = new FieldViewModel(emailValidationStrategy);
        passwordViewModel = new FieldViewModel(passwordValidationStrategy);
    }
}
