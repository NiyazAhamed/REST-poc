package com.store.controller

import com.store.domain.Product
import com.store.service.ProductService
import groovy.json.JsonBuilder
import org.springframework.test.web.servlet.MockMvc

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.http.HttpStatus.*

import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification


class ProductControllerTest extends Specification {
    
    def productController = new ProductController();
    def productService = Mock(ProductService);
    
    MockMvc mockMvc 
    
    def setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build()
        productController.productService = productService
    }
    
    def "getProducts "(){
        given:
        def productObj = [new Product(1,"22","dd","sss","10-10/2016",2.33),new Product(1,"22","dd","sss","10-10/2016",2.33)]
        def productJson = '[{"id":1,"sku":"22","name":"dd","category":"sss","last_updated":"10-10/2016","price":2.33},{"id":1,"sku":"22","name":"dd","category":"sss","last_updated":"10-10/2016","price":2.33}]'
        when: 'products url si hit'
            def response = mockMvc.perform(get("/products")).andReturn().response

        then: "result returned"
        response.status == OK.value()
        response.contentType.contains('application/json')
        response.contentType == 'application/json;charset=UTF-8'

        response.contentAsString == productJson
        
        1* productService.getProducts() >> productObj
        
            
    }
    
}
