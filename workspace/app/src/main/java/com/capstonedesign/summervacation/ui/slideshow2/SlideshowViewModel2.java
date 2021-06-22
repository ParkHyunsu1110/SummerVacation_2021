package com.capstonedesign.summervacation.ui.slideshow2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SlideshowViewModel2 extends ViewModel {

    private MutableLiveData<String> mText;

    public SlideshowViewModel2() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow2 fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
