package com.example.Gorets;

import com.example.Gorets.models.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@SpringBootApplication
public class GoretsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoretsApplication.class, args);
	}


//	public ResponseEntity<String> deleteProduct(@RequestBody Product product){
//		if (product == null){
//			return new ResponseEntity<>("product does not exist", HttpStatus.BAD_REQUEST);
//		}
//		return new ResponseEntity<>(productService.deleteProduct(product), HttpStatus.OK);
//	}

}
