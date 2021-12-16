package cn.org.yxj.lib_base.route

import android.content.Context
import com.alibaba.android.arouter.facade.template.IProvider

/**
 * 跳转Web的 Web组件
 */
interface WebService: IProvider {
    fun goWeb(context: Context, title: String, url: String, id: Int?, isCollect: Boolean)
}