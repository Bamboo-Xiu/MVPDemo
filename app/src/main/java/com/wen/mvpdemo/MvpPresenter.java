package com.wen.mvpdemo;

import com.wen.mvpdemo.base.BasePresenter;
import com.wen.mvpdemo.base.MvpCallback;

public class MvpPresenter extends BasePresenter<MvpView> {

    public void getData(String params){

        if(!isViewAttached()){
            // 如果没有 View 引用就不加载数据
            return;
        }

        // 显示正在加载进度条
        getView().showLoading();

        MvpModel.getNetData(params, new MvpCallback<String>() {
            @Override
            public void onSuccess(String data) {
                // 调用 view 接口显示数据
                if(isViewAttached()){
                    getView().showData(data);
                }
            }

            @Override
            public void onFailure(String msg) {
                // 调用 view 接口提示失败信息
                if(isViewAttached()){
                    getView().showToast(msg);
                }
            }

            @Override
            public void onError() {
                // 调用 view 接口提示请求异常
                if(isViewAttached()){
                    getView().showErrorMessage();
                }
            }

            @Override
            public void onComplete() {
                //隐藏正在加载进度条
                if(isViewAttached()){
                    getView().hideLoading();
                }
            }
        });
    }
}
