package com.groupeisi.diplomasservice;

import com.groupeisi.diplomasservice.InsertionServiceApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = InsertionServiceApplication.class)
@ActiveProfiles("test")
class InsertionServiceApplicationTests {

    @Test
    void contextLoads() {
    }
}