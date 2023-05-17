package com.github.komidawi.interview.example;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DomainLogicTest {

    @Test
    public void testName() {
        // given
        Provider providerMock = mock(Provider.class);
        when(providerMock.provide()).thenReturn("test value");
        Generator generator = new DomainLogic(providerMock);

        // when
        Set<String> numbers = generator.generateNumbers();

        // then
        assertNotNull(numbers);
    }
}