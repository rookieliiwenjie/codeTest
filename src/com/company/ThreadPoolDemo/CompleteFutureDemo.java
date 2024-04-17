package com.company.ThreadPoolDemo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class CompleteFutureDemo {
    protected static final AtomicInteger mThreadNum = new AtomicInteger(1);
    static final ThreadPoolExecutor executorService = new ThreadPoolExecutor(5, 10, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), new ThreadFactryName("CompleteFutureDemo", false), new ThreadPoolExecutor.DiscardOldestPolicy());


    public static void acceptEitherDemo() {

        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 100, executorService);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 200, executorService);

        future1.acceptEitherAsync(future2, (result) -> {
            try {
                System.out.println("acceptEitherAsync" + (result + future2.get()));
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println(future1.join());
        //接收一个CompletionStage
//        future1.acceptEither(future2, (result) -> {
//            try {
//                System.out.println(result + future2.get());
//            } catch (InterruptedException | ExecutionException e) {
//                throw new RuntimeException(e);
//            }
//        });
//        //如果不想影响当前线程，可以使用异步的方式，这样就不会阻塞当前线程
//        //accept 接收 Either 任务和 Async 异步
//        future1.acceptEitherAsync(future2, (result) -> {
//            try {
//                System.out.println("acceptEitherAsync" + (result + future2.get()));
//                TimeUnit.SECONDS.sleep(2);
//                System.out.println("acceptEitherAsync" + new Date());
//            } catch (InterruptedException | ExecutionException e) {
//                throw new RuntimeException(e);
//            }
//        });
        System.out.println("main" + new Date());

    }


    public static void allOfAnyOfDemo() throws ExecutionException, InterruptedException {

        List<CompletableFuture<Integer>> futures = new ArrayList<>();
        long start = System.currentTimeMillis();
        futures.add(CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 100;
        }, executorService));

        futures.add(CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 200;
        }, executorService));
        futures.add(CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 300;
        }, executorService));

        /**
         * 分别处理统一处理
         */
        CompletableFuture<Integer>[] array = futures.toArray(new CompletableFuture[futures.size()]);
        CompletableFuture.allOf(array).join();
        int num = 0;
        for (int i = 0; i < futures.size(); i++) {
            num = num + futures.get(i).get();
        }

        /**
         *  anyof 返回最快执行的任务
         */
