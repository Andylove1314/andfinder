package com.fanku.viewindex.injects;

import android.app.Activity;
import android.app.Dialog;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;

import com.fanku.viewindex.injects.util.FindLayout;
import com.fanku.viewindex.injects.util.FindView;

/**
 * Created by fengkun on 16/3/24.
 */
public class AndFinder {

    /**
     * 初始化activity UI布局, 在activity.onCreate()中执行
     *
     * @param activity
     */
    public static void bind(Activity activity) {
        FindLayout.getActivityLayout(activity);
        FindView.getActivityViewField(activity);
    }

    /**
     * 初始化fragment UI布局, 在fragment.onCreateonCreateView()中执行
     *
     * @param inflater
     */
    public static View bind(Fragment fragment, LayoutInflater inflater) {
        View view = FindLayout.getFragmentLayout(fragment, inflater);
        FindView.getFragmentViewField(fragment, view);
        return view;
    }

    /**
     * 初始化window UI布局, eg:在dialog.onCreate中执行
     * @param dialog,context
     */
    public static void bind(Dialog dialog, Activity context) {
        View view = FindLayout.getDialogLayout(dialog, context);
        FindView.getDialogViewField(dialog, view);

    }

}
