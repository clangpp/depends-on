package com.clangpp.depends_on;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A placeholder fragment containing a simple view.
 * Created by clangpp on 11/27/14.
 */
public class ChecklistFragment extends Fragment {

    private RecyclerView mChecklistView;
    private RecyclerView.Adapter mChecklistAdapter;
    private RecyclerView.LayoutManager mChecklistLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        mChecklistView = (RecyclerView) rootView.findViewById(R.id.checklist_view);

        mChecklistLayoutManager = new LinearLayoutManager(getActivity());
        mChecklistView.setLayoutManager(mChecklistLayoutManager);

        // TODO(clangpp): Replaces this with real data.
        String[] dummyValues = new String[]{"item 1", "item 2", "item 3"};

        mChecklistAdapter = new ChecklistAdapter(dummyValues);
        mChecklistView.setAdapter(mChecklistAdapter);

        return rootView;
    }
}
