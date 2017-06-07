package pro.kaczynska.training;

import android.content.res.Resources;

/**
 * Created by mky on 07.06.2017.
 */

public class ErrorMessage {
    public final String FIELD_INVALID;
    public final String FIELD_REQUIRED;

    public ErrorMessage(final String FIELD_REQUIRED, final String FIELD_INVALID) {
//        ERROR_EMAIL = resources.getString(R.string.error_email);
//        ERROR_PASSWORD = resources.getString(R.string.error_password);
//        ERROR_TOO_SHORT = resources.getString(R.string.error_password_too_short);
        this.FIELD_REQUIRED = FIELD_REQUIRED;
        this.FIELD_INVALID = FIELD_INVALID;
    }
}
