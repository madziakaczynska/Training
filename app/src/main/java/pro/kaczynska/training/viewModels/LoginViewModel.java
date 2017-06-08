package pro.kaczynska.training.viewModels;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.res.Resources;
import android.databinding.BindingConversion;
import android.databinding.Observable;

import pro.kaczynska.training.EmailValidationStrategy;
import pro.kaczynska.training.ErrorMessage;
import pro.kaczynska.training.ObservableString;
import pro.kaczynska.training.PasswordValidationStrategy;
import pro.kaczynska.training.R;
import pro.kaczynska.training.ValidateFieldStrategy;


public class LoginViewModel extends ViewModel {
    public ObservableString emailError = new ObservableString();
    public ObservableString passwordError = new ObservableString();
    public ObservableString email = new ObservableString();
    public ObservableString password = new ObservableString();



    public LoginViewModel(Context context) {
        init(context.getResources());
    }

    private void init(Resources resources) {
        String errorEmailRequired = resources.getString(R.string.error_empty_field);
        String errorEmailInvalid = resources.getString(R.string.error_email);
        String errorPasswordRequired = resources.getString(R.string.error_empty_field);
        String errorPasswordInvalid = resources.getString(R.string.error_email);

        final EmailValidationStrategy emailValidationStrategy = new EmailValidationStrategy(new ErrorMessage(errorEmailRequired, errorEmailInvalid));
        PasswordValidationStrategy passwordValidationStrategy = new PasswordValidationStrategy(new ErrorMessage(errorPasswordRequired, errorPasswordInvalid));
        email.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                emailValidationStrategy.checkField(email, emailError);
            }
        });
//        addOnPropertyChangedCallback(email, emailError, emailValidationStrategy);
//        addOnPropertyChangedCallback(password, passwordError, passwordValidationStrategy);
    }

    @BindingConversion
    public static String convertBindableToString(
            ObservableString observableString) {
        return observableString.get();
    }

    private void addOnPropertyChangedCallback(final ObservableString field, final ObservableString error, final ValidateFieldStrategy strategy) {
        field.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                strategy.checkField(field, error);
            }
        });
    }

}
