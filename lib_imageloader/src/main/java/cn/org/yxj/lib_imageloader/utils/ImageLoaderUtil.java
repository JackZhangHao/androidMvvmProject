package cn.org.yxj.lib_imageloader.utils;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;


import org.jetbrains.annotations.NotNull;

import java.io.File;

import cn.org.yxj.lib_imageloader.ImageLoader;
import cn.org.yxj.lib_imageloader.R;


/**
 * Date :2019/10/30 9:02
 * author:lhj
 * description:通用图片加载工具类
 */
public class ImageLoaderUtil {
    static ImageLoaderUtil instance;

    public ImageLoaderUtil() {
    }

    public static ImageLoaderUtil getInstance() {
        if (null == instance) {
            synchronized (ImageLoaderUtil.class) {
                if (null == instance) {
                    instance = new ImageLoaderUtil();
                }
            }
        }
        return instance;
    }

    /**
     * 普通加载
     */
    public void loadImage(String url, ImageView imageView, int resId) {
        if (imageView == null) {
            return;
        }
        ImageLoader.getInstance()
                .load(url)
                .centerCrop()
                .placeholder(resId)
                .error(resId)
                .into(imageView);

    }

    /**
     * 加载scaleType为FitCenter的图片(用于图片预览)
     */
    public void loadFitCenterImage(String url, ImageView imageView, int resId) {
        if (imageView == null) {

            return;
        }
        ImageLoader.getInstance()
                .load(url)
                .fitCenter()
                .placeholder(resId)
                .error(resId)
                .into(imageView);

    }

    public void loadGlideImage(String url, ImageView imageView, int width, int height) {
        if (imageView == null) {

            return;
        }
        Glide.with(imageView.getContext())
                .load(url)
                .override(width, height)
                .into(imageView);

    }

    public void loadFixedImage(String url, ImageView imageView, int resId, int size) {
        if (imageView == null) {

            return;
        }
        ImageLoader.getInstance()
                .load(url)
                .centerCrop()
                .resize(size, size)
                .placeholder(resId)
                .error(resId)
                .into(imageView);

    }

    public void loadFixedImage(int drawableId, ImageView imageView, int resId, int size) {
        if (imageView == null) {

            return;
        }
        ImageLoader.getInstance()
                .load(drawableId)
                .centerCrop()
                .resize(size, size)
                .placeholder(resId)
                .error(resId)
                .into(imageView);

    }

    private static int cover_default_resid = 0;

    private static int icon_default_avatar = 0;

    private static int splash_default = 0;
    private static int news_pic_default = 0;

    public void loadImage(String url, ImageView imageView) {
        loadImage(url, imageView, cover_default_resid);
    }

    /**
     * 加载固定宽高图片
     *
     * @param resId  占位图资源id
     * @param width  目标图片宽度
     * @param height 目标图片高度
     */
    public void loadImage(@Nullable String url, @Nullable ImageView imageView, @DrawableRes int resId, int width, int height) {
        if (imageView == null) {
            return;
        }
        ImageLoader.getInstance()
                .load(url)
                .centerCrop()
                .resize(width, height)
                .placeholder(resId)
                .error(resId)
                .into(imageView);

    }


    public void loadImage(Uri uri, ImageView imageView, @DrawableRes int placeholderId, int width, int height) {
        if (uri == null || imageView == null) {
            return;
        }
        ImageLoader.getInstance().load(uri)
                .centerCrop()
                .placeholder(placeholderId)
                .resize(width, height)
                .into(imageView);
    }


    public void loadSplashImage(String url, ImageView imageView) {
        ImageLoader.getInstance()
                .load(url)
                .centerCrop()
                .error(splash_default)
                .into(imageView);
    }

    /**
     * 加载图片指定圆角
     *
     * @param radius 圆角
     */
    public void loadRoundBoundImage(String url, ImageView imageView, int radius) {
        if (imageView == null || imageView.getContext() == null) {
            return;
        }
        getRoundOption(url, imageView, radius)
                .into(imageView);
    }

    /**
     * 加载图片指定圆角、指定占位图
     */
    public void loadRoundBoundImage(String url, ImageView imageView, int radius, @DrawableRes int placeHolder) {
        if (imageView == null || imageView.getContext() == null) {
            return;
        }
        getRoundOption(url, imageView, radius, placeHolder)
                .into(imageView);
    }

