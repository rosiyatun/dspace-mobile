package id.ac.ipb.dspacemobileapps.views;

import android.app.Dialog;
import android.content.Context;
import android.view.ViewGroup;

/**
 * Created by Hanif Affandi Hartanto on 7/25/2015.
 */
public class FullDialog extends Dialog {
    public FullDialog(Context context) {
        super(context);
    }

    public FullDialog(Context context, int theme) {
        super(context, theme);
    }

    protected FullDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    public void onStart() {
        super.onStart();
        setFullScreen();
    }

    public void setFullScreen(){
        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = ViewGroup.LayoutParams.MATCH_PARENT;
        getWindow().setLayout(width, height);
    }
}
