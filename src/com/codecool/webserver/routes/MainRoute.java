package com.codecool.webserver.routes;



import com.codecool.webserver.annotation.WebRoute;
import com.sun.net.httpserver.HttpExchange;


import java.io.IOException;


public abstract class MainRoute {
    @WebRoute(method = "GET")
    public abstract void handleGET(HttpExchange t) throws IOException;

    @WebRoute(method = "POST")
    public abstract void handlePOST(HttpExchange t) throws IOException;

}
