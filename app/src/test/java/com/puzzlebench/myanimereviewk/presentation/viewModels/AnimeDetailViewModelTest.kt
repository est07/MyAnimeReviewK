package com.puzzlebench.myanimereviewk.presentation.viewModels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verifyZeroInteractions
import com.puzzlebench.myanimereviewk.CoroutinesTestRule
import com.puzzlebench.myanimereviewk.domain.models.AnimeDetail
import com.puzzlebench.myanimereviewk.domain.models.AnimeSearch
import com.puzzlebench.myanimereviewk.domain.repositories.AnimeRepository
import com.puzzlebench.myanimereviewk.presentation.states.AnimeDetailState
import com.puzzlebench.myanimereviewk.presentation.states.AnimeSearchState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.*
import org.junit.Assert.assertEquals
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AnimeDetailViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesTestRule: CoroutinesTestRule = CoroutinesTestRule()

    @Mock
    private lateinit var animeRepository: AnimeRepository

    @Mock
    private lateinit var _animeDetailState: MutableLiveData<AnimeDetailState>

    @Mock
    private lateinit var _animeSearchState: MutableLiveData<AnimeSearchState>

    private lateinit var animeDetailViewModel: AnimeDetailViewModel

    @Before
    fun setUp() {
        animeDetailViewModel = AnimeDetailViewModel(
            animeRepository,
            _animeDetailState,
            _animeSearchState
        )
    }

    @After
    fun tearDown() {
        verifyNoMoreInteractions(
            animeRepository,
            _animeDetailState,
            _animeSearchState
        )
    }

    @Test
    fun testGetGetAnimeDetailStateLiveData() {
        assertEquals(
            animeDetailViewModel.getAnimeDetailStateLiveData,
            _animeDetailState
        )
    }

    @Test
    fun testGetGetAnimeSearchStateStateLiveData() {
        assertEquals(
            animeDetailViewModel.getAnimeSearchStateStateLiveData,
            _animeSearchState
        )
    }

    @Test
    fun testGetAnimeDetailSuccess() = runBlocking {

        val animeDetail: AnimeDetail = mock()

        `when`(animeRepository.getAnimeDetail(1L)).thenReturn(flowOf(animeDetail))

        animeDetailViewModel.getAnimeDetail(1L)

        verify(animeRepository).getAnimeDetail(1L)
        verify(_animeDetailState).value = AnimeDetailState.Loading
        verify(_animeDetailState).value = AnimeDetailState.Success(animeDetail)
        verifyZeroInteractions(animeDetail)
    }

    @Test
    fun testGetAnimeDetailError() = runBlocking {

        val throwable: Throwable = mock()
        val flow = flow<AnimeDetail> { throw throwable }

        `when`(animeRepository.getAnimeDetail(1L)).thenReturn(flow)

        animeDetailViewModel.getAnimeDetail(1L)

        verify(animeRepository).getAnimeDetail(1L)
        verify(_animeDetailState).value = AnimeDetailState.Loading
        verify(_animeDetailState).value = AnimeDetailState.Error
    }

    @Test
    fun testGetAnimeSearchListSuccess() = runBlocking {

        val animeSearch: List<AnimeSearch> = mock()

        `when`(animeRepository.getAnimeSearchList("search")).thenReturn(flowOf(animeSearch))

        animeDetailViewModel.getAnimeSearchList("search")

        verify(animeRepository).getAnimeSearchList("search")
        verify(_animeSearchState).value = AnimeSearchState.Loading
        verify(_animeSearchState).value = AnimeSearchState.Success(animeSearch)
        verifyZeroInteractions(animeSearch)
    }

    @Test
    fun testGetAnimeSearchListError() = runBlocking {

        val throwable: Throwable = mock()
        val flow = flow<List<AnimeSearch>> { throw throwable }

        `when`(animeRepository.getAnimeSearchList("search")).thenReturn(flow)

        animeDetailViewModel.getAnimeSearchList("search")

        verify(animeRepository).getAnimeSearchList("search")
        verify(_animeSearchState).value = AnimeSearchState.Loading
        verify(_animeSearchState).value = AnimeSearchState.Error
    }
}