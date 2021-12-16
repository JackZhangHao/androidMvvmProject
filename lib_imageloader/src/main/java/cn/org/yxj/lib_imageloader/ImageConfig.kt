package cn.org.yxj.lib_imageloader

import androidx.annotation.DrawableRes

/**
 * Date :2019/10/29 9:34
 * author:lhj
 * description:
 */
open class ImageConfig {
    var url: String? = null
        protected set
    @DrawableRes
    var placeholder: Int = 0
        protected set
    var errorPic: Int = 0
        protected set
}
