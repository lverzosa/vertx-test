package lorenzverzosa.vertx;

import io.vertx.core.Vertx;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by lorenz on 1/7/16.
 */
@RunWith(VertxUnitRunner.class)
public class MyFirstVerticleTest {
    private Vertx vertx;

    @Before
    public void setUp(TestContext context) {
        this.vertx = Vertx.vertx();
        vertx.deployVerticle(MyFirstVerticle.class.getName(), context.asyncAssertSuccess());
    }

    @After
    public void tearDown(TestContext context) {
        vertx.close(context.asyncAssertSuccess());
    }

    @Test
    public void testApplication(TestContext context) {
        final Async async = context.async();

        this.vertx.createHttpClient().getNow(8080, "localhost", "/", httpClientResponse -> httpClientResponse.handler(handler -> {
            context.assertTrue(handler.toString().contains("Hello"));
            async.complete();
        }));
    }
}
