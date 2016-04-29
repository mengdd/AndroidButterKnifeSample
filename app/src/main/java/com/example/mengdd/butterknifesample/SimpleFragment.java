package com.example.mengdd.butterknifesample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class SimpleFragment extends Fragment {

    @BindView(R.id.fragment_text_view)
    TextView mTextView;
    private Unbinder unbinder;

    public SimpleFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_simple, container, false);

        unbinder = ButterKnife.bind(this, view);

        mTextView.setText("TextView in Fragment are found!");
        //This method doc:


        //        /**
        //         * Inject annotated fields and methods in the specified {@code target} using the {@code source}
        //         * {@link View} as the view root.
        //         *
        //         * @param target Target class for field injection.
        //         * @param source View root on which IDs will be looked up.
        //         */
        //        public static void inject(Object target, View source) {
        //            inject(target, source, Finder.VIEW);
        //        }
        return view;
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }
}
