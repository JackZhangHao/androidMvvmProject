package cn.org.yxj.lib_base.route

import android.content.Context
import com.alibaba.android.arouter.facade.template.IProvider

/**
 * home模块对外接口   module_home
 */
interface HomeService:IProvider {
    fun launch(context: Context)
}