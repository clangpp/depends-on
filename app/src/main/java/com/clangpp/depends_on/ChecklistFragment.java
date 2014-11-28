package com.clangpp.depends_on;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * A placeholder fragment containing a simple view.
 * Created by clangpp on 11/27/14.
 */
public class ChecklistFragment extends Fragment {

    ListView checklistView;
    ListAdapter checklistAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        checklistView = (ListView) rootView.findViewById(R.id.listview_checklist);

        // TODO(clangpp): Replaces this to real adapter.
        String[] dummyValues = new String[]{"item 1", "item 2", "item 3"};
        checklistAdapter = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_list_item_1, dummyValues);

        checklistView.setAdapter(checklistAdapter);

        return rootView;
    }
}
