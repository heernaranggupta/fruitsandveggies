package com.hydroponic.ecomm;


import com.hydroponic.ecomm.model.CommonResponse;
import com.hydroponic.ecomm.model.Order;
import com.hydroponic.ecomm.model.Product;
import com.hydroponic.ecomm.model.ProductOrder;
import com.hydroponic.ecomm.repository.CustomerRepository;
import com.hydroponic.ecomm.repository.OrderRepository;
import com.hydroponic.ecomm.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.SecureRandom;
import java.util.List;

@Slf4j
@RequestMapping("/freshizo")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class Controller {
    private CustomerRepository customerRepository;
    private OrderRepository orderRepository;
    private ProductRepository productRepository;

    @Autowired
    public Controller(CustomerRepository customerRepository, OrderRepository orderRepository, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @GetMapping("/product/view")
    public CommonResponse<List<Product>> viewAllProducts() {
        List<Product> products= productRepository.findAll();
        CommonResponse commonResponse = new CommonResponse<>(products);
        return ResponseUtilities.createSuccessResponse(commonResponse);
    }

    @PostMapping(path = "/product/test", consumes = "application/x-www-form-urlencoded")
    public CommonResponse<String> test(Product product) {
        Product productResponse= productRepository.insert(product);
        CommonResponse commonResponse = new CommonResponse<>(productResponse.get_id());
        return ResponseUtilities.createSuccessResponse(commonResponse);
    }


    @PostMapping("/product/insert")
    public CommonResponse<String> insertProduct(@RequestBody Product product) {
        product.setProduct_id(generate4DigitRandom());
        Product productResponse= productRepository.insert(product);
        CommonResponse commonResponse = new CommonResponse<>(productResponse.get_id());
        return ResponseUtilities.createSuccessResponse(commonResponse);
    }


    @PostMapping("/order/place")
    public CommonResponse<Order> placeOrder(@RequestBody Order order) {
        order.setOrderId(generate4DigitRandom());
        Order orderResponse=orderRepository.insert(order);
        CommonResponse commonResponse = new CommonResponse<>(orderResponse);
        return ResponseUtilities.createSuccessResponse(commonResponse);

    }

    public static int generate4DigitRandom() {
        SecureRandom random = new SecureRandom();
        int ran = 1000 + random.nextInt(9000);
        return ran;
    }







}
