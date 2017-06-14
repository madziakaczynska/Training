package pro.kaczynska.training.strategy;

import javax.inject.Inject;

import pro.kaczynska.training.ObservableString;
import pro.kaczynska.training.TrainingApplication;
import pro.kaczynska.training.views.ErrorMessage;


/**
 * Created by mky on 07.06.2017.
 */

public abstract class ValidateFieldStrategy {

    @Inject
    ErrorMessage errorMessage;


    public ValidateFieldStrategy() {
        TrainingApplication.getInstance().getComponent().inject(this);
    }

    public boolean checkField(ObservableString field, ObservableString error) {
        String errorText = null;
        boolean isFieldValid = true;
        if (!isFieldFilled(field)) {
            errorText = getFieldRequiredMessage();
            isFieldValid = false;
        } else if (!isValueValid(field)) {
            errorText = getInvalidFieldMessage();
            isFieldValid = false;
        }
        error.set(errorText);
        return isFieldValid;
    }

    abstract String getFieldRequiredMessage();

    abstract String getInvalidFieldMessage();

    abstract boolean isFieldFilled(ObservableString field);

    abstract boolean isValueValid(ObservableString field);
}
