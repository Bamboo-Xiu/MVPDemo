package com.wen.mvpdemo.base;

import android.content.Context;

/**
 * View 接口是 Activity 与 Presenter 层的中间层，它的作用是根据具体业务的需要，
 * 为 Presenter 提供调用 Activity 中具体 UI 逻辑操作的方法。
 */
public interface BaseView {

    /**
     * 显示正在加载进度框
     */
    void showLoading();

    /**
     * 隐藏正在加载进度框
     */
    void hideLoading();

    /**
     * 当数据请求成功后，调用此接口显示数据
     * @param data 数据源
     */
    void showData(String data);

    /**
     * 当数据请求失败后，调用此接口提示
     * @param msg 失败原因
     */
    void showFailureMessage(String msg);

    /**
     * 当数据请求异常，调用此接口提示
     */
    void showErrorMessage();

    /**
     * 显示提示
     * @param msg
     */
    void showToast(String msg);

    /**
     * 获取上下文
     * @return 上下文
     */
    Context getContext();
}
