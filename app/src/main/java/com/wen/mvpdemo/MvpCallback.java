package com.wen.mvpdemo;

/**
 * Callback 接口是 Model 层给 Presenter 层反馈请求信息的传递载体，
 * 所以需要在 Callback 中定义数据请求的各种反馈状态：
 */
public interface MvpCallback {
    /**
     * 数据请求成功
     * @param data 请求到的数据
     */
    void onSuccess(String data);

    /**
     * 使用网络 API 接口请求方式时，虽然已经请求成功但是由于 {@code msg} 的原因无法正常返回数据
     * @param msg
     */
    void onFailure(String msg);

    /**
     * 请求数据失败，指在请求网络 API 接口请求方法时，出现无法联网、缺少权限，内存泄漏等原因导致
     * 无法连接到请求数据源
     */
    void onError();

    /**
     * 当请求数据结束时，无论请求结果是成功，失败或是抛出异常都会执行此方法给用户做处理，通常做网络
     * 请求时可以在此处隐藏 “正在加载” 的等待控件
     */
    void onComplete();
}
