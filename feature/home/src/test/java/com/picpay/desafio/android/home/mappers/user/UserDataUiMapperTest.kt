package com.picpay.desafio.android.home.mappers.user

import com.picpay.desafio.android.home.factories.UserFactory
import com.picpay.desafio.android.home.presentation.mappers.toPresentation
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class UserDataUiMapperTest {
    @Test
    fun `should map from domain to presentation with success`() {
        UserFactory.domains.forEach { domain ->
            val presentation = domain.toPresentation()
            Assert.assertEquals(domain.id, presentation.id)
            Assert.assertEquals(domain.img, presentation.img)
            Assert.assertEquals(domain.name, presentation.name)
            Assert.assertEquals(domain.userName, presentation.userName)
        }
    }
}