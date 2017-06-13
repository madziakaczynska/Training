package pro.kaczynska.training.strategy;

import pro.kaczynska.training.ObservableString;

/**
 * Created by mky on 07.06.2017.
 */

public class PasswordValidationStrategy extends ValidateFieldStrategy {

    @Override
    String getFieldRequiredMessage() {
        return errorMessage.PASSWORD_TOO_SHORT;
    }

    @Override
    String getInvalidFieldMessage() {
        return errorMessage.PASSWORD_INVALID;
    }

    @Override
    boolean isFieldFilled(ObservableString field) {
        return field.get().length() > 5;
    }

    @Override
    boolean isValueValid(ObservableString field) {
        return true;
    }
}
