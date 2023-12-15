package com.example.attendanceappproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class Fragment_Subjects extends Fragment {

    private List<ClassItem> classList;
    private RecyclerView classRecyclerView;
    private ClassAdapter classAdapter;

    public Fragment_Subjects() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment__subjects, container, false);

        classList = generateClassItem();

        classRecyclerView = rootView.findViewById((R.id.subjects_RecyclerView));
        classRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        classAdapter = new ClassAdapter(classList);
        classRecyclerView.setAdapter(classAdapter);

        return rootView;



    }

    private List<ClassItem> generateClassItem(){
        List<ClassItem> classItems = new ArrayList<>();
        classItems.add(new ClassItem("das", "das", "asfsa", "fasg"));
        classItems.add(new ClassItem("das", "das", "asfsa", "fasg"));
        classItems.add(new ClassItem("das", "das", "asfsa", "fasg"));
        classItems.add(new ClassItem("das", "das", "asfsa", "fasg"));

        return classItems;
    }
}