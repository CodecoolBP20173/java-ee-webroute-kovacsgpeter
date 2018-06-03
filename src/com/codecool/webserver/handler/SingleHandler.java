package com.codecool.webserver.handler;

import com.codecool.webserver.annotation.WebRoute;
import com.codecool.webserver.routes.SingleRoute;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SingleHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange t) throws IOException {
        Class a= SingleRoute.class;
        Method[] methods =  a.getMethods();

        for (Method met : methods) {
            Annotation annotation = met.getAnnotation(WebRoute.class);
            System.out.println(annotation.annotationType());
            System.out.println(annotation instanceof WebRoute);
            System.out.println(t.getRequestURI().getPath());
            System.out.println(((WebRoute) annotation).path());
            System.out.println(((WebRoute) (annotation)).path().equals(t.getRequestURI().getPath()));
            if (annotation instanceof WebRoute && ((WebRoute) (annotation)).path().equals(t.getRequestURI().getPath())) {
                try {
                    System.out.println("belefut");
                    met.invoke(a.newInstance(), t);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
}
