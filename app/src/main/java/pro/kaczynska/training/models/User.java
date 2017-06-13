package pro.kaczynska.training.models;

import android.content.res.Resources;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import pro.kaczynska.training.R;


public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public User(Resources resources) {
        email = resources.getString(R.string.email_value);
        password = resources.getString(R.string.password_value);
    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
