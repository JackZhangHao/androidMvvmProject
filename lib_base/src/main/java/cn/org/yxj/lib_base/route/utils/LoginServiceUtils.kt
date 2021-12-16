package cn.org.yxj.lib_base.route.utils

import cn.org.yxj.lib_base.route.LoginService
import com.alibaba.android.arouter.launcher.ARouter

class LoginServiceUtils {
    companion object {
        fun isLogin(): Boolean {
            return ARouter.getInstance().navigation(LoginService::class.java).isLogin()
        }

        fun getUserInfo(){
            return ARouter.getInstance().navigation(LoginService::class.java).getUserInfo()
        }

        fun removeUserInfo() {
            ARouter.getInstance().navigation(LoginService::class.java).removeUserInfo()
        }

    }

}