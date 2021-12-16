package cn.org.yxj.lib_imageloader

import android.graphics.Bitmap


interface BitmapCallBack {

    fun onBitmapLoaded(bitmap: Bitmap)

    fun onBitmapFailed(e: Exception)

    class EmptyCallback : BitmapCallBack {


        override fun onBitmapLoaded(bitmap: Bitmap) {

        }

        override fun onBitmapFailed(e: Exception) {

        }
    }
}
