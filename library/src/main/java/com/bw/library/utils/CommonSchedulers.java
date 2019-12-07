package com.bw.library.utils;
/*
 *@auther:张安恒
 *@Date: 2019/11/5
 *@Time:19:44
 *@Description:${DESCRIPTION}
 **/

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CommonSchedulers {
            public static  <T> ObservableTransformer<T,T> io2main(){
                return new ObservableTransformer<T, T>() {
                    @Override
                    public ObservableSource<T> apply(Observable<T> upstream) {
                        return upstream.subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread());
                    }
                };
            }
}
