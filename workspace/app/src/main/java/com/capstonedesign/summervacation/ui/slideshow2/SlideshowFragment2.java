package com.capstonedesign.summervacation.ui.slideshow2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.capstonedesign.summervacation.R;


public class SlideshowFragment2 extends Fragment {

    private SlideshowViewModel2 slideshowViewModel2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel2 =
                new ViewModelProvider(this).get(SlideshowViewModel2.class);
        View root = inflater.inflate(R.layout.fragment_slideshow2, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow2);
        slideshowViewModel2.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}