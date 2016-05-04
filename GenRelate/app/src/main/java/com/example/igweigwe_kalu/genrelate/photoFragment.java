package com.example.igweigwe_kalu.genrelate;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

/**
 * Created by igweigwe-kalu on 4/24/16.
 */
public class photoFragment extends Fragment {

    private RecyclerView mPhotoRecyclerView;
    private static final String TAG = "photoFragment";
    private List<GalleryItem> mItems = new ArrayList<>();
    private photoDownloader<PhotoHolder> mPhotoDownloader;
    public String currentGenre;


    public static photoFragment newInstance() {
        return new photoFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getActivity().getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("thisGenre");
            currentGenre = value;
        }

        setRetainInstance(true);
        new FetchItemsTask().execute();
       android.os.Handler responseHandler = new android.os.Handler();
        mPhotoDownloader = new photoDownloader<>(responseHandler);
        mPhotoDownloader.setThumbnailDownloadListener(
                new photoDownloader.ThumbnailDownloadListener<PhotoHolder>() {
                    @Override
                    public void onThumbnailDownloaded(PhotoHolder photoHolder, Bitmap bitmap) {
                        Drawable drawable = new BitmapDrawable(getResources(), bitmap);
                        photoHolder.bindDrawable(drawable);
                    }
                }
        );

        mPhotoDownloader.start();
        mPhotoDownloader.getLooper();
        Log.i(TAG, "background thread started");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_instruments, container, false);

        mPhotoRecyclerView = (RecyclerView) v.findViewById(R.id.photo_recycler_view);
        mPhotoRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));

        setupAdapter();
        return v;
    }

    @Override
     public void onDestroyView() {
        super.onDestroyView();
        mPhotoDownloader.clearQueue();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPhotoDownloader.quit();
        Log.i(TAG,"Background thread destroyed");
    }

    private void setupAdapter(){
        if(isAdded()){
            mPhotoRecyclerView.setAdapter(new PhotoAdapter(mItems));
        }
    }

    private class PhotoHolder extends RecyclerView.ViewHolder {
        private ImageView mItemImageView;

        public PhotoHolder(View itemView) {
            super(itemView);
            //GenreFragment.genreHolder genreHolder = new GenreFragment().new genreHolder(itemView);
            mItemImageView = (ImageView)itemView.findViewById(R.id.fragment_instrument);
        }

        public void bindDrawable(Drawable drawable) {
            mItemImageView.setImageDrawable(drawable);
        }
    }

    private class PhotoAdapter extends RecyclerView.Adapter<PhotoHolder> {

        private List<GalleryItem> mGalleryItems;

        public PhotoAdapter(List<GalleryItem> galleryItems) {
            mGalleryItems = galleryItems;
        }

        @Override
        public PhotoHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View view = inflater.inflate(R.layout.instrument_view, viewGroup, false);
            return new PhotoHolder(view);
        }

        @Override
        public void onBindViewHolder(PhotoHolder photoHolder, int position) {
            GalleryItem galleryItem = mGalleryItems.get(position);
            Drawable placeholder = getResources().getDrawable(R.drawable.genrelateemblemcolor);
            photoHolder.bindDrawable(placeholder);
            mPhotoDownloader.queueThumbnail(photoHolder,galleryItem.getmURL());
        }

        @Override
        public int getItemCount() {
            return mGalleryItems.size();
        }
    }

    private class FetchItemsTask extends AsyncTask<Void,Void,List<GalleryItem>> {
        @Override
        protected List<GalleryItem> doInBackground(Void... params) {


            String query = currentGenre + " Music";

            if (query == null) {
                return new FlickrFetchr().fetchRecentPhotos();
            } else {
                return new FlickrFetchr().searchPhotos(query);
            }
        }
        @Override
        protected void onPostExecute(List<GalleryItem> items) {
            mItems = items;
            setupAdapter();
        }
    }

}
