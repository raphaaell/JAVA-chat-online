package fr.raphew.chatonline.main;

import fr.raphew.chatonline.vertx.ApiVertx;
import io.vertx.core.Vertx;

/**
 * This file of 'Chat online' was created by Raphew on 13/01/2021
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world !");
        final Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new ApiVertx());

    }


}
