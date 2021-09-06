package com.bilalov.springeshoprb.endpoint;

import com.bilalov.springeshoprb.dto.ProductDTO;
import com.bilalov.springeshoprb.service.ProductService;
import com.bilalov.springeshoprb.ws.products.GetProductsRequest;
import com.bilalov.springeshoprb.ws.products.GetProductsResponse;
import com.bilalov.springeshoprb.ws.products.ProductsWS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ProductsEndpoint {

    public static final String NAMESPACE_URL = "http://bilalov.com/springeshoprb/ws/products";

    private ProductService productService;

    @Autowired
    public ProductsEndpoint(ProductService productService) {
        this.productService = productService;
    }

    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "getProductsRequest")
    @ResponsePayload
    public GetProductsResponse getProductWS(@RequestPayload GetProductsRequest request) {
        GetProductsResponse response = new GetProductsResponse();
        productService.getAll()
                .forEach(dto -> response.getProducts().add(createProductWs(dto)));
        return response;
    }

    private ProductsWS createProductWs(ProductDTO dto) {
        ProductsWS ws = new ProductsWS();
        ws.setId(dto.getId());
        ws.setPrice(Double.parseDouble(dto.getPrice().toString()));
        ws.setTitle(dto.getTitle());
        return ws;
    }
}