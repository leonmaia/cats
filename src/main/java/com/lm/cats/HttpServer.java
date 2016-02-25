package com.lm.cats;

import com.twitter.finagle.Http;
import com.twitter.finagle.ListeningServer;
import com.twitter.finagle.http.HttpMuxer;
import com.twitter.util.Await;

import java.net.InetAddress;
import java.net.InetSocketAddress;

public class HttpServer {

    static InetSocketAddress addr = new InetSocketAddress(InetAddress.getLoopbackAddress(), 8888);

    public static void main(String[] args) throws Exception {
        runServer();
    }

    private static HttpMuxer router() {
        return new HttpMuxer()
                .withHandler("/echo", Handlers.echoHandler());
    }

    private static void runServer() throws InterruptedException, com.twitter.util.TimeoutException {
        LoggingFilter accessLog = new LoggingFilter();

        ListeningServer server = Http.server()
                .serve(addr, accessLog.andThen(router()));

        Await.ready(server);
    }
}

