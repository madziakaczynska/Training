package pro.kaczynska.training;

import java.util.regex.Pattern;

/**
 * Created by mky on 07.06.2017.
 */

public class PasswordValidationStrategy extends ValidateFieldStrategy {

    private static final java.lang.String PASSWORD_PATTERN = "[a-zA-Z0-9\\!\\@\\#\\$]{8,24}";

    public PasswordValidationStrategy(ErrorMessage errorMessage) {
        super(errorMessage);
    }

    @Override
    boolean isFieldFilled(ObservableString field) {
        return field.get().length() > 5;
    }

    @Override
    boolean isValueValid(ObservableString field) {
        Pattern fieldPattern = Pattern.compile(PASSWORD_PATTERN);
        return fieldPattern.matcher(field.get()).matches();
    }
}
