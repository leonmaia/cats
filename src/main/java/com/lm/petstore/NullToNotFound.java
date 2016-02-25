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

import java.util.Objects;

public final class NullToNotFound extends SimpleFilter<Request, Response> {

    @Override
    public Future<Response> apply(Request req, Service<Request, Response> service) {
        return service.apply(req).map(new Function<Response, Response>() {
            @Override
            public Response apply(Response resp) {
                if (Objects.equals(resp.contentString(), "null"))
                    return Response.apply(Status.NotFound());

                return resp;
            }
        });
    }
}
