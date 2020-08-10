package com.kepco.informationboard.ConstructionMenu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.kepco.informationboard.R;

/**
 * Created by keplor@naver.com on 2020-08-09
 * Github : http//github.com/EulerCauchyEquation
 */
public class ConstructionFileView extends LinearLayout {
    private ImageView fileImageView;
    private TextView fileNameView;

    public ConstructionFileView(Context context) {
        super(context);
        init(context);
    }

    public ConstructionFileView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.construction_item, this, true);

        fileImageView = findViewById(R.id.iv_tm_item_image);
        fileNameView = findViewById(R.id.tv_tm_item_name);
    }

    public void setImage(int imageId) {
        fileImageView.setImageResource(imageId);
    }

    public void setFileName(String name) {
        fileNameView.setText(name);
    }
}
