package com.puzzlebench.myanimereviewk.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.puzzlebench.myanimereviewk.R
import com.puzzlebench.myanimereviewk.presentation.states.AnimeListState
import com.puzzlebench.myanimereviewk.presentation.viewModels.AnimeListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    /*ajhsdkjahskdhaskdhaks
    ajhsdkjahdkjashdkjahdkasd
     */

    //data4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    private fun initView() {
        val navController =
            supportFragmentManager
                .findFragmentById(R.id.fraNavigationAnimeReview) as NavHostFragment
        navController.navController
    }
}