//        CompletableFuture<Integer>[] array = futures.toArray(new CompletableFuture[0]);
//        CompletableFuture<Object> objectCompletableFuture = CompletableFuture.anyOf(array);
//        System.out.println("objectCompletableFuture" + objectCompletableFuture.get());
//        int num = 0;
//        for (int i = 0; i < futures.size(); i++) {
//            num = num + futures.get(i).get();
//        }
        System.out.println("allOf" + (System.currentTimeMillis() - start) / 1000);
        System.out.println(num);
        executorService.shutdown();
        System.out.println("allOf" + (System.currentTimeMillis() - start) / 1000);
    }

    /**
     * applyToEither ：异步执行一个任务，接收一个参数 有返回值可以返回一个
     * 和 acceptEither 的区别是，applyToEither 可以有返回值
     * 这个比较好的就是可以处理合并处理不同数据
     */
    public static void applyEitherDemo() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 100, executorService);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 200, executorService);
        CompletableFuture<Integer> integerCompletableFuture1 = future1.applyToEitherAsync(future2, (result) -> {
            try {
                System.out.println("applyToEither" + (result + future2.get()));
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
            try {
                return result + future2.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println("integerCompletableFuture1" + integerCompletableFuture1.get());
        CompletableFuture<Integer> integerCompletableFuture2 = future1.applyToEither(future2, (result) -> {
            try {
                System.out.println("applyToEither" + (result + future2.get()));
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
            try {
                return result + future2.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println(integerCompletableFuture2.get());

    }

    /**
     * 取消正在执行的任务
     */
    public static void cancelDemo() {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 100;
        }, executorService);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 200, executorService);

        boolean cancel = future1.cancel(true);
        if (cancel) {
            System.out.println("future1/cancel" + cancel);
        } else {
            System.out.println("future1/cancel" + cancel);
        }
        boolean cancel1 = future2.cancel(true);
        if (cancel1) {
            System.out.println("future2/cancel1" + cancel1);
        } else {
            System.out.println("future2/cancel1" + cancel1);
        }
        executorService.shutdown();
    }


    /**
     * complete的使用
     * 1、手动模拟异步处理
     * 2、与其他线程进行协助，
     * 3、异常处理
     * join 和get 区别，join 等待到有结果
     */
    public static void completeGetJoinDemo() {
//        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.completedFuture(1);
//        CompletableFuture<Integer> integerCompletableFuture1 = CompletableFuture.supplyAsync(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(5);
//            } catch (InterruptedException e) {
//            }
//            return 100;
//        }, executorService);
////        try {
////            integerCompletableFuture.get();
////        } catch (InterruptedException e) {
////            throw new RuntimeException(e);
////        } catch (ExecutionException e) {
////            throw new RuntimeException(e);
////        }
//        System.out.println("-------");
//        integerCompletableFuture1.complete(1);
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("--after-----");
//        integerCompletableFuture1.join();
//        try {
//            System.out.println("integerCompletableFuture1.get()" + integerCompletableFuture1.get());
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }


//        CompletableFuture<Integer> integerCompletableFuture2 = CompletableFuture.supplyAsync(() -> {
//            try {
//                System.out.println("integerCompletableFuture2" + new Date());
//
//                TimeUnit.SECONDS.sleep(5);
//                System.out.println("aftreintegerCompletableFuture2" + new Date());
//
//            } catch (InterruptedException e) {
//            }
//            return 100;
//        }, executorService);
////        try {
////            TimeUnit.SECONDS.sleep(10);
////        } catch (InterruptedException e) {
////            throw new RuntimeException(e);
////        }
//        integerCompletableFuture2.completeExceptionally(
//                new RuntimeException("我的error"));
//        try {
//            System.out.println(integerCompletableFuture2.get());
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }


//        CompletableFuture<String> future = new CompletableFuture<>();
//        // 模拟异步任务，在某些情况下抛出异常
//        new Thread(() -> {
//            try {
//                // 执行异步任务...
//                throw new RuntimeException("Something went wrong");
//            } catch (Exception e) {
//                // 将 CompletableFuture 标记为异常完成状态，并传入相应的异常信息
//                future.completeExceptionally(e);
//            }
//        }).start();
//        future.join();
//        // 在获取结果时处理可能发生的异常
////        future.exceptionally(ex -> {
////            System.out.println("An exception occurred: " + ex.getMessage());
////            return null;
////        });

//

        /**
         * getNow使用
         */
//        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
////            try {
////                TimeUnit.SECONDS.sleep(5);
////            } catch (InterruptedException e) {
////            }
//            return 100;
//        }, executorService);
//
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("future.getNow(1)" + future.getNow(1));


        //如果超时为获取到，那么抛出TimeOutException
//        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(5);
//            } catch (InterruptedException e) {
//            }
//            return 100;
//        }, executorService);
//
//        try {
//            System.out.println( future.get(1, TimeUnit.SECONDS));
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        } catch (TimeoutException e) {
//            throw new RuntimeException(e);
//        }
//        executorService.shutdown();


        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
            }
            return 100;
        }, executorService).thenApplyAsync(s -> {
            System.out.println("thenApplyAsync" + s);
            try {
                TimeUnit.SECONDS.sleep(7);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return s + 1;
        }).thenApply(s -> {
            System.out.println("thenApply" + s);
            return s + 2;
        });
        future.thenApplyAsync(s -> {
            System.out.println("thenApplyAsync" + s);
            return s + 1;
        }).thenApply(s -> {
            System.out.println("thenApply" + s);
            return s + 2;
        });
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("future.getNumberOfDependents()" + future.getNumberOfDependents());
        System.out.println("result" + future.join());
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         thenAcceptAsync ：异步执行一个任务，接收一个参数 无返回值
         */
        //  acceptEitherDemo();
        /**
         * 带有返回值的 两个任务处理
         */
        // applyEitherDemo();


        //分别执行统一处理
        //allOfAnyOfDemo();


        //取消任务 cancelDemo();


        //completeGetJoinDemo();

        //用于处理异步操作的解惑或者异常结果
        // handleDemo();
        //isXXDemo();
        //  obtrudeXXXDemo();
        //runXXXDemo();
        // thenXXXDemo();
        whenXXXDemo();
    }

    public static void whenXXXDemo() {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("before completableFuture" + new Date());
                TimeUnit.SECONDS.sleep(4);
                System.out.println("after completableFuture" + new Date());
            } catch (InterruptedException e) {
            }
            return 100 / 0;
        }, executorService);
        /**
         * whenComplete ：两个任务都执行完毕后，执行一个任务
         */
