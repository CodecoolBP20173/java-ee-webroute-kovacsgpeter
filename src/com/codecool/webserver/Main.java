package com.codecool.webserver;

import com.codecool.webserver.annotation.WebRoute;
import com.codecool.webserver.handler.MainHandler;
import com.codecool.webserver.handler.SingleHandler;
import com.codecool.webserver.routes.SingleRoute;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;


public class Main  {



    public static void main(String[] args) throws Exception {



        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        //server.createContext("/", new SingleHandler());
        server.createContext("/", new MainHandler());
        server.start();
    }

}
