package com.example.spring_core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(Application.class, args);

		UserService objectFromClass = applicationContext.getBean(UserService.class);

		OrderService orderService = applicationContext.getBean(OrderService.class);
		PaymentService paymentService = applicationContext.getBean(PaymentService.class);

		System.out.println(objectFromClass.getUserHomeAddress());
	}

}
