package pro.kaczynska.training.viewModels;

import android.databinding.ObservableInt;
import android.view.View;

import pro.kaczynska.training.ObservableString;
import pro.kaczynska.training.R;
import pro.kaczynska.training.strategy.ValidateFieldStrategy;

/**
 * Created by mky on 14.06.2017.
 */

public class FieldViewModel {
    private static final int ACTIVE_STYLE = R.style.textinput_active;
    private static final int ERROR_STYLE = R.style.textinput_error;
    private static final int INACTIVE_STYLE = R.style.textinput_inactive;
    public ObservableString field = new ObservableString();
    public ObservableString error = new ObservableString();
    public View.OnFocusChangeListener onFocusChange;
    public ObservableInt textAppearance = new ObservableInt(INACTIVE_STYLE);
    private ValidateFieldStrategy validateFieldStrategy;


    public FieldViewModel(ValidateFieldStrategy validateFieldStrategy) {
        this.validateFieldStrategy = validateFieldStrategy;
        init();
    }

    private void init() {
        onFocusChange = new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                int color;
                if (!hasFocus) {
                    boolean isFieldValid = validateFieldStrategy.checkField(field, error);
                    color = (isFieldValid) ? INACTIVE_STYLE : ERROR_STYLE;
                } else {
                    error.set(null);
                    color = ACTIVE_STYLE;
                }
                textAppearance.set(color);
            }
        };
    }
}
