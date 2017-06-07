package pro.kaczynska.training;

import android.databinding.ObservableField;

/**
 * Created by mky on 07.06.2017.
 */

public abstract class ValidateFieldStrategy {

    private ErrorMessage errorMessage;

    public ValidateFieldStrategy(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void checkField(ObservableString field, ObservableString error) {
        if (!isFieldFilled(field)) {
            error.set(errorMessage.FIELD_REQUIRED);
        } else if (!isValueValid(field)) {
            error.set(errorMessage.FIELD_INVALID);
        } else {
            error.set(null);
        }
    }

    abstract boolean isFieldFilled(ObservableString field);

    abstract boolean isValueValid(ObservableString field);
}
