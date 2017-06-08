package pro.kaczynska.training.dagger;

import javax.inject.Singleton;

import dagger.Component;
import pro.kaczynska.training.ValidateFieldStrategy;


/**
 * Created by mky on 08.06.2017.
 */

@Singleton
@Component(modules = {TraningApplicationModule.class})
public interface TrainingApplicationComponent {
    void inject(ValidateFieldStrategy strategy);
}