//        CompletableFuture<Integer> completableFuture1 = completableFuture.whenComplete(new BiConsumer<Integer, Throwable>() {
//            @Override
//            public void accept(Integer integer, Throwable throwable) {
//                if (throwable != null) {
//                    System.out.println(throwable.getMessage());
//                } else {
//                    System.out.println("whenComplete" + integer);
//                }
//            }
//        });
        CompletableFuture<Integer> completableFuture1 = completableFuture.whenCompleteAsync(new BiConsumer<Integer, Throwable>() {
            @Override
            public void accept(Integer integer, Throwable throwable) {
                if (throwable != null) {
                    System.out.println(throwable.getMessage());
                } else {
                    System.out.println("whenComplete" + integer);
                }
            }
        });
        System.out.println("completableFuture" + completableFuture1.join());
        executorService.shutdown();
    }

    public static <result> void thenXXXDemo() {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("before completableFuture" + new Date());
                TimeUnit.SECONDS.sleep(4);
                System.out.println("after completableFuture" + new Date());
            } catch (InterruptedException e) {
            }
            return 100;
        }, executorService);
//        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
//            try {
//                System.out.println("before completablefuture2" + new Date());
//                TimeUnit.SECONDS.sleep(2);
//                System.out.println("after completablefuture2" + new Date());
//            } catch (InterruptedException e) {
//            }
//            return 200;
//        }, executorService);
        /**
         * thenAccept ：异步执行一个任务，接收一个参数 无返回值
         */
//        future.thenAccept(s -> {
//            System.out.println("thenAcceptbefore" + (s));
//            s = s + 100;
//            System.out.println("after thenAccept" + (s));
//        });
//        future.thenAcceptAsync(s -> {
//            System.out.println("thenAcceptbefore" + (s));
//            s = s + 100;
//            System.out.println("after thenAccept" + (s));
//        });
//        try {
//            System.out.println(new Date()+"future.get()");
//            TimeUnit.SECONDS.sleep(10);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        /**
         * thenAcceptBoth ：两个任务都执行完毕后，将两个任务的结果作为参数传递给 BiConsumer，计算结果
         */
//        future.thenAcceptBoth(future2, (s, s2) -> {
//            System.out.println(new Date() + "thenAcceptBothbefore" + (s + s2));
//            try {
//                TimeUnit.SECONDS.sleep(5);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            s = s + 100;
//            s2 = s2 + 100;
//            System.out.println(new Date() + "after thenAcceptBoth" + (s + s2));
//        });
        /**
         * thenAcceptBothAsync ：两个任务都执行完毕后，将两个任务的结果作为参数传递给 BiConsumer，异步计算结果
         */
//        future.thenAcceptBothAsync(future2, (s, s2) -> {
//            System.out.println(new Date() + "before.thenAcceptBothAsync" + (s + s2));
//            try {
//                TimeUnit.SECONDS.sleep(2);
//                s = s + 100;
//                s2 = s2 + 100;
//                System.out.println(new Date() + "after.thenAcceptBothAsync" + (s + s2));
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });
//        System.out.println("future.join()" + future.join());
//        try {
//            TimeUnit.SECONDS.sleep(10);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("future.getNumberOfDependents()" + future.getNumberOfDependents());


        /**
         * thenApply ：两个任务都执行完毕后，执行一个任务
         */
//        CompletableFuture<Integer> completableFuture = future.thenApply(s -> {
//            try {
//                System.out.println("before.thenApply" + (s));
//                TimeUnit.SECONDS.sleep(4);
//                s = s + 100;
//                System.out.println("after.thenApply" + (s));
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            return s;
//        });
        /**
         * thenApplyAsync ：两个任务都执行完毕后，异步执行一个任务
         */
//        CompletableFuture<Integer> completableFuture = future.thenApplyAsync(s -> {
//            try {
//                System.out.println("before.thenApply" + (s));
//                TimeUnit.SECONDS.sleep(4);
//                s = s + 100;
//                System.out.println("after.thenApply" + (s));
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            return s;
//        });

        /**
         * thenCombine ：两个任务都执行完毕后，将两个任务的结果作为参数传递给 BiFunction，计算结果
         */
