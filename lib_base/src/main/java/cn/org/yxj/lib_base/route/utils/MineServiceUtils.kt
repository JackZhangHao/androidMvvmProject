package cn.org.yxj.lib_base.route.utils

import android.content.Context
import cn.org.yxj.lib_base.route.MineService
import com.alibaba.android.arouter.launcher.ARouter

class MineServiceUtils {
    companion object {
         fun launch(context: Context) {
            ARouter.getInstance().navigation(MineService::class.java)
                .launch(context)
        }
    }
    }
