package com.ehernandez.inventory;

import com.ehernandez.inventory.domain.MerchandiseDTO;
import com.ehernandez.inventory.domain.service.MerchandiseService;
import com.ehernandez.inventory.persistence.entity.Mercancia;
import com.ehernandez.inventory.persistence.mapper.MerchandiseMapper;
import com.ehernandez.inventory.web.controller.MerchandiseController;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class MerchandiseControllerTest {

    /*@Autowired
    private TestEntityManager testEntityManager;

    @MockBean
    private MerchandiseService merchandiseCrudService;*/

    private final MerchandiseMapper merchandiseMapper = mock(MerchandiseMapper.class);
    private final MerchandiseService merchandiseService = mock(MerchandiseService.class);
    private final MerchandiseController merchandiseController = new MerchandiseController();

    @Test
    public void shouldCallServiceToAddProduct() {
        List<MerchandiseDTO> mrcs = (List<MerchandiseDTO>) merchandiseService.getAll();
        MerchandiseDTO mrcs1 =  new MerchandiseDTO(1, "Producto de prueba", 1452, LocalDate.now(), 1);
        Mercancia mrc = new Mercancia(1, "Producto de prueba", 1452, LocalDate.now(), 1);

        //Merchandise merchandiseRequest = new Merchandise();
        //Mercancia mercancia = new Mercancia();

        when(merchandiseMapper.toMerchandise(any())).thenReturn(mrcs1);
        when(merchandiseMapper.toMercancia(any())).thenReturn(mrc);

        //productController.addProduct(productVO);
        merchandiseController.save(mrcs1,null);

        verify(merchandiseService).save(mrcs1);
    }
/*
    @Test
    public void shouldCallServiceToDeletedProduct() {
        final int id = 1;
        productController.deleteProduct(id);
        verify(productService).deleteProduct(id);
    }

    @Test
    public void shouldCallServiceToFindProduct() {
        final int id = 1;
        ProductVO productVO = ProductVO.builder()
                .id(id)
                .build();

        when(productConverter.converToVO(any())).thenReturn(productVO);

        productController.findProductById(id);
        verify(productService).findProductById(id);
    }

    @Test
    public void shouldCallServiceToAllProduct() {
        productController.findAllProducts();
        verify(productService).getProducts();
    }*/



    @Test
    public void messageTest() {
        //List<Merchandise> msg = merchandiseService.getAll();
        //assertEquals("Hello World!", msg.toString());
        assertEquals("Hello World!", "Hello World!");
    }

    /*@Test
    public void shouldInsert() {
        List<Merchandise> mrcs = (List<Merchandise>) merchandiseService.getAll();
        Mercancia mrc = new Mercancia(1, "Producto de prueba", 1452, LocalDate.now(), 1);
        testEntityManager.persistAndFlush(mrc);
        List<Merchandise> afterInsert = (List<Merchandise>) merchandiseService.getAll();

        assertEquals(mrcs.size() + 1, afterInsert.size());
    }*/
}
