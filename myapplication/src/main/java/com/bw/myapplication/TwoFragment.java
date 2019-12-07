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


public class TwoFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_two, null);
        Log.i("TwoFragment", "onCreateView: ");
        return  inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("TwoFragment", "onActivityCreated: ");
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("TwoFragment", "onAttach: ");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("TwoFragment", "onCreate: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("TwoFragment", "onStart: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("TwoFragment", "onPause: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("TwoFragment", "onResume: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("TwoFragment", "onStop: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("OneFragment", "onDestroyView: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("TwoFragment", "onDestroy: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("TwoFragment", "onDetach: ");
    }
}
