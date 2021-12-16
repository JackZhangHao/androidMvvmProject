package cn.org.yxj.lib_imageloader.utils;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import cn.org.yxj.lib_imageloader.ILoaderStrategy;
import cn.org.yxj.lib_imageloader.LoaderOptions;


public class GlideImageLoader implements ILoaderStrategy {

    @Override
    public void loadImage(LoaderOptions opt) {
        RequestOptions options = new RequestOptions();
        if (opt.isCircle()) {
            options.centerCrop()
                    .circleCrop()
                    .placeholder(opt.getPlaceholder())
                    .error(opt.getErrorPic());
        } else if (opt.isRoundConer()) {
            options.centerCrop()
                    .transform(new RoundedCorners((int) opt.getBitmapAngle()))
                    .placeholder(opt.getPlaceholder())
                    .error(opt.getErrorPic());
        } else {
            if (opt.isCenterInside()) {
                options.centerInside()
                        .placeholder(opt.getPlaceholder())
                        .error(opt.getErrorPic());
            } else if (opt.isCenterCrop()) {
                options.centerCrop()
                        .placeholder(opt.getPlaceholder())
                        .error(opt.getErrorPic());
            } else if (opt.isFitCenter()) {
                options.fitCenter()
                        .placeholder(opt.getPlaceholder())
                        .error(opt.getErrorPic());
            }

        }

        if (opt.getTargetWidth() > 0 && opt.getTargetHeight() > 0) {
            options.override(opt.getTargetWidth(), opt.getTargetHeight());
        }
        if (opt.targetView == null) {
            return;
        }
        if (opt.targetView instanceof ImageView) {
            Context context = opt.targetView.getContext();
            if (context == null) {
                return;
            }
            if (context instanceof Activity) {
                if (!isReady((Activity) context)) {
                    return;
                }
            }
            if (opt.getUrl() != null) {
                Glide.with(context).load(opt.getUrl()).apply(options).into((ImageView) opt.targetView);
            } else if (opt.file != null) {
                Glide.with(context).load(opt.file).apply(options).into((ImageView) opt.targetView);
            } else if (opt.getDrawableResId() != 0) {
                Glide.with(context).load(opt.getDrawableResId()).apply(options).into((ImageView) opt.targetView);
            } else if (opt.uri != null) {
                Glide.with(context).load(opt.uri).apply(options).into((ImageView) opt.targetView);
            } else if (opt.drawable != null) {
                Glide.with(context).load(opt.drawable).apply(options).into((ImageView) opt.targetView);
            } else if (opt.bitmap != null) {
                Glide.with(context).load(opt.bitmap).apply(options).into((ImageView) opt.targetView);
            }

        }

    }

    public boolean isReady(Context context){
        if(context!=null&&context instanceof  Activity){
            Activity activity=(Activity) context;
        return  activity.isDestroyed()&&activity.isFinishing();
        }
        return false;

    }


    @Override
    public void clearMemoryCache(Context context) {
        GlideCacheUtil.getInstance().clearImageMemoryCache(context);
    }

    @Override
    public void clearDiskCache(Context context) {
        GlideCacheUtil.getInstance().clearImageDiskCache(context);
    }

}
