package cn.org.yxj.lib_base.route

import android.content.Context
import com.alibaba.android.arouter.facade.template.IProvider


/**
 * mine模块对外接口   module_mine
 */
interface MineService: IProvider {
    fun launch(context: Context)
}