package org.example.common;

import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.LoopResources;

public abstract class AbstractHttpClient {

    public static final String BASE_URL = "http://localhost:7070";

    protected final HttpClient httpClient;

    public AbstractHttpClient() {
        var loopResource = LoopResources.create("vin", 1, true);
        this.httpClient = HttpClient.create()
            .runOn(loopResource)
            .baseUrl(BASE_URL);
    }
}
