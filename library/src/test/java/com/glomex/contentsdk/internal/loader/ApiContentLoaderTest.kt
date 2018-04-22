package com.glomex.contentsdk.internal.loader

import com.glomex.contentsdk.ContentSdk
import com.glomex.contentsdk.internal.api.GlomexApi
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test
import retrofit2.Call
import java.util.*

/** Tests for [ApiContentLoader]. */
class ApiContentLoaderTest {

    private val apiMock = mock<GlomexApi> {
        on { loadVideo(any(), any(), any()) } doReturn mock<Call<GlomexApi.VideoResponse>>()
    }

    private lateinit var target: ContentLoader

    @Before
    fun setUp() {
        target = ApiContentLoader(apiMock)
    }


    @Test
    fun load_callsApi() {
        val contentConfig = ContentSdk.ContentConfig(
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString()
        )
        target.load(contentConfig, {})
        verify(apiMock).loadVideo(
                contentConfig.integrationId,
                contentConfig.contentId,
                contentConfig.pageUrl
        )
    }
}