package com.youthcoding.beginnerchallenge.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;

/**
 * Created by augustus on 5/16/16.
 *
 * Google Bitmap conversion functions
 * for retrieving the appropriate size
 * Bitmap.
 */
public class BitMapConversions {


    /**
     * Receives a width and height and
     * uses those two parameters to determine
     * how big the Bitmap should be.
     *
     * @param options Bitmap options
     * @param reqWidth Requested width
     * @param reqHeight Requested height
     * @return Factored sample size
     */
    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        Log.e("sampleWidth", String.valueOf(width));
        Log.e("sampleHeight", String.valueOf(height));
        Log.e("reqWidth", String.valueOf(reqWidth));
        Log.e("reqHeight", String.valueOf(reqHeight));

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        Log.e("Sample Size", String.valueOf(inSampleSize));
        return inSampleSize;
    }


    /**
     * Decodes the Bitmap from a resource
     * with its id.  Uses helper function
     * above to get scale factor.
     *
     * @param res Resource file
     * @param resId resource id
     * @param reqWidth requested width
     * @param reqHeight requested height
     * @return Bitmap with scaled size
     */
    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }


    /**
     * Receives a file path and decodes
     * the file and converts to Bitmap
     * scaled to width and height
     *
     * @param filePath String representing the file path
     * @param reqWidth  Requested width
     * @param reqHeight Requested height
     * @return Scaled Bitmap
     */
    public static Bitmap decodeSampledBitmapFromFile(String filePath, int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(filePath, options);
    }


    /**
     * Receives a file path and decodes
     * the file and converts to Bitmap
     * scaled to width and height
     *
     * @param filePath String representing the file path
     * @param reqWidth  Requested width
     * @param reqHeight Requested height
     * @return Scaled Bitmap
     */
    public static Bitmap decodeSampledBitmapFromURI(Uri filePath, int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath.getPath(), options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;

        return BitmapFactory.decodeFile(filePath.getPath(), options);
    }


    /**
     * Receives a byte array along with
     * requested dimensions and returns
     * a bitmap scaled appropriately
     *
     * @param picStr Base 64 byte array
     * @param reqWidth  Requested width
     * @param reqHeight Requested height
     * @return Scaled Bitmap
     */
    public static Bitmap decodeSampledBitmapFromBase64String(byte[] picStr, int reqWidth, int reqHeight){
        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(picStr, 0, picStr.length, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeByteArray(picStr, 0, picStr.length, options);
    }

}
