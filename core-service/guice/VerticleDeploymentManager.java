package core.microservice.impl.common.di.guice;

import io.vertx.core.AsyncResult;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;

@SuppressWarnings("rawtypes")
public class VerticleDeploymentManager {
    private final Vertx vertx;

    public VerticleDeploymentManager(final Vertx vertx) {
        this.vertx = vertx;
    }


    public void deployVerticle(final Class verticleClazz) {
        deployVerticle(verticleClazz, new DeploymentOptions());
    }

    public void deployVerticle(final Class verticleClazz, final DeploymentOptions options) {
        this.vertx.deployVerticle(getFullVerticleName(verticleClazz), options);
    }

    public void deployVerticle(final Class verticleClazz, Handler<AsyncResult<String>> completionHandler) {

        this.vertx.deployVerticle(getFullVerticleName(verticleClazz), completionHandler);
    }

    public void deployVerticle(final Class verticleClazz, final DeploymentOptions options, Handler<AsyncResult<String>> completionHandler) {
        this.vertx.deployVerticle(getFullVerticleName(verticleClazz), options, completionHandler);
    }

    private static String getFullVerticleName(final Class verticleClazz) {
        return "guice-java" + ":" + verticleClazz.getCanonicalName();
    }
}
