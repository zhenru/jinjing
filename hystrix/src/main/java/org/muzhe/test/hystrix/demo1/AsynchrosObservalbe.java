package org.muzhe.test.hystrix.demo1;

import com.google.common.base.Strings;
import rx.Observable;
import rx.Observer;
import rx.functions.Action1;

/**
 * 当前方法主要是对执行方法的以后优化，在执行的生命周期当中添加一些实现。
 * @author muzhe-wang on  18-6-14 下午2:35.
 */
public class AsynchrosObservalbe {

    public static void main(String[] args) {
        HelloWorldCommand helloWorldCommand = new HelloWorldCommand("World");
        //这里主要是一个执行完毕以后对当前的方法进行一个处理，返回一个想要的结果
        Observable<String> fs = helloWorldCommand.observe();
        fs.subscribe(new Action1<String>() {
            public void call(String result) {
                if (!Strings.isNullOrEmpty(result)){
                    System.out.println("执行完毕以后，对当前的对象进行一些处理，String 无法处理这个对象。" + result);
                }
            }
        });

        //在执行的生命周期主要是执行完毕，嗲用用
        fs.subscribe(new Observer<String>() {
            //在返回结果之前执行当前的方法。
            public void onCompleted() {
                //在onNext或者　　onError之后调用这个方法
                System.out.println("execute on complete...");
            }

            //在抛出异常的时候执行当前方法。
            public void onError(Throwable throwable) {
                //发生异常的时候调用这个方法
                System.out.println(" on error " + throwable.getMessage());
                throwable.printStackTrace();
            }

            //在拿到结果的时候执行当前的方法
            public void onNext(String s) {

                //获取结果以后调用这个方法
                System.out.println("one next : " + s);
            }
        });

    }



}
