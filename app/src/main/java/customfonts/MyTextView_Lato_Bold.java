package customfonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;


public class MyTextView_Lato_Bold extends androidx.appcompat.widget.AppCompatTextView {

    public MyTextView_Lato_Bold(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public MyTextView_Lato_Bold(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyTextView_Lato_Bold(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Lato-Bold.ttf");
            setTypeface(tf);
        }
    }

}