package pro.kaczynska.training;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextUtils;

import java.util.Objects;

public class ObservableString extends BaseObservable {

    private String text;

    public String get() {
        return text;
    }


    public void set(String text) {
        if (Objects.equals(this.text, text)) {
            return;
        }
        this.text = text;
        notifyChange();
    }

    public boolean isEmpty() {
        return TextUtils.isEmpty(text);
    }
}
