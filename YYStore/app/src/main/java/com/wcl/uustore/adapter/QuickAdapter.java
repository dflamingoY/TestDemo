package com.wcl.uustore.adapter;

import android.content.Context;
import android.view.View;

import java.util.List;


/**
 * 简写adapter，实现数据绑定
 */
public abstract class QuickAdapter<T> extends BaseQuickAdapter<T, BaseAdapterHelper> {
    /**
     * Create a QuickAdapter.
     * @param context     The context.
     * @param layoutResId The layout resource id of each item.
     */
    public QuickAdapter(Context context, int layoutResId) {
        super(context, layoutResId);
    }

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     * @param context     The context.   cvu
     * @param layoutResId The layout resource id of each item.
     * @param data        A new list is created out of this one to avoid mutable list
     */
    public QuickAdapter(Context context, int layoutResId, List<T> data) {
        super(context, layoutResId, data);
    }
    /**
     * add headView to recycleView
     * */
    public QuickAdapter(Context context, int layoutResId, List<T> data,View headView){
        super(context,layoutResId,data,headView);
    }

    @Override
    public void onViewDetachedFromWindow(BaseAdapterHelper holder) {
        super.onViewDetachedFromWindow(holder);
    }

    @Override
    public void onViewAttachedToWindow(BaseAdapterHelper holder) {
        super.onViewAttachedToWindow(holder);
    }


}
