package com.nychareport.backlog.misc;

import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;

import com.nychareport.backlog.BackLogApplication;
import com.nychareport.backlog.R;
import com.nychareport.backlog.customviews.CustomTypefaceSpan;

/**
 * Utility class
 */
public class Utils {

    /**
     * Encode user email to use it as a Firebase key (Firebase does not allow "." in the key name)
     * Encoded email is also used as "userEmail", list and item "owner" value
     */
    public static String encodeEmail(String userEmail) {
        return userEmail.replace(".", ",");
    }

    //    /**
//     * Email is being decoded just once to display real email in AutocompleteFriendAdapter
//     *
//     * @see com.udacity.firebase.shoppinglistplusplus.ui.sharing.AutocompleteFriendAdapter
//     */
    public static String decodeEmail(String userEmail) {
        return userEmail.replace(",", ".");
    }

    public static CharSequence prepareCreatorTimestamp(String timestamp, Context context) {

        if (timestamp != null && !timestamp.isEmpty()) {
            try {
                Long publishTimeMillis = Long.valueOf(timestamp);
                String readablePublishTime = getReadableTime(System.currentTimeMillis() - publishTimeMillis);

                SpannableString spannableString = new SpannableString(readablePublishTime);

                /* Setting typeface span*/
                spannableString.setSpan(
                        new CustomTypefaceSpan(context.getAssets(),
                                context.getString(R.string.typeface_regular)),
                        0,
                        readablePublishTime.length(),
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                );

                /* Setting font-color span*/
                spannableString.setSpan(
                        new ForegroundColorSpan(context.getResources().getColor(R.color.medium)),
                        0,
                        readablePublishTime.length(),
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                );

                /* Setting font-size span*/

                int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                        12,
                        context.getResources().getDisplayMetrics());
                spannableString.setSpan(
                        new AbsoluteSizeSpan(px),
                        0,
                        readablePublishTime.length(),
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                );

                return spannableString;
            } catch (Exception ignored) {
            }
        }

        return "";
    }

    private static String getReadableTime(Long milliseconds) {
        double temp = Math.floor(milliseconds / 1000);
        double years = Math.floor(temp / 31536000);
        if (years > 0) {
            return (int) years + "y";
        }
        double weeks = Math.floor((temp %= 31536000) / 604800);
        if (weeks > 0) {
            return (int) weeks + "w";
        }
        double days = Math.floor((temp %= 31536000) / 86400);
        if (days > 0) {
            return (int) days + "d";
        }
        double hours = Math.floor((temp %= 86400) / 3600);
        if (hours > 0) {
            return (int) hours + "h";
        }
        double minutes = Math.floor((temp %= 3600) / 60);
        if (minutes > 0) {
            return (int) minutes + "m";
        }
        double seconds = temp % 60;
        if (seconds > 0) {
            return (int) seconds + "s";
        }
        return "just now";
    }

    public static int convertDPTOPixels(int dp) {
        // Get the screen's density scale
        float scale = BackLogApplication.getCurrentInstance().getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        int convertedPixels = (int) (dp * scale + 0.5f);
        return convertedPixels;
    }

}
