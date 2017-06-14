package pro.kaczynska.training.dagger;

import javax.inject.Singleton;

import dagger.Component;
import pro.kaczynska.training.strategy.ValidateFieldStrategy;
import pro.kaczynska.training.views.ErrorMessage;


/**
 * Created by mky on 08.06.2017.
 */

@Singleton
@Component(modules = {TrainingApplicationModule.class})
public interface TrainingApplicationComponent {
    void inject(ValidateFieldStrategy strategy);
    void inject(ErrorMessage errorMessage);
}
