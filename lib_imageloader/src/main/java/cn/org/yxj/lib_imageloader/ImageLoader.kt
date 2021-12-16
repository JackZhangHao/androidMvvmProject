package cn.org.yxj.lib_imageloader

import android.content.Context
import android.graphics.drawable.Drawable
import android.net.Uri

import java.io.File

/**
 * 图片加载类
 * 策略或者静态代理模式，开发者只需要关心ImageLoader + LoaderOptions
 */

class ImageLoader private constructor() {

    /**
     * 提供全局替换图片加载框架的接口，若切换其它框架，可以实现一键全局替换
     */
    fun setGlobalImageLoader(loader: ILoaderStrategy) {
        sLoader = loader
    }

    fun load(url: String?): LoaderOptions {
        return LoaderOptions(url)
    }

    fun load(drawable: Drawable): LoaderOptions {
        return LoaderOptions(drawable)
    }

    fun load(drawableId: Int): LoaderOptions {
        return LoaderOptions(drawableId)
    }

    fun load(file: File): LoaderOptions {
        return LoaderOptions(file)
    }

    fun load(uri: Uri): LoaderOptions {
        return LoaderOptions(uri)
    }

    /**
     * 优先使用实时设置的图片loader，其次使用全局设置的图片loader
     * @param options
     */
    fun loadOptions(options: LoaderOptions) {
        val loader = options.loader
        if (loader!=null) {
            loader.loadImage(options)
        } else {
            sLoader?.loadImage(options)
        }
    }

    fun clearMemoryCache(context: Context) {
        //checkNotNull()
        sLoader?.clearMemoryCache(context)

    }

    fun clearDiskCache(context: Context) {
        //checkNotNull()
        sLoader?.clearDiskCache(context)
    }

    private fun checkNotNull() {
        if (sLoader == null) {
            throw NullPointerException("you must be set your imageLoader at first!")
        }
    }

    companion object {
        private var sLoader: ILoaderStrategy? = null
        @Volatile
        private var sInstance: ImageLoader? = null

        //
        @JvmStatic
        val instance: ImageLoader
            get() {
                if (sInstance == null) {
                    synchronized(ImageLoader::class.java) {
                        if (sInstance == null) {
                            sInstance = ImageLoader()
                        }
                    }
                }
                return sInstance!!
            }
    }
}
