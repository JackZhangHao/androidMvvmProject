package cn.org.yxj.lib_base.route

import com.alibaba.android.arouter.facade.template.IProvider

interface LoginService: IProvider {
    fun isLogin(): Boolean

    fun getUserInfo()

    fun removeUserInfo()
}