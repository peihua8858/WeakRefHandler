package com.fz.weakref;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import java.lang.ref.WeakReference;

/**
 * Handler 弱引用
 * * 防止在activity、fragment中使用造成内存泄露
 *
 * @author dingpeihua
 * @version 1.0
 * @date 2019/6/12 10:34
 */
public final class WeakReferenceHandler extends Handler {
    private final WeakReference<WeakRefCallback> weak;

    public WeakReferenceHandler(WeakRefCallback listener) {
        super(Looper.getMainLooper());
        weak = new WeakReference<>(listener);
    }

    public WeakReferenceHandler(WeakRefCallback listener, Looper looper) {
        super(looper);
        weak = new WeakReference<>(listener);
    }

    @Override
    public final void handleMessage(Message msg) {
        final WeakRefCallback listener = weak.get();
        if (listener != null) {
            listener.handleMsg(msg);
        }
    }

    @Override
    public final void dispatchMessage(Message msg) {
        super.dispatchMessage(msg);
    }
}
