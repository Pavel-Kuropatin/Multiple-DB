package com.kuropatin.mdb.test;

import com.kuropatin.mdb.model.first.User;
import com.kuropatin.mdb.model.first.Product;
import com.kuropatin.mdb.model.second.Greeting;
import com.kuropatin.mdb.repository.first.UserRepository;
import com.kuropatin.mdb.repository.first.ProductRepository;
import com.kuropatin.mdb.repository.second.GreetingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@EnableTransactionManagement
class MultipleDbTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private GreetingRepository greetingRepository;

    @Test
    @Transactional("firstTransactionManager")
    void testCreateUser() {
        final String name = "Иван";
        final String birthDate = "12.12.2012";

        User user = new User();
        user.setName(name);
        user.setBirthDate(birthDate);

        user = userRepository.save(user);

        final User savedUser = userRepository.findById(user.getId()).orElse(new User());
        assertEquals(name, savedUser.getName());
        assertEquals(birthDate, savedUser.getBirthDate());

        userRepository.deleteById(user.getId());
        assertNull(userRepository.findById(user.getId()).orElse(null));
    }

    @Test
    @Transactional("firstTransactionManager")
    void testCreateProduct() {
        final String name = "Ластик";
        final int price = 90;

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);

        product = productRepository.save(product);

        final Product savedProduct = productRepository.findById(product.getId()).orElse(new Product());
        assertEquals(name, savedProduct.getName());
        assertEquals(price, savedProduct.getPrice());

        productRepository.deleteById(product.getId());
        assertNull(productRepository.findById(product.getId()).orElse(null));
    }

    @Test
    @Transactional("secondTransactionManager")
    void testCreateGreeting() {
        final String message = "Ластик";

        Greeting greeting = new Greeting();
        greeting.setMessage(message);

        greeting = greetingRepository.save(greeting);

        final Greeting savedGreeting = greetingRepository.findById(greeting.getId()).orElse(new Greeting());
        assertEquals(message, savedGreeting.getMessage());

        greetingRepository.deleteById(greeting.getId());
        assertNull(greetingRepository.findById(greeting.getId()).orElse(null));
    }
}