package com.kepco.informationboard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

/**
 * Created by keplor@naver.com on 2020-07-25
 * Github : http//github.com/EulerCauchyEquation
 */
public class FloorPlanView extends LinearLayout {
    private ImageView imageView;
    private TextView textView;

    public FloorPlanView(Context context) {
        super(context);

        init(context);
    }

    public FloorPlanView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.floor_plan_item, this, true);
    }
}
