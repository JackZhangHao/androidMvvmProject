package cn.org.yxj.module_login.route

import android.content.Context
import cn.org.yxj.lib_base.route.LoginService
import com.alibaba.android.arouter.facade.annotation.Route
@Route(path = "/login/login")
class LoginServiceImpl : LoginService {

    override fun isLogin(): Boolean {
        return false
    }

    override fun getUserInfo(){

    }

    override fun removeUserInfo() {

    }


    override fun init(context: Context?) {

    }
}