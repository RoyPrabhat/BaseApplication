package com.example.sqrrlandriodtask.view.imagelist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqrrlandriodtask.R;
import com.example.sqrrlandriodtask.adapter.ImageListAdapter;
import com.example.sqrrlandriodtask.constant.Constants;
import com.example.sqrrlandriodtask.model.ImagesList;
import com.example.sqrrlandriodtask.viewmodel.ImageListViewModel;

import java.util.ArrayList;


public class ImageListFragment extends Fragment {

    private ImageListViewModel mViewModel;
    private ArrayList<String> mImagesList;
    private RecyclerView mImageRecyclerView;
    private ImageListAdapter imageListAdapter;
    public static final int COLUMN_COUNT = 2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_image_list, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setUp();
    }

    private void setUp() {
        Bundle args = getArguments();
        final String dogName = args.getString(Constants.DOG_NAME, Constants.EMPTY_STRING);
        mImageRecyclerView = getView().findViewById(R.id.image_list);
        mImagesList = new ArrayList<>();
        initializeViewModel(dogName);
        initializeRecyclerView();
        initializeObserver();

    }

    private void initializeViewModel(String dogName) {
        mViewModel = ViewModelProviders.of(this).get(ImageListViewModel.class);
        mViewModel.setDogName(dogName);
        mViewModel.fetchImageList();
    }

    private void initializeObserver() {
        mViewModel.getImageList().observe(this, new Observer<ImagesList>() {

            @Override
            public void onChanged(ImagesList imagesList) {
                mImagesList.addAll(imagesList.getImageList());
                imageListAdapter.notifyDataSetChanged();
            }
        });
    }


    private void initializeRecyclerView() {
        imageListAdapter = new ImageListAdapter(mImagesList, getActivity());
        mImageRecyclerView.setAdapter(imageListAdapter);
        mImageRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), COLUMN_COUNT));
    }

}
