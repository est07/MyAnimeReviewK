package com.puzzlebench.myanimereviewk.presentation.viewModels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.puzzlebench.myanimereviewk.MainDispatcherRule
import com.puzzlebench.myanimereviewk.domain.models.AnimeTop
import com.puzzlebench.myanimereviewk.domain.repositories.AnimeRepository
import com.puzzlebench.myanimereviewk.presentation.states.AnimeListState
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.*
import org.junit.Assert.assertEquals
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verifyNoInteractions

@RunWith(MockitoJUnitRunner::class)
class AnimeListViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val dispatcherRule = MainDispatcherRule()

    @Mock
    private lateinit var animeRepository: AnimeRepository

    @Mock
    private lateinit var _animeListState: MutableLiveData<AnimeListState>

    private lateinit var animeListViewModel: AnimeListViewModel

    @Before
    fun setUp() {
        animeListViewModel = AnimeListViewModel(
            animeRepository,
            _animeListState
        )
    }

    @After
    fun tearDown() {
        verifyNoMoreInteractions(
            animeRepository,
            _animeListState
        )
    }

    @Test
    fun testGetGetAnimeListStateLiveData() {
        assertEquals(
            animeListViewModel.getAnimeListStateLiveData,
            _animeListState
        )
    }

    @Test
    fun testGetAnimeTopListSuccess() = runBlocking {

        val animeTopResult: List<AnimeTop> = mock()

        `when`(animeRepository.getAnimeTopList()).thenReturn(flowOf(animeTopResult))

        animeListViewModel.getAnimeTopList()

        verify(animeRepository).getAnimeTopList()
        verify(_animeListState).value = AnimeListState.Loading
        verify(_animeListState).value = AnimeListState.Success(animeTopResult)
        verifyNoInteractions(animeTopResult)
    }

    @Test
    fun testGetAnimeTopListError() = runBlocking {

        val throwable: Throwable = mock()
        val flow = flow<List<AnimeTop>> { throw throwable }

        `when`(animeRepository.getAnimeTopList()).thenReturn(flow)

        animeListViewModel.getAnimeTopList()

        verify(animeRepository).getAnimeTopList()
        verify(_animeListState).value = AnimeListState.Loading
        verify(_animeListState).value = AnimeListState.Error
    }
}