package com.example.grpc.server;

import com.example.message.Greeting;
import com.example.message.GreetingServiceGrpc;
import com.example.message.Hello;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

    private static class Apple{
        private int x;
    }

    public void hello(Apple x) {

    }

    @Override
    public void hello(Hello request, StreamObserver<Greeting> responseObserver) {

        responseObserver.onNext(Greeting.newBuilder().setGreeting("Hello " + request.getFirstname() + " - " + request.getLastname()).build());

        responseObserver.onCompleted();
    }
}
