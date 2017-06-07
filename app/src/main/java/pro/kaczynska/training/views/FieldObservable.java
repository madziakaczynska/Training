package pro.kaczynska.training.views;

import android.databinding.BaseObservable;
import android.databinding.BindingConversion;
import android.databinding.Observable;
import android.databinding.ObservableField;

import pro.kaczynska.training.ValidateFieldStrategy;

/**
 * Created by mky on 07.06.2017.
 */

public class FieldObservable extends BaseObservable {
    private ObservableField<String> field = new ObservableField<>();
    private ObservableField<String> fieldError = new ObservableField<>();
    private ValidateFieldStrategy validateFieldStrategy;

    public FieldObservable(final ValidateFieldStrategy fieldStrategy) {
        validateFieldStrategy = fieldStrategy;
        field.addOnPropertyChangedCallback(new OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
//                validateFieldStrategy.checkField(field, fieldError);
            }
        });
    }

    @BindingConversion
    public static String convertObservableFieldToString(
            ObservableField<String> field) {
        return field.get();
    }

    public ObservableField<String> getField() {
        return field;
    }

    public void setField(ObservableField<String> field) {
        this.field = field;
    }

    public ObservableField<String> getFieldError() {
        return fieldError;
    }

    public void setFieldError(ObservableField<String> fieldError) {
        this.fieldError = fieldError;
    }

    public String getString(ObservableField<String> observableField) {
        return observableField.get();
    }

}
