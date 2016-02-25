package com.lm.petstore;

import com.twitter.finagle.Service;
import com.twitter.finagle.SimpleFilter;
import com.twitter.finagle.http.Request;
import com.twitter.finagle.http.Response;
import com.twitter.finagle.http.Status;
import com.twitter.util.Duration;
import com.twitter.util.Function;
import com.twitter.util.Future;
import com.twitter.util.Stopwatch$;
import org.jboss.netty.buffer.ChannelBuffers;

import java.util.Objects;

import static com.lm.petstore.JsonUtils.toBytes;

public final class HandleErrors extends SimpleFilter<Request, Response> {

    @Override
    public Future<Response> apply(Request req, Service<Request, Response> service) {
        return service.apply(req).handle(new Function <Throwable, Response> () {
            @Override
            public Response apply (Throwable t){
                Response resp = Response.apply(Status.InternalServerError());
                resp.setContent(ChannelBuffers.wrappedBuffer(t.getMessage().getBytes()));

                return resp;
            }
        });
    }
}
