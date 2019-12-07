package com.bw.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class OneFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_one, null);
        Log.i("OneFragment", "onCreateView: ");
        return  inflate;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("OneFragment", "onActivityCreated: ");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("OneFragment", "onAttach: ");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("OneFragment", "onCreate: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("OneFragment", "onStart: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("OneFragment", "onPause: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("OneFragment", "onResume: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("OneFragment", "onStop: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("OneFragment", "onDestroyView: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("OneFragment", "onDestroy: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("OneFragment", "onDetach: ");
    }

}
