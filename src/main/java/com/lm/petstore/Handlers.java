package com.lm.petstore;

import com.twitter.finagle.Service;
import com.twitter.finagle.http.Request;
import com.twitter.finagle.http.Response;
import com.twitter.util.Future;
import org.jboss.netty.buffer.ChannelBuffers;

import static com.lm.petstore.JsonUtils.toBytes;
import static java.lang.Integer.parseInt;

public final class Handlers {
    static Service<Request, Response> echoHandler() {
        return new Service<Request, Response>() {
            public Future<Response> apply(Request request) {
                Pet pet = PetStoreService.find(parseInt(request.getParam("id")));
                Response response = Response.apply();
                response.setContent(ChannelBuffers.wrappedBuffer(toBytes(pet)));

                return Future.value(response);
            }
        };
    }
}

