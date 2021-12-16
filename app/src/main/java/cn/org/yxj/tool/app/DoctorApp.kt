package cn.org.yxj.tool.app

import android.content.Context
import androidx.multidex.MultiDex
import cn.org.yxj.lib_base.base.BaseApp

import cn.org.yxj.tool.BuildConfig
import com.alibaba.android.arouter.launcher.ARouter
import com.hjq.toast.ToastUtils
import com.tencent.mmkv.MMKV

class DoctorApp: BaseApp() {
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        MMKV.initialize(this)

        ToastUtils.init(this)
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)

    }

}