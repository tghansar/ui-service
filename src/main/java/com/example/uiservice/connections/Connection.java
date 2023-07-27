package com.example.uiservice.connections;

import com.example.uiservice.clients.ServicesClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.client.jaxrs.engines.ApacheHttpClient43Engine;
import org.springframework.stereotype.Component;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.UriBuilder;

public class Connection {

    private UriBuilder FULL_PATH;
    private PoolingHttpClientConnectionManager cm;
    private CloseableHttpClient httpClient;
    private ApacheHttpClient43Engine engine;
    private ResteasyClient client;
    private ResteasyWebTarget target;
    private ServicesClient proxy;

    public Connection() {
        FULL_PATH = UriBuilder.fromPath("http://localhost:8081/");

        // Create connection pool
        cm = new PoolingHttpClientConnectionManager();
        httpClient = HttpClients.custom().setConnectionManager(cm).build();

        // connections limit
        cm.setMaxTotal(200);

        // max connections per route limit
        cm.setDefaultMaxPerRoute(20);
        engine = new ApacheHttpClient43Engine(httpClient);

        client = ((ResteasyClientBuilder) ClientBuilder.newBuilder()).httpEngine(engine).build();
        target = client.target(FULL_PATH);
        proxy = target.proxy(ServicesClient.class);
    }

    public ServicesClient getConnectionProxy () {
        return this.proxy;
    }

}
