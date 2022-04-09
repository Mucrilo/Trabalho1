package com.example.trabalho1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;


import com.example.trabalho1.databinding.FragmentThirdBinding;

public class ThirdFragment extends Fragment {

    private FragmentThirdBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentThirdBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonThirdToFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ThirdFragment.this)
                        .navigate(R.id.action_ThirdFragment_to_FirstFragment);
            }
        });

        int[]lista = new int[]{R.drawable.angel,R.drawable.crazy, R.drawable.crying,
                R.drawable.happy, R.drawable.hugging, R.drawable.inlove,
                R.drawable.neutral, R.drawable.thinking, R.drawable.thumbs_up};

        binding.gridThirdFrag.setAdapter(new Adaptador(getContext(), lista));

        binding.gridThirdFrag.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posi, long l) {

                switch (posi){
                    case 0:
                        binding.textViewGrid.setText("Anjo");
                        break;
                    case 1:
                        binding.textViewGrid.setText("Louco");
                        break;
                    case 2:
                        binding.textViewGrid.setText("Chorando");
                        break;
                    case 3:
                        binding.textViewGrid.setText("Feliz");
                        break;
                    case 4:
                        binding.textViewGrid.setText("Abraço");
                        break;
                    case 5:
                        binding.textViewGrid.setText("Apaixonado");
                        break;
                    case 6:
                        binding.textViewGrid.setText("Neutro");
                        break;
                    case 7:
                        binding.textViewGrid.setText("Pensativo");
                        break;
                    case 8:
                        binding.textViewGrid.setText("Joinha");
                        break;
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}