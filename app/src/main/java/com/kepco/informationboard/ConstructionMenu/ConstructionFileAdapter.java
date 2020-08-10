package com.kepco.informationboard.ConstructionMenu;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by keplor@naver.com on 2020-08-09
 * Github : http//github.com/EulerCauchyEquation
 */
public class ConstructionFileAdapter extends BaseAdapter {
    private final Context context;
    private final ArrayList<ConstructionFile> items = new ArrayList<>();

    public ConstructionFileAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    public void addItem(ConstructionFile item) {
        items.add(item);
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ConstructionFileView view;
        if (convertView == null) {
            view = new ConstructionFileView(context);
        } else {
            view = (ConstructionFileView) convertView;
        }
        ConstructionFile constructionFile = items.get(position);
        view.setImage(constructionFile.getImage());
        view.setFileName(constructionFile.getFileName());
        return view;
    }
}
