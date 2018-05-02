package com.glomex.contentsdk.internal

import com.glomex.contentsdk.Content
import com.glomex.contentsdk.data.AdType
import com.glomex.contentsdk.data.Source
import com.glomex.contentsdk.Tracker
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/** Test for [ContentImpl].  */
class ContentImplTest {

    private val processorMock = mock<Tracker>()
    private val source = Source()

    private lateinit var target: Content

    @Before
    fun setUp() {
        target = ContentImpl(source, processorMock)
    }

    @Test
    fun getSources_returnSourceFromConstructor() {
        assertEquals(source, target.getSources())
    }

    @Test
    fun trackContentBegin_callsProcessor() {
        target.trackContentBegin()
        verify(processorMock).trackContentBegin()
    }

    @Test
    fun trackAdBegin_callsProcessor() {
        val adType = AdType.PREROLL
        target.trackAdBegin(adType)
        verify(processorMock).trackAdBegin(adType)
    }
}