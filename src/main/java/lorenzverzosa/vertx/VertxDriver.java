package lorenzverzosa.vertx;

import io.vertx.core.Vertx;

/**
 * Created by lorenz on 1/7/16.
 */
public class VertxDriver {

    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();

        System.out.println("Deploying verticle");
        vertx.deployVerticle(new MyFirstVerticle());
    }
}
