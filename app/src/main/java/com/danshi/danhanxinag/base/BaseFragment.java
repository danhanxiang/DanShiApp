package com.danshi.danhanxinag.base;

import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by 20939 on 2016/11/16.
 */
public class BaseFragment extends Fragment {

    protected <T extends View> T $(View view, int id) {
        return (T) view.findViewById(id);
    }
}
