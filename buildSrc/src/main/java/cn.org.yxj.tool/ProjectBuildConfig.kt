package cn.org.yxj.tool

/**
 * 项目相关参数配置
 *
 * @author zh
 * @since 10/14
 */
object ProjectBuildConfig {
    const val compileSdkVersion = 30
    const val buildToolsVersion = "30.0.1"
    const val applicationId = "com.quyunshuo.androidbaseframemvvm"
    const val minSdkVersion = 21
    const val targetSdkVersion = 30
    const val versionCode = 1
    const val versionName = "1.0"
    const val isAppMode = true

    /**
     * 项目当前的版本状态
     * 该状态直接反映当前App是测试版 还是正式版 或者预览版
     * 正式版:RELEASE、预览版(α)-内部测试版:ALPHA、测试版(β)-公开测试版:BETA
     */
    object Version {

        const val RELEASE = "VERSION_STATUS_RELEASE"

        const val TEST = "VERSION_STATUS_TEST"

        const val BETA = "VERSION_STATUS_BETA"
    }
}