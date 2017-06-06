package pro.kaczynska.training.viewModels;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.databinding.BindingConversion;
import android.databinding.Observable;
import android.databinding.ObservableField;
import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Pattern;

import pro.kaczynska.training.ObservableString;
import pro.kaczynska.training.R;


public class LoginViewModel extends ViewModel {
    private final String ERROR_EMAIL;
    private final String ERROR_PASSWORD;
    private final String ERROR_FIELD_REQUIRED;
    private final String PASSWORD_PATTERN;
    public ObservableString email = new ObservableString();
    public ObservableString password = new ObservableString();
    public ObservableField<String> emailError = new ObservableField<>();
    public ObservableField<String> passwordError = new ObservableField<>();


    public LoginViewModel(Context context) {
        ERROR_EMAIL = context.getResources().getString(R.string.error_email);
        ERROR_PASSWORD = context.getResources().getString(R.string.error_password);
        ERROR_FIELD_REQUIRED = context.getResources().getString(R.string.error_empty_field);
        PASSWORD_PATTERN = context.getResources().getString(R.string.password_pattern);
        init();
    }

    @BindingConversion
    public static String convertBindableToString(
            ObservableString observableString) {
        return observableString.get();
    }

    private void init() {
        emailError.set(ERROR_FIELD_REQUIRED);
        addOnPropertyChangedCallback(email, emailError);
        addOnPropertyChangedCallback(password, passwordError);

    }

    private void addOnPropertyChangedCallback(final ObservableString observableString, final ObservableField<String> error) {
        observableString.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                checkField(observableString, error);
            }
        });
    }

    private boolean checkField(ObservableString field, ObservableField<String> error) {
        if (isFieldFilled(field.get())) {
            error.set(ERROR_FIELD_REQUIRED);
            return false;
        }
        if (!isValueValid(field)) {
            error.set(ERROR_EMAIL);
            return false;
        }
        error.set(null);
        return true;
    }

    private boolean isValueValid(ObservableString field) {
        boolean isPassword = (field == password);
        Pattern fieldPattern;
        if (isPassword) {
            fieldPattern = Pattern.compile(PASSWORD_PATTERN);
        } else {
            fieldPattern = Patterns.EMAIL_ADDRESS;
        }
        return fieldPattern.matcher(field.get()).matches();
    }

    private boolean isFieldFilled(String field) {
        return !TextUtils.isEmpty(field);
    }
}
