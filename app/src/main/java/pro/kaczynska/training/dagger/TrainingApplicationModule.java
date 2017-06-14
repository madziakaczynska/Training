package pro.kaczynska.training.dagger;

import android.content.res.Resources;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pro.kaczynska.training.ObservableString;
import pro.kaczynska.training.TrainingApplication;
import pro.kaczynska.training.strategy.ValidateFieldStrategy;
import pro.kaczynska.training.views.ErrorMessage;

/**
 * Created by mky on 08.06.2017.
 */

@Module
public class TrainingApplicationModule {
    private final TrainingApplication trainingApplication;

    public TrainingApplicationModule(TrainingApplication trainingApplication) {
        this.trainingApplication = trainingApplication;
    }


    @Singleton
    @Provides
    public ErrorMessage provideErrorMessage() {
        return new ErrorMessage();
    }

    @Singleton
    @Provides
    public Resources provideResources() {
        return trainingApplication.getResources();
    }
}
