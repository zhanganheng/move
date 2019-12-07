package com.bw.library.utils;
/*
 *@auther:张安恒
 *@Date: 2019/11/5
 *@Time:19:36
 *@Description:${DESCRIPTION}
 **/

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class CommonObserver<T> implements Observer<T> {
    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onComplete() {

    }
}
