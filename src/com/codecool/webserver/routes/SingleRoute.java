package com.codecool.webserver.routes;

import com.codecool.webserver.annotation.WebRoute;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SingleRoute {

    @WebRoute(path="/single")
    public void handleSingle(HttpExchange t) throws IOException {
        String response = "single";
        t.sendResponseHeaders(200, response.length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
    @WebRoute(path="/")
    public void handleRoot(HttpExchange t) throws IOException {
        String response = "main";
        t.sendResponseHeaders(200, response.length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
