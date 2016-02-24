package com.lm.cats;

import com.twitter.finagle.Service;
import com.twitter.finagle.http.Request;
import com.twitter.finagle.http.Response;
import com.twitter.util.Future;
import org.jboss.netty.buffer.ChannelBuffers;

import static com.lm.cats.JsonUtils.toBytes;
import static java.lang.Integer.parseInt;

public final class Handlers {

    static Service<Request, Response> echoHandler() {
        return new Service<Request, Response>() {
            public Future<Response> apply(Request request) {
                Hello h = HelloService.find(parseInt(request.getParam("id")));

                return Future.value(responseBuilder(toBytes(h)));
            }
        };
    }

    static Response responseBuilder(byte[] value) {
        Response response = Response.apply();
        response.setContent(ChannelBuffers.wrappedBuffer(value));

        return response;
    }
}

