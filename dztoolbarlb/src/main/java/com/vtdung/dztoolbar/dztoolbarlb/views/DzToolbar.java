package com.vtdung.dztoolbar.dztoolbarlb.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vtdung.dztoolbar.dztoolbarlb.R;
import com.vtdung.dztoolbar.dztoolbarlb.listener.DztoolbarClickListener;

public class DzToolbar extends LinearLayout implements View.OnClickListener {

    ImageView ivLeft;
    TextView tvLeft;
    ImageView ivRight;
    TextView tvRight;
    TextView tvTitle;
    TextView tvLeftBadge;
    TextView tvRightBadge;

    private DztoolbarClickListener clickListener;

    public DzToolbar(Context context) {
        super(context);
        init(null, context);
    }

    public DzToolbar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs, context);
    }

    public DzToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, context);
    }

    private void init(@Nullable AttributeSet attrs, Context context) {
        View v = inflate(context, R.layout.dztoolbar, this);

        ivLeft = v.findViewById(R.id.iv_left);
        tvLeft = v.findViewById(R.id.tv_left);
        ivRight = v.findViewById(R.id.iv_right);
        tvRight = v.findViewById(R.id.tv_right);
        tvTitle = v.findViewById(R.id.tv_title);
        tvLeftBadge = v.findViewById(R.id.tv_left_badge);
        tvRightBadge = v.findViewById(R.id.tv_right_badge);

        tvRight.setTextColor(Color.BLACK);
        tvLeft.setTextColor(Color.BLACK);

        ivLeft.setOnClickListener(this);
        tvLeft.setOnClickListener(this);
        ivRight.setOnClickListener(this);
        tvRight.setOnClickListener(this);

        if (attrs == null) {
            return;
        }

        TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.CustomToolbar);
        if (ta.hasValue(R.styleable.CustomToolbar_leftText)) {
            String value = ta.getString(R.styleable.CustomToolbar_leftText);
            tvLeft.setText(value);
        }

        if (ta.hasValue(R.styleable.CustomToolbar_leftImage)) {
            Drawable value = ta.getDrawable(R.styleable.CustomToolbar_leftImage);
            ivLeft.setImageDrawable(value);
        }

        if (ta.hasValue(R.styleable.CustomToolbar_rightText)) {
            String value = ta.getString(R.styleable.CustomToolbar_rightText);
            tvRight.setText(value);
        }

        if (ta.hasValue(R.styleable.CustomToolbar_rightImage)) {
            Drawable value = ta.getDrawable(R.styleable.CustomToolbar_rightImage);
            ivRight.setImageDrawable(value);
        }

        if (ta.hasValue(R.styleable.CustomToolbar_title)) {
            String value = ta.getString(R.styleable.CustomToolbar_title);
            tvTitle.setText(value);
        }

        if (ta.hasValue(R.styleable.CustomToolbar_backgroundColor)) {
            int value = ta.getColor(R.styleable.CustomToolbar_backgroundColor, 0);
            this.setBackgroundColor(value);
        }

        ta.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public TextView getTvTitle() {
        return this.tvTitle;
    }

    public TextView getTvLeft() {
        return tvLeft;
    }

    public TextView getTvRight() {
        return tvRight;
    }

    public void setVisibleLeftBadge(boolean isVisible) {
        if (isVisible) {
            tvLeftBadge.setVisibility(VISIBLE);
        } else {
            tvLeftBadge.setVisibility(GONE);
        }
    }

    public void setLeftImage(Drawable resource) {
        ivLeft.setImageDrawable(resource);
    }

    public void setRightImage(Drawable resource) {
        ivRight.setImageDrawable(resource);
    }

    public void setVisibleRightBadge(boolean isVisible) {
        if (isVisible) {
            tvRightBadge.setVisibility(VISIBLE);
        } else {
            tvRightBadge.setVisibility(GONE);
        }
    }

    public void setLeftBadgeNumber(int number) {
        tvLeftBadge.setText(String.valueOf(number));
    }

    public void setRightBadgeNumber(int number) {
        tvRightBadge.setText(String.valueOf(number));
    }

    public void addClickListener(DztoolbarClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public void onClick(View view) {

        int i = view.getId();
        if (i == R.id.iv_left || i == R.id.tv_left) {
            if (clickListener != null) {
                clickListener.leftClickListener();
            }

        } else if (i == R.id.iv_right || i == R.id.tv_right) {
            if (clickListener != null) {
                clickListener.rightClickListener();
            }

        }
    }

    public void setTitle(String title) {
        this.tvTitle.setText(title);
    }
}

