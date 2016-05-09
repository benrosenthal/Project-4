package com.nychareport.backlog.customviews;

/**
 * Created by Ben Rosenthal on 06/05/16.
 */

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.LruCache;
import android.widget.TextView;

import com.nychareport.backlog.R;

public class TypefaceTextView extends TextView {

    private static LruCache<String, Typeface> sTypefaceCache = new LruCache<String, Typeface>(5);

    public TypefaceTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.TypefaceTextView, 0, 0);
        try {
            String typefaceName = a.getString(R.styleable.TypefaceTextView_typeface);
            if (!isInEditMode() && !TextUtils.isEmpty(typefaceName)) {
                Typeface typeface = sTypefaceCache.get(typefaceName);
                if (typeface == null) {
                    typeface = Typeface.createFromAsset(context.getAssets(), typefaceName);
                    sTypefaceCache.put(typefaceName, typeface);
                }
                setTypeface(typeface);

                setPaintFlags(getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
            }
        } finally {
            a.recycle();
        }
    }


}

