package pro.kaczynska.training.viewModels;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.res.Resources;
import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.databinding.Observable;
import android.databinding.ObservableField;
import android.support.design.widget.TextInputLayout;
import android.widget.EditText;

import pro.kaczynska.training.EmailValidationStrategy;
import pro.kaczynska.training.ErrorMessage;
import pro.kaczynska.training.ObservableString;
import pro.kaczynska.training.PasswordValidationStrategy;
import pro.kaczynska.training.R;
import pro.kaczynska.training.ValidateFieldStrategy;
import pro.kaczynska.training.views.FieldObservable;


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

        EmailValidationStrategy emailValidationStrategy = new EmailValidationStrategy(new ErrorMessage(errorEmailRequired, errorEmailInvalid));
        PasswordValidationStrategy passwordValidationStrategy = new PasswordValidationStrategy(new ErrorMessage(errorPasswordRequired, errorPasswordInvalid));
        addOnPropertyChangedCallback(email, emailError, emailValidationStrategy);
        addOnPropertyChangedCallback(password, passwordError, passwordValidationStrategy);
    }

    private void addOnPropertyChangedCallback(final ObservableString field, final ObservableString error, final ValidateFieldStrategy strategy) {
        field.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                strategy.checkField(field, error);
            }
        });
    }

    @BindingAdapter("app:error")
    public static void setError(TextInputLayout layout, ObservableString error){
        layout.setError(error.get());
    }
}
