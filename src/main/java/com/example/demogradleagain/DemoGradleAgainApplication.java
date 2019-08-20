package com.example.demogradleagain;

import com.example.demogradleagain.model.Circle;
import com.example.demogradleagain.model.Square;
import com.example.demogradleagain.service.ShapeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class DemoGradleAgainApplication {

	public static void main(String[] args) {
		//SpringApplication.run(DemoGradleAgainApplication.class, args);
		ShapeService shapeService = new ShapeService(new Circle(), new Square());
		shapeService.getCircle().draw();
		shapeService.getSquare().draw();
	}

}