//        CompletableFuture<Integer> completableFuture = future.thenCombine(future2, (s, s2) -> {
//            System.out.println(new Date() + "before.thenCombine" + (s + s2));
//            try {
//                TimeUnit.SECONDS.sleep(2);
//                s = s + 100;
//                s2 = s2 + 100;
//                System.out.println(new Date() + "after.thenCombine" + (s + s2));
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            return s + s2;
//        });
        /**
         * thenCombineAsync ：两个任务都执行完毕后，将两个任务的结果作为参数传递给 BiFunction，异步计算结果
         */
//        CompletableFuture<Integer> completableFuture = future.thenCombineAsync(future2, (s, s2) -> {
//            System.out.println(new Date() + "before.thenCombine" + (s + s2));
//            try {
//                TimeUnit.SECONDS.sleep(2);
//                s = s + 100;
//                s2 = s2 + 100;
//                System.out.println(new Date() + "after.thenCombine" + (s + s2));
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            return s + s2;
//        });

        /**
         * thenCompose ：两个任务都执行完毕后，将两个任务的结果作为参数传递给 Function，计算结果
         */
        // CompletableFuture<Integer> completableFuture = future.thenCompose(result -> CompletableFuture.completedFuture(result + 100));
        /**
         * thenComposeAsync ：返回一个新的CompletionStage，当此阶段正常完成时，将使用此阶段的默认异步执行工具执行，此阶段作为提供的函数的参数。
         */
        //CompletableFuture<Integer> completableFuture = future.thenComposeAsync(result -> CompletableFuture.completedFuture(result + 100));

        /**
         * thenRun ：返回一个新的CompletionStage，当此阶段正常完成时，执行给定的操作。
         */
//        CompletableFuture<Void> voidCompletableFuture = future.thenRun(() -> {
//            try {
//                System.out.println("before.thenRun");
//                TimeUnit.SECONDS.sleep(2);
//                System.out.println("after.thenRun");
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });
        /**
         * thenRunAsync ：返回一个新的CompletionStage，当此阶段正常完成时，使用此阶段的默认异步执行工具执行给定的操作。
         */
//        CompletableFuture<Void> voidCompletableFuture = future.thenRunAsync(() -> {
//            try {
//                System.out.println("before.thenRunAsync");
//                TimeUnit.SECONDS.sleep(2);
//                System.out.println("after.thenRunAsync");
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });

        /**
         * toCompletableFuture ：返回一个新的CompletableFuture，当此阶段正常完成时，它将以此阶段的结果作为其结果完成。
         */
        CompletableFuture<Integer> completableFuture = future.toCompletableFuture();

        System.out.println("future.join()" + future.join());
        System.out.println("future.getNumberOfDependents()" + completableFuture.join());
        executorService.shutdown();
    }

    public static void runXXXDemo() {

//        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
//            try {
//                System.out.println("before completableFuture" + new Date());
//                TimeUnit.SECONDS.sleep(5);
//                System.out.println("after completableFuture" + new Date());
//            } catch (InterruptedException e) {
//            }
//            return 100;
//        }, executorService);
//        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(() -> {
//            try {
//                System.out.println("before completableFuture2" + new Date());
//                TimeUnit.SECONDS.sleep(2);
//                System.out.println("after completableFuture2" + new Date());
//            } catch (InterruptedException e) {
//            }
//            return 100;
//        }, executorService);
        /**
         *
         * runAfterBoth ：两个任务都执行完毕后，执行一个任务
         */
//        completableFuture.runAfterBoth(completableFuture2, () -> {
//            try {
//                System.out.println("before,runAfterBoth");
//                TimeUnit.SECONDS.sleep(5);
//                System.out.println("after,runAfterBoth");
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });
        /**
         * runAfterBothAsync ：两个任务都执行完毕后，执行一个任务
         */
//        completableFuture.runAfterBothAsync(completableFuture, () -> {
//            try {
//                System.out.println("before,runAfterBothAsync");
//                TimeUnit.SECONDS.sleep(5);
//                System.out.println("after,runAfterBothAsync");
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });

        /**
         * runAfterEither ：两个任务任意一个执行完毕后，执行一个任务
         */
