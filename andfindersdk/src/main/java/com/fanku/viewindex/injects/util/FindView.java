package com.fanku.viewindex.injects.util;

import android.app.Activity;
import android.app.Dialog;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;

import com.fanku.viewindex.injects.annotation.BindPagerView;

import java.lang.reflect.Field;

/**
 * 控件查找
 * @author fengkun
 */

public class FindView {

	private static final String TAG = "FindView";
	/**
	 * 解析 Activity view域注解
	 */
	public static void getActivityViewField(Activity activity) {
		try {
			Class<?> clazz = activity.getClass();
			Field[] fields = clazz.getDeclaredFields();
			if(fields==null||fields.length == 0){
				Log.e(TAG, "暂无控件");
				return;
			}
			int count = 0;
			for (Field field : fields) {
				// 查看这个字段是否有我们自定义的注解类标志的
				if (field.isAnnotationPresent(BindPagerView.class)) {
					BindPagerView inject = field
							.getAnnotation(BindPagerView.class);
					int id = inject.value();
					String tag = inject.tag();
					if (id > 0) {
						field.setAccessible(true);
						// 给我们要找的字段设置值
						View view = null;
						try {
							view = activity.findViewById(id);
						}catch (Exception e){
							Log.e("FindView", tag + e.toString());
						}
						if(view!=null){
							view.setTag(tag);
							field.set(activity, view);
						}
					}
					count+=1;
				}
			}
			Log.i("FindView", activity.getClass().getSimpleName()+"控件数量"+count+"个");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 解析fragment view域注解
	 */
	public static void getFragmentViewField(Fragment frag, View parent) {

		if (parent==null){
			Log.e(TAG, "布局加载失败");
			return;
		}

		try {
			Class<?> clazz = frag.getClass();
			Field[] fields = clazz.getDeclaredFields();
			if(fields==null||fields.length == 0){
				Log.e(TAG, "暂无控件");
				return;
			}
			int count = 0;
			for (Field field : fields) {
				// 查看这个字段是否有我们自定义的注解类标志的
				if (field.isAnnotationPresent(BindPagerView.class)) {
					BindPagerView inject = field
							.getAnnotation(BindPagerView.class);
					int id = inject.value();
					String tag = inject.tag();
					if (id > 0) {
						field.setAccessible(true);
						// 给我们要找的字段设置值
						View view = null;
						try {
							view = parent.findViewById(id);
						}catch (Exception e){
							Log.e("FindView", tag + e.toString());
						}
						if(view!=null){
							view.setTag(tag);
							field.set(frag, view);
						}

					}
					count+=1;
				}
			}
			Log.i("FindView", frag.getClass().getSimpleName()+"控件数量"+count+"个");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Dialog view域注解
	 */
	public static void getDialogViewField(Dialog dialog, View parent) {

		if (parent==null){
			Log.e(TAG, "布局加载失败");
			return;
		}

		try {
			Class<?> clazz = dialog.getClass();
			Field[] fields = clazz.getDeclaredFields();
			if(fields==null||fields.length == 0){
				Log.e(TAG, "暂无控件");
				return;
			}
			int count = 0;
			for (Field field : fields) {
				// 查看这个字段是否有我们自定义的注解类标志的
				if (field.isAnnotationPresent(BindPagerView.class)) {
					BindPagerView inject = field
							.getAnnotation(BindPagerView.class);
					int id = inject.value();
					String tag = inject.tag();
					if (id > 0) {
						field.setAccessible(true);
						// 给我们要找的变亮设置值
						View view = null;
						try {
							view = parent.findViewById(id);
						}catch (Exception e){
							Log.e("FindView", tag + e.toString());
						}
						if(view!=null){
							view.setTag(tag);
							field.set(dialog, view);
						}

					}
					count+=1;
				}
			}
			Log.i("FindView", dialog.getClass().getSimpleName()+"控件数量"+count+"个");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
