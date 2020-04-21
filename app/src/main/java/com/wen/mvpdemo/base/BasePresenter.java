package com.wen.mvpdemo.base;

import com.wen.mvpdemo.MvpModel;

/**
 * BasePresenter 中可用的代码就是对 View 的引用方法了，Presenter 中持有的应该是 BaseView 的子类，这里同样需要
 * 泛型来约束
 * @param <V>
 */
public class BasePresenter<V extends BaseView> {

    // View 接口
    private V mView;

    public BasePresenter(){

    }

    /**
     * 绑定 view，一般在初始化中调用该方法
     * @param baseView
     */
    public void attachView(V baseView){
        this.mView = baseView;
    }

    /**
     * 断开 view，一般在 onDestroy 中调用
     */
    public void detachView(){
        this.mView = null;
    }

    /**
     * 是否与 View 建立连接
     * 每次调用业务请求的时候都要先调用该方法，检查是否与 View 建立连接
     * @return
     */
    public boolean isViewAttached(){
        return mView != null;
    }

    /**
     * 获取连接的 view
     * @return
     */
    public V getView(){
        return mView;
    }
}
