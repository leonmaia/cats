//package com.leon.dogs;
//
//import com.twitter.finagle.Service;
//import com.twitter.finagle.SimpleFilter;
//import com.twitter.finagle.http.Request;
//import com.twitter.finagle.http.Response;
//import com.twitter.util.Duration;
//import com.twitter.util.Future;
//import com.twitter.util.Stopwatch;
//import com.twitter.util.Stopwatch$;
//import scala.Function0;
//
//
//public class LoggingFilter extends SimpleFilter<Request, Response> {
//
//    private void logRequest(Request req, Service<Request, Response> service, Duration time) {
////        service.apply(req).map((Response s) -> {
////            if (Objects.equals("null", s.contentString())) {
////                System.out.print("heyyyyyyyy");
////            }
////            return null;
////        });
//
//        System.out.println(time.inMilliseconds() +"ms");
//    }
//
//    @Override
//    public Future<Response> apply(Request request, Service<Request, Response> service) {
////        logRequest(request, service, elapsed);
//        return service.apply(request);
////        return Future.value(Response.apply(request.version(), Status.BadRequest()));
//    }
//}
