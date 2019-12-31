package core.dvaar.impl.common.di.guice.model;

import com.google.inject.AbstractModule;

public class SampleModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(SampleModel.class).toInstance(new SampleModelImpl("Sample"));
    }

}
