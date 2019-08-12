package com.example.sqrrlandriodtask.view.breedlist;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.sqrrlandriodtask.R;
import com.example.sqrrlandriodtask.adapter.BreedListAdapter;
import com.example.sqrrlandriodtask.constant.Constants;
import com.example.sqrrlandriodtask.view.imagelist.ImageListActivity;
import com.example.sqrrlandriodtask.viewmodel.BreedListViewModel;
import java.util.ArrayList;

public class BreedListFragment extends Fragment {


    private ArrayList<String> mBreedList;
    private BreedListViewModel mViewModel;
    private RecyclerView mBreedRecyclerView;
    private BreedListAdapter mBreedListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_breed_list, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setUp();
    }

    private void setUp() {
        mBreedRecyclerView = getView().findViewById(R.id.breed_list);
        mBreedList = new ArrayList<>();
        initializeViewModel();
        initializeRecyclerView();
        initializeObserver();
    }

    private void initializeViewModel() {
        mViewModel = ViewModelProviders.of(this).get(BreedListViewModel.class);
        mViewModel.fetchBreedList();
    }

    private void initializeObserver() {
        mViewModel.getBreedList().observe(getViewLifecycleOwner(), new Observer<ArrayList<String>>() {
            @Override
            public void onChanged(ArrayList<String> breedsList) {
                mBreedList.addAll(breedsList);
                mBreedListAdapter.notifyDataSetChanged();
            }
        });
    }

    private void initializeRecyclerView() {
        mBreedListAdapter = new BreedListAdapter(mBreedList,


                new BreedListAdapter.ItemClickListener() {

                    @Override
                    public void onClick(String dogName) {
                        Intent intent = new Intent(getActivity(), ImageListActivity.class);
                        intent.putExtra(Constants.DOG_NAME, dogName);
                        startActivity(intent);
                    }
                }
        );
        mBreedRecyclerView.setAdapter(mBreedListAdapter);
        mBreedRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

}
