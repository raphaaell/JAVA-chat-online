package fr.raphew.chatonline.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

/**
 * This file of 'Chat online' was created by Raphew on 13/01/2021
 */
public class ApiVertx extends AbstractVerticle {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApiVertx.class);

    @Override
    public void start() throws Exception {
        Router router = Router.router(vertx);
        router.get("/api")
                .handler(this::sysout);
        vertx.createHttpServer()
                .requestHandler(router)
                .listen(8080);
        super.start();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    public void sysout(RoutingContext routingContext){
        final JsonObject jsonObject = new JsonObject();
        jsonObject.put("name", "my-name");
        routingContext.response()
                .setStatusCode(200)
                .putHeader("content-type", "application/json")
                .end(Json.encodePrettily(jsonObject));
    }
}
