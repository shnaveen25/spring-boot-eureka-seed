package core.microservice.impl.common.di.guice;

import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;

import com.google.inject.Injector;

import io.vertx.core.Verticle;
import io.vertx.core.impl.verticle.CompilingClassLoader;
import io.vertx.core.spi.VerticleFactory;
/**
 * refer java verticle factory
 * @author amrish
 * @author lalitrao
 */
public class GuiceJavaVerticleFactory implements VerticleFactory {
    
    public static final String GUICE_PREFIX = "guice-java";
    private final Injector injector;
    
    public GuiceJavaVerticleFactory(Injector injector) {
        this.injector = injector;
    }

    @Override
    public String prefix() {
        return GUICE_PREFIX;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Verticle createVerticle(String verticleName, ClassLoader classLoader) throws Exception, PrivilegedActionException {
        String name = VerticleFactory.removePrefix(verticleName);
        Class clazz = null;
        if (name.endsWith(".java")) {
            CompilingClassLoader compilingLoader = AccessController.doPrivileged(new PrivilegedExceptionAction<CompilingClassLoader>() {
                public CompilingClassLoader run() {
                    return new CompilingClassLoader(classLoader, name);
                }
            });
            String className = compilingLoader.resolveMainClassName();
            clazz = compilingLoader.loadClass(className);
        } else {
            clazz = classLoader.loadClass(name);
        }
        return (Verticle) injector.getInstance(clazz);
    }

}
