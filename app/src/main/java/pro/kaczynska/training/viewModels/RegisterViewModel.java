package pro.kaczynska.training.viewModels;

import android.arch.lifecycle.ViewModel;

import pro.kaczynska.training.ObservableString;


public class RegisterViewModel extends ViewModel {
    public ObservableString firstName = new ObservableString();
    public ObservableString lastName = new ObservableString();
    public ObservableString email = new ObservableString();
    public ObservableString password= new ObservableString();



}
