package com.example.trabalho1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.media.MediaPlayer;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SecondFragment extends Fragment {

    private Spinner spinner;
    private MediaPlayer mPlayer;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_second, container, false);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.sons, android.R.layout.simple_spinner_item);

        spinner=view.findViewById(R.id.spinner_sec_frag_sound);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                if(mPlayer!=null){
                    mPlayer.release();
                }
                switch (pos){
                    case 1:
                        mPlayer=MediaPlayer.create(getContext(),R.raw.cachorro);
                        break;
                    case 2:
                        mPlayer=MediaPlayer.create(getContext(),R.raw.cavalo);
                        break;
                    case 3:
                        mPlayer=MediaPlayer.create(getContext(),R.raw.galo);
                        break;
                    case 4:
                        mPlayer=MediaPlayer.create(getContext(),R.raw.gato);
                        break;
                    case 5:
                        mPlayer=MediaPlayer.create(getContext(),R.raw.macaco);
                        break;
                    case 6:
                        mPlayer=MediaPlayer.create(getContext(),R.raw.vaca);
                        break;
                }
                if(mPlayer!=null){
                    mPlayer.start();
                    mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            mediaPlayer.release();
                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_second_to_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }
}