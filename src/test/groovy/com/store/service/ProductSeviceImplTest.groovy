package com.store.service

import com.store.domain.Product
import com.store.dao.ProductRepository
import spock.lang.Specification



class ProductSeviceImplTest extends Specification {
    def productService = new ProductSeviceImpl();
    def productRepository = Mock(ProductRepository)


    def setup() {

        productService.repository = productRepository
    }

    

    def "getProducts  returns value"(){
        given:
            def productObj = [new Product(1,"22","dd","sss","10-10/2016",2.33), new Product(1,"22","dd","sss","10-10/2016",2.33)]
        when: 'product service getProduct is called'
            def response = productService.getProducts()

        then: "result returned"
        
            1* productRepository.findAll() >> productObj

            response == productObj
        
    }

    def "getProducts return empty"(){
        given:
        def productObj = []
        when: 'product service getProduct is called'
        def response = productService.getProducts()

        then: "result returned"

        1* productRepository.findAll() >> productObj

        response == productObj

    } 
}
