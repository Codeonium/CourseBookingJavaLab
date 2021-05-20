package com.codeclan.example.CourseBooking;

import com.codeclan.example.CourseBooking.models.Booking;
import com.codeclan.example.CourseBooking.models.Course;
import com.codeclan.example.CourseBooking.models.Customer;
import com.codeclan.example.CourseBooking.repositories.BookingRespository;
import com.codeclan.example.CourseBooking.repositories.CourseRepository;
import com.codeclan.example.CourseBooking.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CourseBookingApplicationTests {

	@Autowired
	BookingRespository bookingRespository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createBookingCourseAndCustomer() {

		Course course1 = new Course("Learning to be a mad bastard", "Edinburgh", 5);
		courseRepository.save(course1);

		Customer customer1 = new Customer("Tim", "Edinburgh", 34);
		customerRepository.save(customer1);

		Booking booking1 = new Booking("20.05.21", course1, customer1);
		bookingRespository.save(booking1);
	}


}
