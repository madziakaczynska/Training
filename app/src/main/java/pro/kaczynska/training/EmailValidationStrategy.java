package pro.kaczynska.training;

import android.databinding.ObservableField;
import android.util.Patterns;

import java.util.regex.Pattern;

/**
 * Created by mky on 07.06.2017.
 */

public class EmailValidationStrategy extends ValidateFieldStrategy {

    public EmailValidationStrategy(ErrorMessage errorMessage) {
        super(errorMessage);
    }

    @Override
    boolean isFieldFilled(ObservableField<String> field) {
        return !field.get().isEmpty();
    }

    @Override
    boolean isValueValid(ObservableField<String> field) {
        Pattern fieldPattern = Patterns.EMAIL_ADDRESS;
        return fieldPattern.matcher(field.get()).matches();
    }


//
//    @Override
//    public boolean isValueValid() {
//        Pattern fieldPattern = Patterns.EMAIL_ADDRESS;
//        return fieldPattern.matcher(field.get()).matches();
//    }
//
//    @Override
//    public boolean isFieldFilled() {
//        return !field.isEmpty();
//    }
}
