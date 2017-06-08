package pro.kaczynska.training;

import javax.inject.Inject;

/**
 * Created by mky on 07.06.2017.
 */

public abstract class ValidateFieldStrategy {

    @Inject private ErrorMessage errorMessage;

    public ValidateFieldStrategy(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void checkField(ObservableString field, ObservableString error) {
        String errorText = null;
        if (!isFieldFilled(field)) {
            errorText = errorMessage.FIELD_REQUIRED;
        } else if (!isValueValid(field)) {
            errorText = errorMessage.FIELD_INVALID;
        }
        error.set(errorText);
    }

    abstract boolean isFieldFilled(ObservableString field);

    abstract boolean isValueValid(ObservableString field);
}
