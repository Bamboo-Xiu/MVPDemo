package com.wen.mvpdemo;

public class MvpPresenter {

    // View 接口
    private MvpView mView;

    public MvpPresenter(MvpView view){
        this.mView = view;
    }

    /**
     * 获取网络数据
     * @param params 参数
     */
    public void getData(String params){

        // 显示正在加载进度条
        mView.showLoading();
        // 调用 Model 请求数据
        MvpModel.getNetData(params, new MvpCallback() {
            @Override
            public void onSuccess(String data) {
                // 调用 view 接口显示数据
                mView.showData(data);
            }

            @Override
            public void onFailure(String msg) {
                // 调用 view 接口提示失败信息
                mView.showFailureMessage(msg);
            }

            @Override
            public void onError() {
                // 调用 view 接口提示请求异常
                mView.showErrorMessage();
            }

            @Override
            public void onComplete() {
                // 隐藏正在加载进度条
                mView.hideLoading();
            }
        });
    }
}
