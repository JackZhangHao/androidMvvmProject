package cn.org.yxj.lib_imageloader

import android.content.Context


interface ILoaderStrategy {

    fun loadImage(options: LoaderOptions)


    /**
     * 清理内存缓存
     */
    fun clearMemoryCache(context: Context)

    /**
     * 清理磁盘缓存
     */
    fun clearDiskCache(context: Context)

}
