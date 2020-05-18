package com.ibook.component.reactivestreams;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * @Description:
 * @Authr: yaunde
 * @Date: 2019-08-29 23:46
 */
public class SimpleSubscriber<T> implements Subscriber<T> {

    private Subscription subscription;

    public SimpleSubscriber(Subscription subscription) {
        this.subscription = subscription;
    }

    @Override
    public void onSubscribe(Subscription s) {

    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable t) {

    }

    @Override
    public void onComplete() {

    }
}
