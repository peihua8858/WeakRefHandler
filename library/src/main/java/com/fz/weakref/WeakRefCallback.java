package com.fz.weakref;

import android.os.Message;

/**
 * 接收{@link android.os.Handler#handleMessage(Message)}回调处理
 *
 * @author dingpeihua
 * @version 1.0
 * @date 2017/11/7 09:40
 */
public interface WeakRefCallback {
    /**
     * 子类必须实现此功能才能接收消息
     *
     * @param msg
     * @author dingpeihua
     * @date 2019/6/12 10:35
     * @version 1.0
     * @see {@link android.os.Handler#handleMessage(Message)}
     */
    void handleMsg(Message msg);
}
