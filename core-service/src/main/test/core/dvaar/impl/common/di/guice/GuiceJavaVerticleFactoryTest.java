package core.dvaar.impl.common.di.guice;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.inject.Guice;
import com.google.inject.Injector;

import core.dvaar.impl.common.di.guice.model.SampleModelImpl;
import core.dvaar.impl.common.di.guice.model.SampleModule;
import core.dvaar.impl.common.di.guice.model.SampleVerticle;
import io.vertx.core.Verticle;

/**
 * 
 * @author amrish
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class GuiceJavaVerticleFactoryTest {
    private Injector injector;
    private GuiceJavaVerticleFactory factory;

    @Before
    public void setUp() throws Exception {
        injector = Guice.createInjector(new SampleModule());
        factory = new GuiceJavaVerticleFactory(injector);
    }

    @Test
    public void prefixTest() {
        assertThat(factory.prefix()).isEqualTo("guice-java");
    }

    @Test
    public void createVerticleTest() throws Exception {
        String identifier = GuiceJavaVerticleFactory.GUICE_PREFIX + ":" + SampleVerticle.class.getCanonicalName();
        Verticle verticle = factory.createVerticle(identifier, this.getClass().getClassLoader());

        assertThat(verticle).isNotNull();
        assertThat(verticle).isExactlyInstanceOf(SampleVerticle.class);

        assertThat(((SampleVerticle) verticle).model).isExactlyInstanceOf(SampleModelImpl.class);
    }

}
