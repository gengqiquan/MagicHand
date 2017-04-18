package com.sunshine.magichand.annonations;

import android.support.annotation.IdRes;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by gengqiquan on 2017/4/18.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.CLASS)
@Documented
public @interface BindView {
    @IdRes
    int value();
}
