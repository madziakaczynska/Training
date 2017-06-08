package pro.kaczynska.training.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pro.kaczynska.training.ErrorMessage;
import pro.kaczynska.training.TrainingApplication;

/**
 * Created by mky on 08.06.2017.
 */

@Module
public class TraningApplicationModule {
    private final TrainingApplication trainingApplication;

    public TraningApplicationModule(TrainingApplication trainingApplication) {
        this.trainingApplication = trainingApplication;
    }


    @Provides
    @Singleton
    public ErrorMessage provideErrorMessage() {
        return new ErrorMessage();
    }
}