    @NotNull
    private RequestBuilder<Drawable> getRoundOption(@Nullable String url, ImageView imageView, int radius) {
        return getRoundOption(url, imageView, radius, news_pic_default);
    }

    @NotNull
    private RequestBuilder<Drawable> getRoundOption(@Nullable String url, ImageView imageView, int radius, @DrawableRes int placeHolder) {
        return Glide.with(imageView.getContext())
                .load(url)

                //Meizu M1 4.4.4 java.lang.ClassCastException: int[] cannot be cast to java.lang.Object[]
                //Glide官方已收录该bug，但到4.11.0仍然未修复
                .transform(new CenterCrop(), new RoundedCorners(radius))
                .placeholder(placeHolder)
                .error(placeHolder);
    }

    /**
     * 加载指定圆角和宽高的图片
     *
     * @param radius 圆角
     * @param width  宽度
     * @param height 高度
     */
    public void loadRoundImage(@Nullable String url, ImageView imageView, int radius, @DimenRes int width, @DimenRes int height) {
        loadRoundImage(url, imageView, radius, width, height, news_pic_default);
    }

    /**
     * 加载指定圆角和宽高的图片
     *
     * @param radius 圆角
     * @param width  宽度
     * @param height 高度
     */
    public void loadRoundImage(@Nullable String url, ImageView imageView, int radius, @DimenRes int width,
                               @DimenRes int height, @DrawableRes int placeHolder) {
        if (imageView == null || imageView.getContext() == null) {
            return;
        }
        getRoundOption(url, imageView, radius, placeHolder)
                .override(imageView.getContext().getResources().getDimensionPixelOffset(width),
                        imageView.getContext().getResources().getDimensionPixelOffset(height))
                .into(imageView);
    }

    /**
     * @param radius 圆角
     * @param width  宽度，像素
     * @param height 高度，像素
     */
    public void loadRoundImageWithPixel(@Nullable String url, ImageView imageView, int radius, int width, int height) {
        loadRoundImageWithPixel(url, imageView, radius, width, height, news_pic_default);
    }

    /**
     * @param radius      圆角
     * @param width       宽度，像素
     * @param height      高度，像素
     * @param placeHolder 占位图
     */
    public void loadRoundImageWithPixel(@Nullable String url, ImageView imageView, int radius, int width, int height, @DrawableRes int placeHolder) {
        if (imageView == null || imageView.getContext() == null) {
            return;
        }
        getRoundOption(url, imageView, radius, placeHolder)
                .override(width, height)
                .into(imageView);
    }

    /**
     * 加载圆形图片
     */
    public void loadCircleImage(@Nullable String url, ImageView imageView, @DrawableRes int placeHolder) {
        if (imageView == null || imageView.getContext() == null) {
            return;
        }
        getCircleOption(url, imageView, placeHolder)
                .into(imageView);
    }

    /**
     * 加载圆形图片
     */
    public void loadCircleImageWithSize(@Nullable String url, ImageView imageView, @DimenRes int size) {
        loadCircleImage(url, imageView, icon_default_avatar, size);
    }

    /**
     * 加载圆形图片
     */
    public void loadCircleImage(@Nullable String url, ImageView imageView, @DrawableRes int placeHolder, @DimenRes int size) {
        if (imageView == null || imageView.getContext() == null) {
            return;
        }
        getCircleOption(url, imageView, placeHolder)
                .override(imageView.getContext().getResources().getDimensionPixelOffset(size))
                .into(imageView);
    }

    @NotNull
    private RequestBuilder<Drawable> getCircleOption(@Nullable String url, ImageView imageView, @DrawableRes int placeHolder) {
        return Glide.with(imageView.getContext())
                .load(url)
                .centerCrop()
                .circleCrop()
                .placeholder(placeHolder)
                .error(placeHolder);
    }

    /**
     * 加载本地文件
     */
    public void loadFileRoundImage(@Nullable File file, ImageView imageView, int radius, int width, int height, @DrawableRes int placeHolder) {
        Glide.with(imageView.getContext())
                .load(file)
                .transform(new CenterCrop(), new RoundedCorners(radius))
                .override(width, height)
                .placeholder(placeHolder)
                .error(placeHolder)
                .into(imageView);
    }

}
