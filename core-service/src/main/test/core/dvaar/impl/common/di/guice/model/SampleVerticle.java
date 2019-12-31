package core.dvaar.impl.common.di.guice.model;

import com.google.inject.Inject;

import io.vertx.core.AbstractVerticle;

public class SampleVerticle extends AbstractVerticle {
    
    public final SampleModel model;
    
    @Inject
    public SampleVerticle(SampleModel model) {
        this.model = model;
    }
    
    public void start() throws Exception {
        
    }
}
