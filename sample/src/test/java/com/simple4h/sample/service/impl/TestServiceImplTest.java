package com.simple4h.sample.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

/**
 * author Create By Simple4H
 * date 2020-10-28 18:07
 */
@SpringBootTest
@Slf4j
@ContextConfiguration(classes = {
        TestServiceImpl.class
})
class TestServiceImplTest {

    @Autowired
    private TestServiceImpl testServiceImpl;

    @MockBean
    private Test2ServiceImpl test2ServiceImpl;

    @BeforeEach
    void before() {
        log.info("Start Test");
        Mockito.when(test2ServiceImpl.append2Str()).thenReturn("T2");
    }

    @AfterEach
    void after() {
        log.info("After Test");
    }

    @Test
    @DisplayName("Junit5 Test")
    void appendStr() {
        String result = testServiceImpl.appendStr("Hello");
        log.info("Result is :{}", result);

        // 断言
        assertEquals("T2Hello Simple4H", result);

        // 假设
        assumeTrue("T2Hello Simple4H".equals(result), () -> "Not Equals");
    }
}