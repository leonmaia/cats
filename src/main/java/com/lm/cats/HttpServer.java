package com.lm.cats;

import com.twitter.finagle.ListeningServer;
import com.twitter.finagle.http.HttpMuxer;
import com.twitter.util.Await;

import java.net.InetAddress;
import java.net.InetSocketAddress;

public class HttpServer {

    public static void main(String[] args) throws Exception {
        runServer();
    }

    private static HttpMuxer router() {
        return new HttpMuxer()
                .withHandler("/echo", Handlers.echoHandler());
    }

    private static void runServer() throws InterruptedException, com.twitter.util.TimeoutException {
        ListeningServer server = com.twitter.finagle.Http.server()
                .serve(new InetSocketAddress(InetAddress.getLoopbackAddress(), 8888), router());

        Await.ready(server);
    }
}

