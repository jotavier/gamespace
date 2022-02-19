package com.gamespace.home.mappers.user

import com.gamespace.home.domain.toEntity
import com.gamespace.home.factories.UserFactory
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class UserMapperTest {

    @Test
    fun `should map user from dto to domain with success`() {
        UserFactory.dtos.forEach { dto ->
            val domain = com.gamespace.home.domain.toDomain()
            Assert.assertEquals(dto.id, domain.id)
            Assert.assertEquals(dto.img, domain.img)
            Assert.assertEquals(dto.name, domain.name)
            Assert.assertEquals(dto.username, domain.userName)
        }
    }

    @Test
    fun `should map user from dto to entity with success`() {
        UserFactory.dtos.forEach { dto ->
            val entity = dto.toEntity()
            Assert.assertEquals(dto.id, entity.id)
            Assert.assertEquals(dto.img, entity.img)
            Assert.assertEquals(dto.name, entity.name)
            Assert.assertEquals(dto.username, entity.userName)
        }
    }

    @Test
    fun `should map user from entity to domain with success`() {
        UserFactory.entities.forEach { entity ->
            val domain = entity.toDomain()
            Assert.assertEquals(entity.id, domain.id)
            Assert.assertEquals(entity.img, domain.img)
            Assert.assertEquals(entity.name, domain.name)
            Assert.assertEquals(entity.userName, domain.userName)
        }
    }
}