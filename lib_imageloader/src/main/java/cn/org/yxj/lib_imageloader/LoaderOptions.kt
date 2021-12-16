package cn.org.yxj.lib_imageloader

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.view.View

import androidx.annotation.DrawableRes

import java.io.File

/**
 * 该类为图片加载框架的通用属性封装，不能耦合任何一方的框架
 */
open class LoaderOptions : ImageConfig {
    var isCenterCrop: Boolean = false
    var isFitCenter: Boolean = false
    var isCircle: Boolean = false
    var isRoundConer: Boolean = false
    var isCenterInside: Boolean = false
    var skipLocalCache: Boolean = false //是否缓存到本地
    var skipNetCache: Boolean = false
    var config: Bitmap.Config = Bitmap.Config.RGB_565

    var targetWidth: Int = 0
    var targetHeight: Int = 0
    var bitmapAngle: Float = 0.toFloat() //圆角角度
    var degrees: Float = 0.toFloat() //旋转角度.注意:picasso针对三星等本地图片，默认旋转回0度，即正常位置。此时不需要自己rotate
    lateinit var targetView: View//targetView展示图片
    lateinit var callBack: BitmapCallBack
    lateinit var file: File
    lateinit var bitmap: Bitmap
    lateinit var drawable: Drawable
    lateinit var placeholderDrawable: Drawable

    var drawableResId: Int = 0
    var reourceId: Int = 0

    lateinit var uri: Uri
    var loader: ILoaderStrategy? = null//实时切换图片加载库

    constructor(url: String?) {
        this.url = url
    }

    constructor(file: File) {
        this.file = file
    }

    constructor(bitmap: Bitmap) {
        this.bitmap = bitmap
    }

    constructor(drawable: Drawable) {
        this.drawable = drawable
    }

    constructor(reourceId: Int) {
        this.reourceId = reourceId
    }

    fun drawableResId(drawableResId: Int): LoaderOptions {
        this.drawableResId = drawableResId
        return this
    }

    constructor(uri: Uri) {
        this.uri = uri
    }

    fun isCircle(isCircleCrop: Boolean): LoaderOptions {
        this.isCircle = isCircleCrop
        return this
    }

    fun isRoundConer(isRoundConer: Boolean): LoaderOptions {
        this.isRoundConer = isRoundConer
        return this
    }


    fun into(targetView: View) {
        this.targetView = targetView
        ImageLoader.instance.loadOptions(this)
    }

    fun bitmap(callBack: BitmapCallBack) {
        this.callBack = callBack
        ImageLoader.instance.loadOptions(this)
    }

    fun loader(imageLoader: ILoaderStrategy): LoaderOptions {
        this.loader = imageLoader
        return this
    }

    fun placeholder(@DrawableRes placeholderResId: Int): LoaderOptions {
        this.placeholder = placeholderResId
        return this
    }

    fun placeholder(placeholder: Drawable): LoaderOptions {
        this.placeholderDrawable = placeholder
        return this
    }

    fun error(@DrawableRes errorResId: Int): LoaderOptions {
        this.errorPic = errorResId
        return this
    }

    fun centerCrop(): LoaderOptions {
        isCenterCrop = true
        return this
    }

    fun centerInside(): LoaderOptions {
        isCenterInside = true
        return this
    }

    fun fitCenter(): LoaderOptions {
        isFitCenter = true
        return this
    }

    fun config(config: Bitmap.Config): LoaderOptions {
        this.config = config
        return this
    }

    fun resize(targetWidth: Int, targetHeight: Int): LoaderOptions {
        this.targetWidth = targetWidth
        this.targetHeight = targetHeight
        return this
    }

    /**
     * 圆角
     * @param bitmapAngle   度数
     * @return
     */
    fun angle(bitmapAngle: Float): LoaderOptions {
        this.bitmapAngle = bitmapAngle
        isRoundConer = true
        return this
    }

    fun skipLocalCache(skipLocalCache: Boolean): LoaderOptions {
        this.skipLocalCache = skipLocalCache
        return this
    }

    fun skipNetCache(skipNetCache: Boolean): LoaderOptions {
        this.skipNetCache = skipNetCache
        return this
    }

    fun rotate(degrees: Float): LoaderOptions {
        this.degrees = degrees
        return this
    }

}


