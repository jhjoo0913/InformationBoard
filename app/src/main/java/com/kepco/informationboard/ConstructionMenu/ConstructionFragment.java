package com.kepco.informationboard.ConstructionMenu;

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

import com.kepco.informationboard.MainActivity;
import com.kepco.informationboard.R;

/**
 * Created by keplor@naver.com on 2020-08-09
 * Github : http//github.com/EulerCauchyEquation
 */
public class ConstructionFragment extends Fragment {
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
    public View onCreateView(
            @NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_construction, container, false);

        setUpToolbar(view);
        setHasOptionsMenu(true);

        ListView fileList = view.findViewById(R.id.lv_tm_item);
        ConstructionFileAdapter adapter = new ConstructionFileAdapter(context);
        adapter.addItem(new ConstructionFile(R.drawable.ic_folder, "공사 관련 비치 서류"));
        adapter.addItem(new ConstructionFile(R.drawable.ic_folder, "안전 관리 목록"));
        adapter.addItem(new ConstructionFile(R.drawable.ic_folder, "맞춤형 작업절차서"));
        fileList.setAdapter(adapter);

        return view;
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
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.construction_toolbar, menu);
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
