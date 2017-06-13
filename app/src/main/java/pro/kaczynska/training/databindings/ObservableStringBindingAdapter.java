package pro.kaczynska.training.databindings;

import android.databinding.BindingAdapter;
import android.databinding.BindingMethod;
import android.databinding.BindingMethods;
import android.widget.EditText;
import android.widget.TextView;

import pro.kaczynska.training.ObservableString;
import pro.kaczynska.training.TextWatcherAdapter;

/**
 * Created by mky on 09.06.2017.
 */

@BindingMethods({
        @BindingMethod(type = TextView.class,
                attribute = "android:onEditorAction",
                method = "setOnEditorActionListener"),
})

public class ObservableStringBindingAdapter {
    @BindingAdapter({"android:text"})
    public static void bindEditText(EditText view, final ObservableString observableString) {
        view.addTextChangedListener(new TextWatcherAdapter() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                observableString.set(s.toString());
            }
        });

        String newValue = observableString.get();
        if (!view.getText().toString().equals(newValue)) {
            view.setText(newValue);
        }
    }
}
