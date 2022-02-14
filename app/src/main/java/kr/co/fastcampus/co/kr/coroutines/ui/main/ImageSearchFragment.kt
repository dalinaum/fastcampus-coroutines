package kr.co.fastcampus.co.kr.coroutines.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kr.co.fastcampus.co.kr.coroutines.databinding.FragmentMainBinding

class ImageSearchFragment : Fragment() {

    private lateinit var imageSearchViewModel: ImageSearchViewModel
    private val adapter: ImageSearchAdapter = ImageSearchAdapter {
        imageSearchViewModel.toggle(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        imageSearchViewModel = ViewModelProvider(this)[ImageSearchViewModel::class.java]

        lifecycleScope.launch {
            TODO("collectLatest를 이용해서 어댑터를 갱신해야합니다.")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentMainBinding.inflate(inflater, container, false)
        val root = binding.root

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = GridLayoutManager(context, 4)
        binding.search.setOnClickListener {
            TODO("검색 기능을 구현해야합니다.")
        }

        return root
    }
}