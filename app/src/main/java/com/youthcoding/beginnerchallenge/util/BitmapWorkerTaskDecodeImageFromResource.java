package com.youthcoding.beginnerchallenge.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;

import com.youthcoding.beginnerchallenge.util.BitMapConversions;

import java.lang.ref.WeakReference;

/**
 * Created by r730819 on 8/19/2016.
 *
 * This class is used to do asyncronous call
 * to load a Bitmap off the main thread.
 *
 * Currently only works with decode from
 * resources.
 */
public class BitmapWorkerTaskDecodeImageFromResource extends AsyncTask<Integer, Void, Bitmap> {


    private final WeakReference<ImageView> imageViewReference;
    private int data = 0;
    private int width = 0;
    private int height = 0;
    private Context context;
    private View mProgressView;
    private View mFragImageView;


    /**
     * Construct that sets all
     * the variables to be used
     * in the class
     *
     * @param imageView Image view to set bitmap to on finish
     * @param setContext Context of the activity calling this function
     * @param progressView Progress view to hide after image load
     * @param fragImageView The parent image to show after load
     */
    public BitmapWorkerTaskDecodeImageFromResource(ImageView imageView, Context setContext,
                                                   View progressView, View fragImageView) {

        // Use a WeakReference to ensure the ImageView can be garbage collected
        imageViewReference = new WeakReference<ImageView>(imageView);

        this.mProgressView = progressView;
        this.mFragImageView = fragImageView;
        this.context = setContext;
    }


    /**
     * Decodes the image in the background
     * and calls onPostExecute when done.
     *
     * Uses the Bitmap decoder functions
     *
     * @param params Receives an vargs of ints.
     *               Data -> resourceID
     *               Width -> Image requested width
     *               Height -> Image request height
     *
     * @return Bitmap to be set
     */
    @Override
    public Bitmap doInBackground(Integer... params) {
        data = params[0];
        width = params[1];
        height = params[2];

        return BitMapConversions
                .decodeSampledBitmapFromResource(context.getResources(), data, width, height);

    }

    /**
     * Once complete check if the image view
     * is not null and set the image if not.
     *
     * Also call progressbar helper and hide
     * the progress bar and show the fragment
     * contents
     *
     * @param bitmap Bitmap to be set
     */
    @Override
    public void onPostExecute(Bitmap bitmap) {
        if (imageViewReference != null && bitmap != null) {
            final ImageView imageView = imageViewReference.get();
            if (imageView != null) {
                imageView.setImageBitmap(bitmap);
            }
        }


        ProgressBar progressBar = new ProgressBar();
        progressBar.showProgress(mFragImageView, mProgressView, false, context);

    }
}
