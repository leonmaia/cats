package com.lm.cats;

import com.twitter.finagle.Service;
import com.twitter.finagle.SimpleFilter;
import com.twitter.finagle.http.Request;
import com.twitter.finagle.http.Response;
import com.twitter.util.Duration;
import com.twitter.util.Function;
import com.twitter.util.Future;
import com.twitter.util.Stopwatch$;

public final class LoggingFilter extends SimpleFilter<Request, Response> {

    @Override
    public Future<Response> apply(Request req, Service<Request, Response> service) {
        Duration e = Stopwatch$.MODULE$.start().apply();

        return service.apply(req).map(new Function<Response, Response>() {
            @Override
            public Response apply(Response resp) {
                System.out.println("Took: " + e.inMilliseconds() + "ms to complete.");

                return resp;
            }
        });
    }
}
