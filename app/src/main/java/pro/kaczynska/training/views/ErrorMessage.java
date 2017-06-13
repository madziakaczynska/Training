package pro.kaczynska.training.views;

import android.content.res.Resources;

import javax.inject.Inject;

import pro.kaczynska.training.R;
import pro.kaczynska.training.TrainingApplication;

/**
 * Created by mky on 07.06.2017.
 */

public class ErrorMessage {

    public final String EMAIL_EMPTY_FIELD;
    public final String PASSWORD_TOO_SHORT;
    public final String EMAIL_INVALID;
    public final String PASSWORD_INVALID;

    @Inject
    public Resources resources;

    public ErrorMessage() {
        TrainingApplication.getInstance().getComponent().inject(this);
        EMAIL_INVALID = resources.getString(R.string.error_email);
        PASSWORD_INVALID = resources.getString(R.string.error_password);
        EMAIL_EMPTY_FIELD = resources.getString(R.string.error_email_empty);
        PASSWORD_TOO_SHORT = resources.getString(R.string.error_password_too_short);
    }
}
