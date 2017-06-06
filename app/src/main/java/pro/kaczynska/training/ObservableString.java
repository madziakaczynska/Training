package pro.kaczynska.training;

import android.databinding.BaseObservable;
import android.text.Editable;
import android.text.TextWatcher;

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

    public TextWatcher watcher = new TextWatcherAdapter() {
        @Override public void afterTextChanged(Editable s) {
            if (!Objects.equals(text, s.toString())) {
                text = s.toString();
            }
        }
    };
}
