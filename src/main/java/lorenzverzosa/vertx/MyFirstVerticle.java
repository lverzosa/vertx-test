package lorenzverzosa.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

/**
 * Created by lorenz on 1/7/16.
 */
public class MyFirstVerticle extends AbstractVerticle {
    @Override
    public void start(final Future<Void> startFuture) throws Exception {
        this.getVertx().createHttpServer().requestHandler(
                httpServerRequest ->
                        httpServerRequest.response().end("<h1>Hello from my first Vert.x 3 application</h1>")
        ).listen(8080, httpServerAsyncResult -> {
            if (httpServerAsyncResult.succeeded()) {
                startFuture.complete();
            } else {
                startFuture.fail(httpServerAsyncResult.cause());
            }
        });
    }
}
