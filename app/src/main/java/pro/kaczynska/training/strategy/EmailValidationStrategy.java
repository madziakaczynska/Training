package pro.kaczynska.training.strategy;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Pattern;

import pro.kaczynska.training.ObservableString;

/**
 * Created by mky on 07.06.2017.
 */

public class EmailValidationStrategy extends ValidateFieldStrategy {

    @Override
    String getFieldRequiredMessage() {
        return errorMessage.EMAIL_EMPTY_FIELD;
    }

    @Override
    String getInvalidFieldMessage() {
        return errorMessage.EMAIL_INVALID;
    }

    @Override
    boolean isFieldFilled(ObservableString field) {
        return !field.get().isEmpty();
    }

    @Override
    boolean isValueValid(ObservableString field) {
        if (TextUtils.isEmpty(field.get())) {
            return true;
        }
        Pattern fieldPattern = Patterns.EMAIL_ADDRESS;
        return fieldPattern.matcher(field.get()).matches();
    }
}
