package com.sunshine.magichand.injects;

import android.app.Activity;
import android.view.View;

import com.sunshine.magichand.annonations.BindView;
import com.sunshine.magichand.annonations.LayoutID;

import java.lang.reflect.Field;

/**
 * Created by gengqiquan on 2017/4/18.
 */
public class MagicHand {
    public static void inject(Activity activity) {
        bindContentView(activity);
        bindViewAndID(activity);
    }

    private static void bindContentView(Activity activity) {
        Class target = activity.getClass();
        LayoutID layoutID = (LayoutID) target.getAnnotation(LayoutID.class);
        if (layoutID != null) {
            activity.setContentView(layoutID.value());
        }
    }

    private static void bindViewAndID(Activity activity) {
        Class target = activity.getClass();
        Field[] fields = target.getDeclaredFields();

        View decorView = activity.getWindow().getDecorView();
        for (Field f : fields) {
            //获取字段中包含fieldMeta的注解
            BindView bind = f.getAnnotation(BindView.class);
            if (bind != null) {
                f.setAccessible(true);
                try {
                    f.set(activity, decorView.findViewById(bind.value()));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }


            }
        }
    }
}
