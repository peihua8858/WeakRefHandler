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
    private final WeakReference<Callback> weak;

    public WeakReferenceHandler(Callback callback) {
        super(Looper.getMainLooper());
        weak = new WeakReference<>(callback);
    }

    public WeakReferenceHandler(Looper looper, Callback callback) {
        super(looper, callback);
        weak = new WeakReference<>(callback);
    }

    public WeakReferenceHandler(Callback callback, Looper looper) {
        super(looper);
        weak = new WeakReference<>(callback);
    }

    @Override
    public final void handleMessage(Message msg) {
        final Callback listener = weak.get();
        if (listener != null && listener.handleMessage(msg)) {
            return;
        }
        if (listener instanceof WeakRefCallback) {
            ((WeakRefCallback) listener).handleMsg(msg);
        }
    }

    @Override
    public final void dispatchMessage(Message msg) {
        super.dispatchMessage(msg);
    }
}
