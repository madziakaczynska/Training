package pro.kaczynska.training;

import android.app.Application;

import pro.kaczynska.training.dagger.DaggerTrainingApplicationComponent;
import pro.kaczynska.training.dagger.TrainingApplicationComponent;
import pro.kaczynska.training.dagger.TrainingApplicationModule;

/**
 * Created by mky on 08.06.2017.
 */

public class TrainingApplication extends Application {

    private static TrainingApplication instance;
    public TrainingApplicationModule module;
    private TrainingApplicationComponent component;

    public static TrainingApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger();
    }

    public TrainingApplicationComponent getComponent() {
        return component;
    }

    private TrainingApplicationComponent createComponent() {
        return DaggerTrainingApplicationComponent.builder().trainingApplicationModule(
                new TrainingApplicationModule(instance)).build();
    }

    private void initDagger() {
        instance = this;
        module = new TrainingApplicationModule(this);
        component = createComponent();
    }
}
