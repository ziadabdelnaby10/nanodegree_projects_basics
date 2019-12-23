package com.example.nanodegree_project_6;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class NewsLoader extends AsyncTaskLoader<ArrayList<ParsedJson>> {

    private String url;

    @Nullable
    @Override
    public ArrayList<ParsedJson> loadInBackground() {
        if (url == null || TextUtils.isEmpty(url))
            return null;

        ArrayList<ParsedJson> parsedData = Utils.fetchEarthquakeData(url);
        return parsedData;
    }

    public NewsLoader(@NonNull Context context, String url) {
        super(context);
        this.url = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}
