package cj.lambda;

import java.util.concurrent.Callable;

public class LambdaTest {
    public static void main(String[] args) throws Exception {
        Runnable runnable = () -> System.out.println("running3....");
        runnable.run();

        Callable<String> c1 = new Callable() {
            @Override
            public String call() throws Exception {
                return "callable c1 test";
            }
        };
        c1.call();
        System.out.println(c1.call());

        Callable<String> c2 = () -> {return "callable c2 test";};
        System.out.println(c2.call());

        Callable<String> c3 = () -> "callable c3 test";
        System.out.println(c3.call());
    }
}
