package com.kepco.informationboard.TroubleCaseMenu;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.kepco.informationboard.ConstructionMenu.ConstructionFile;
import com.kepco.informationboard.ConstructionMenu.ConstructionFileAdapter;
import com.kepco.informationboard.HomeMenu.MainActivity;
import com.kepco.informationboard.R;

/**
 * Created by keplor@naver.com on 2020-08-09
 * Github : http//github.com/EulerCauchyEquation
 */
public class TroubleCaseFragment extends Fragment {
    private Context context;
    private MainActivity activity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_construction, container, false);

        setHasOptionsMenu(true);
        setUpToolbar(rootView);

        ListView fileView = rootView.findViewById(R.id.lv_tm_item);
        ConstructionFileAdapter adapter = new ConstructionFileAdapter(context);
        adapter.addItem(new ConstructionFile(R.drawable.ic_pdf, "유사 고장 사례"));
        fileView.setAdapter(adapter);
        return rootView;
    }

    private void setUpToolbar(View view) {
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        activity = (MainActivity) getActivity();
        ActionBar actionBar = null;
        if (activity != null) {
            activity.setSupportActionBar(toolbar);
            actionBar = activity.getSupportActionBar();
        }
        if (actionBar != null) {
            actionBar.setTitle("");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.construction_toolbar, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        final int itemId = item.getItemId();

        if (itemId == R.id.home || itemId == android.R.id.home) {
            activity.onFragmentChange(0);
        }
        return super.onOptionsItemSelected(item);
    }
}
