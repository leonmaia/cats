package com.lm.cats;

import com.twitter.finagle.Service;
import com.twitter.finagle.http.Request;
import com.twitter.finagle.http.Response;
import com.twitter.finagle.http.Status;
import com.twitter.util.Future;
import org.jboss.netty.buffer.ChannelBuffers;

import static com.lm.cats.JsonUtils.toBytes;
import static java.lang.Integer.parseInt;

public final class Handlers {
    static Service<Request, Response> echoHandler() {
        return new Service<Request, Response>() {
            public Future<Response> apply(Request request) {
                Cat cat = CatService.find(getId(request));
                Response response = Response.apply(request.version(), Status.Ok());
                response.setContent(ChannelBuffers.wrappedBuffer(toBytes(cat)));

                return Future.value(response);
            }

            private int getId(Request request) {
                String id = request.getParam("id");

                try {
                    return parseInt(id);
                } catch (NumberFormatException e) {
                    throw new NumberFormatException("Invalid id: " + id);
                }
            }
        };
    }
}

