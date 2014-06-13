package com.bitium10.sso.bind;

import java.lang.annotation.*;
import com.bitium10.sso.common.Constant;

/**
 * Created with IntelliJ IDEA.
 * User: wylipengming
 * Date: 14-6-13
 * Time: 下午3:16
 *
 *  <p>绑定当前登录的用户</p>
 *  <p>不同于@ModelAttribute</p>
 *
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {
    /**
     * 当前用户在request中的名字
     *
     * @return
     */
    String value() default Constant.CURRENT_USER;
}
