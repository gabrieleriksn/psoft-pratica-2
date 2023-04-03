package com.ufcg.psoft.mercadofacil.repository;

import com.ufcg.psoft.mercadofacil.model.Batch;
import com.ufcg.psoft.mercadofacil.model.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class VolatilLoteRepositoryTest {
    @Autowired
    BatchRepository<Batch, Long> driver;

    Batch batch;
    Batch result;
    Product product;

    @BeforeEach
    void setUp() {
        product = Product.builder()
                .id(1L)
                .name("Produto Base")
                .barcode("123456789")
                .manufacturer("Fabricante Base")
                .price(125.36)
                .build();

        batch = Batch.builder()
                .id(1L)
                .numberOfItems(100)
                .product(product)
                .build();
    }

    @AfterEach
    void tearDown() {
        product = null;
        driver.deleteAll();
    }

    @Test
    @DisplayName("Adicionar o primeiro Lote no repositorio de dados")
    void saveFirstBatch() {
        result = driver.save(batch);
        assertEquals(driver.findAll().size(), 1);
        assertEquals(result.getId().longValue(), batch.getId().longValue());
        assertEquals(result.getProduct(), product);
    }

    @Test
    @DisplayName("Adicionar o segundo Lote (ou posterior) no repositorio de dados")
    void saveSecondBatchOrLater() {
        Product extraProduct = Product.builder()
                .id(2L)
                .name("Produto Extra")
                .barcode("987654321")
                .manufacturer("Fabricante Extra")
                .build();

        Batch extraBatch = Batch.builder()
                .id(2L)
                .numberOfItems(100)
                .product(extraProduct)
                .build();

        driver.save(batch);

        result = driver.save(extraBatch);

        assertEquals(driver.findAll().size(),2);
        assertEquals(result.getId().longValue(), extraBatch.getId().longValue());
        assertEquals(result.getProduct(), extraProduct);
    }

}