//        completableFuture.runAfterEither(completableFuture2, () -> {
//            System.out.println(new Date()+"before.runAfterEither");
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println(new Date()+"after+runAfterEither");
//        });

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            try {
                System.out.println("before.runAsync");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("after.runAsync");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, executorService);
        System.out.println("completableFuture.get()");
        System.out.println("completableFuture.get()" + voidCompletableFuture.join());
    }

    public static void demo() {
        //        //supplyAsync ：异步执行一个任务,接收无参构造函数，
//        CompletableFuture<Integer> completedFuture = CompletableFuture.supplyAsync(() -> {
//            System.out.println(Thread.currentThread().getName() + "---reslut");
//            return 100;
//        }, executorService);
//        //thenApplyAsync ：异步执行一个任务，接收一个参数 有返回值可以返回一个
//        CompletableFuture<String> completableFuture = completedFuture
//                .thenApplyAsync((result) -> {
//                    System.out.println(Thread.currentThread().getName() + "---reslut" + (result + 100));
//                    return "result" + 100;
//                }, executorService);
//        completableFuture.get();
//        System.out.println("completableFuture2222" + completableFuture.get());
//        completedFuture
//                .thenApplyAsync((result) -> {
//                    System.out.println(Thread.currentThread().getName() + "---reslut" + (result + 100));
//                    return result + 100;
//                }, executorService);
//        System.out.println(completedFuture.get());
    }

    /**
     * obtrudeXXX ：手动设置返回值或者异常
     */
    public static void obtrudeXXXDemo() {
        CompletableFuture<Integer> future = new CompletableFuture<>();
        /**
         * obtrudeValue ：手动设置返回值
         */
        future.obtrudeValue(100);
        CompletableFuture<Integer> integerCompletableFuture = future.thenApplyAsync(r -> {
            System.out.println("thenApplyAsync1--" + r);
            return r + 1;
        }).thenApplyAsync(r -> {
            System.out.println("thenApplyAsync2---" + r);
            return r + 4;
        });
        /**
         * obtrudeException ：手动抛出异常
         */
        future.obtrudeException(new Exception("error"));
        System.out.println("future.get()" + future.join());
        System.out.println("integerCompletableFuture.get()" + integerCompletableFuture.join());

//        CompletableFuture<Integer> future = new CompletableFuture<>();
//        future.obtrudeValue(100);
//        System.out.println("future.get()" + future.join());
        executorService.shutdown();
    }


    public static void isXXDemo() {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
            }
            return 100 / 0;
        }, executorService);
        /**
         * isCancelled()：如果任务被取消，则返回 true
         */
//        boolean cancel = future.isCancelled();
//        System.out.println("00000" + cancel);
//        System.out.println("future.join" + future.join());
        /**
         * isCompletedExceptionally()：如果任务完成后抛出异常，则返回 true
         */
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        boolean completedExceptionally = future.isCompletedExceptionally();
//        System.out.println("completedExceptionally" + completedExceptionally);
//        System.out.println(future.join());

        /**
         * isDone()：如果任务完成，则返回 true
         */
        boolean done = future.isDone();
        System.out.println("done" + done);
        executorService.shutdown();

    }

    /**
     * 用于处理异步操作的解惑或者异常结果
     * handle 和 handleAsync 区别是
     * handleAsync 可以指定线程池，handle 不能指定线程池，handleAsync 默认使用 ForkJoinPool.commonPool()，
     * 也可以指定线程池，handle是同步执行的，handleAsync是异步执行的，
     */
    public static void handleDemo() {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {

            }
            return 100 / 0;
        }, executorService);
//        CompletableFuture<Integer> handle = future.handle((result, throwable) -> {
//            if (throwable != null) {
//                try {
//                    System.out.println("throwable" + throwable.getMessage());
//                    TimeUnit.SECONDS.sleep(5);
//                } catch (InterruptedException e) {
//                }
//                return -1;
//            } else {
//                System.out.println("result" + result);
//                return result;
//            }
//        });

        CompletableFuture<Integer> handle = future.handleAsync((result, throwable) -> {
            if (throwable != null) {
                try {
                    System.out.println("throwable" + throwable.getMessage());
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                }
                return 3;
            } else {
                System.out.println("result" + result);
                return result;
            }
        });
        System.out.println("handl---" + handle.join());

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {

            }
            return 100 / 0;
        }, executorService).exceptionally(throwable -> {
            System.out.println("throwable" + throwable.getMessage());
            return 3;
        });
        System.out.println("futur2json" + future2.join());

        try {
        } catch (Exception e) {
            System.out.println("futurjson catch" + e.getMessage());
        }
        executorService.shutdown();
    }

}
