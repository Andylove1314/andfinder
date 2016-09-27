package com.fanku.viewindex.injects.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.fanku.viewindex.injects.annotation.BindPagerLayout;

/**
 * 布局查找
 * Created by fengkun on 16/3/24.
 */
public class FindLayout {

    /**
     * 解析contentView注解
     */
    public static void getActivityLayout(Activity activity) {
        try {
            Class<?> clazz = activity.getClass();
            if (clazz.isAnnotationPresent(BindPagerLayout.class)) {
                BindPagerLayout inject = clazz
                        .getAnnotation(BindPagerLayout.class);
                int layout = inject.value();
                try {
                    activity.setContentView(layout);
                } catch (Exception e) {
                    Log.e(clazz.getName(), "没有找到布局");
                }

            }

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建fragment view
     * @param inflater
     */
    public static View getFragmentLayout(Fragment frag, LayoutInflater inflater) {

        View parent = null;

        try {
            Class<?> clazz = frag.getClass();
            if (clazz.isAnnotationPresent(BindPagerLayout.class)) {
                BindPagerLayout inject = clazz
                        .getAnnotation(BindPagerLayout.class);
                int layout = inject.value();
                try {
                    parent = inflater.inflate(layout, null);
                } catch (Exception e) {
                    Log.e(clazz.getName(), "没有找到布局");
                }

            }

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        return parent;

    }

    /**
     * @param dialog context
     */
    public static View getDialogLayout(Dialog dialog, Context context) {

        View parent = null;
        LayoutInflater inflater = LayoutInflater.from(context);
        try {
            Class<?> clazz = dialog.getClass();
            if (clazz.isAnnotationPresent(BindPagerLayout.class)) {
                BindPagerLayout inject = clazz
                        .getAnnotation(BindPagerLayout.class);
                int layout = inject.value();
                try {
                    parent = inflater.inflate(layout, null);
                    dialog.setContentView(parent);
                } catch (Exception e) {
                    Log.e(clazz.getName(), "没有找到布局");
                }

            }

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        return parent;

    }

}
