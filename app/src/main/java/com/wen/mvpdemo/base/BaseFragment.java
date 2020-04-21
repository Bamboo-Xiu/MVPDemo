package com.wen.mvpdemo.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment implements BaseView {

    public abstract int getContentViewId();

    protected abstract void initAllMembersView(Bundle saveInstanceState);

    protected Context mContext;
    protected View mRootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(getContentViewId(), container, false);
        this.mContext = getActivity();
        initAllMembersView(savedInstanceState);
        return mRootView;
    }

    @Override
    public void showLoading() {
        checkActivityAttached();
    }

    @Override
    public void showToast(String msg) {
        checkActivityAttached();
    }

    @Override
    public void showData(String data) {
        checkActivityAttached();
    }

    @Override
    public void showErrorMessage() {
        checkActivityAttached();
    }

    @Override
    public void showFailureMessage(String msg) {
        checkActivityAttached();
    }

    protected boolean isAttachedContext(){
        return getActivity() != null;
    }

    /**
     * 检查 activity 链接情况
     */
    public void checkActivityAttached(){
        if(getActivity() == null){
            throw new ActivityNotAttachedException();
        }
    }

    public static class ActivityNotAttachedException extends RuntimeException{
        public ActivityNotAttachedException(){
            super("Fragment is disconnected from Activity! ");
        }
    }
}
