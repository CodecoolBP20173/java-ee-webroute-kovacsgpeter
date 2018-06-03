package com.codecool.webserver.routes;

import com.codecool.webserver.annotation.WebRoute;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;


@WebRoute(path = "/user")
public class UserRoute extends MainRoute {

    @WebRoute(method = "GET")
    public void handleGET(HttpExchange t) throws IOException {
        String response = "\nGET method invoked on \"/user\" path";
        t.sendResponseHeaders(200, response.length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    @WebRoute(method = "POST")
    public void handlePOST(HttpExchange t) throws IOException {
        String response = "\nPOST method invoked on \"/user\" path";
        t.sendResponseHeaders(200, response.length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
