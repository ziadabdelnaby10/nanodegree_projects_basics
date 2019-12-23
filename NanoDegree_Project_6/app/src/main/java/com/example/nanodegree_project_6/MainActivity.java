package com.example.nanodegree_project_6;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<ParsedJson>> {

    private Uri.Builder builder;
    private static String GARDIUNS_URL;
    public static final String LOG_TAG = MainActivity.class.getSimpleName();
    private static final int GARDIUNS_LOADER_ID = 1;

    private CustomRecycleAdapter adapter;
    private RecyclerView recyclerView;
    private TextView noDataTextView;
    private ProgressBar loadingIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noDataTextView = findViewById(R.id.nodataText);
        recyclerView = findViewById(R.id.rec);
        loadingIndicator = findViewById(R.id.loading_indicator);


        ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();

        if (isConnected) {
            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(GARDIUNS_LOADER_ID, null, this);
        } else {
            loadingIndicator.setVisibility(View.GONE);
            noDataTextView.setText(R.string.no_Internet);
        }
    }

    @Override
    public Loader<ArrayList<ParsedJson>> onCreateLoader(int id, Bundle args) {

        builder = new Uri.Builder().scheme("https")
                .authority("content.guardianapis.com")
                .appendPath("search")
                .appendQueryParameter("show-tags" , "contributor")
                .appendQueryParameter("api-key", getResources().getString(R.string.api_key));
        GARDIUNS_URL = builder.build().toString();
        return new NewsLoader(this, GARDIUNS_URL);
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<ParsedJson>> loader, ArrayList<ParsedJson> data) {

        if (data != null && !data.isEmpty()) {
            adapter = new CustomRecycleAdapter(this, data);
            noDataTextView.setVisibility(View.GONE);
            loadingIndicator.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            recyclerView.setAdapter(adapter);
        } else {
            recyclerView.setVisibility(View.GONE);
            noDataTextView.setVisibility(View.VISIBLE);
            loadingIndicator.setVisibility(View.GONE);
            noDataTextView.setText(R.string.no_data);
        }

    }

    @Override
    public void onLoaderReset(Loader<ArrayList<ParsedJson>> loader) {
        adapter = new CustomRecycleAdapter(this, new ArrayList<ParsedJson>());
    }

}
