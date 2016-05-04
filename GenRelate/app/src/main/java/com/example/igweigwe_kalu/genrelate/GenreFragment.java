package com.example.igweigwe_kalu.genrelate;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by igweigwe-kalu on 2/21/16.
 */
public class GenreFragment extends Fragment {

    //implements View.OnClickListener

    public RecyclerView mGenreChoiceRecylcer;
    public genreAdapter mGenreAdapter;
    public List<Genre> mGenreList;
    private genreLab genreLab;
    public String currentGenre;
    public String clicked;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_genrelist, container, false);

        mGenreChoiceRecylcer = (RecyclerView) view.findViewById(R.id.genre_recycler_view);
        mGenreChoiceRecylcer.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    public void updateUI() {

        genreLab = new genreLab(this.getContext());
        List<Genre> allGenres = genreLab.getResults();
        mGenreList = allGenres;
        mGenreAdapter = new genreAdapter(allGenres);
        mGenreChoiceRecylcer.setAdapter(mGenreAdapter);
    }

    public class genreHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public Button mGenreButton;

        public genreHolder(View itemView) {
            super(itemView);
            mGenreButton = (Button) itemView.findViewById(R.id.genrebutton);
            mGenreButton.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            currentGenre = mGenreButton.getText().toString();

            Intent i = SelectionActivity.newIntent(getActivity());
            i.putExtra("thisGenre", currentGenre);
            startActivity(i);
        }


    }

    private class genreAdapter extends RecyclerView.Adapter<genreHolder> {

        private List<Genre> mGenreLists;

        final ListAdapter mListAdapter = new ListAdapter() {
            @Override
            public boolean areAllItemsEnabled() {
                return false;
            }

            @Override
            public boolean isEnabled(int position) {
                return false;
            }

            @Override
            public void registerDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public int getCount() {
                return mGenreLists.size();
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                return null;
            }

            @Override
            public int getItemViewType(int position) {
                return 0;
            }

            @Override
            public int getViewTypeCount() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }
        };

        public genreAdapter(List<Genre> genres) {
            mGenreLists = genres;
        }

        @Override
        public void onBindViewHolder(genreHolder holder, int position) {

            Genre genre;
            genre = mGenreLists.get(position);
            holder.mGenreButton.setText(genre.getGenreName());

        }

        @Override
        public int getItemViewType(int position) {
            return super.getItemViewType(position);
        }

        @Override
        public long getItemId(int position) {
            return super.getItemId(position);
        }

        @Override
        public void onViewRecycled(genreHolder holder) {
            super.onViewRecycled(holder);
        }

        @Override
        public genreHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.fragment_genrebutton, parent, false);
            return new genreHolder(view);
        }


        @Override
        public int getItemCount() {
            return mGenreLists.size();
        }
    }
}
