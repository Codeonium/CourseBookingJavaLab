package com.codeclan.example.CourseBooking;

import com.codeclan.example.CourseBooking.models.Booking;
import com.codeclan.example.CourseBooking.models.Course;
import com.codeclan.example.CourseBooking.models.Customer;
import com.codeclan.example.CourseBooking.repositories.BookingRepository;
import com.codeclan.example.CourseBooking.repositories.CourseRepository;
import com.codeclan.example.CourseBooking.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CourseBookingApplicationTests {

	@Autowired
	BookingRepository bookingRepository;

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
		bookingRepository.save(booking1);
	}

	@Test
	public void canFindByRating() {
		List<Course> foundCourses = courseRepository.findByRating(5);
		assertEquals("Learning to be a mad bastard", foundCourses.get(0).getName());
	}

	@Test
	public void canFindByDate() {
		List<Booking> foundBookings = bookingRepository.findByDate("20.05.21");
		assertEquals("20.05.21", foundBookings.get(0).getDate());
	}

	@Test
	public void canFindCustomerByDate() {
		List<Booking> foundBookings = bookingRepository.findByDate("20.05.21");
		assertEquals("Tim", foundBookings.get(0).getCustomer().getName());
	}

	@Test
    public void canFindCourseByBooking(){
		List<Course> foundCourses = courseRepository.findByBookingsCourseName("Learning to be a mad bastard");
		assertEquals("Edinburgh", foundCourses.get(0).getTown());
	}

	@Test
	public void canFindCustomerByBooking(){
		List<Customer> foundCustomers = customerRepository.findByBookingsCustomerName("Tim");
		assertEquals("Edinburgh", foundCustomers.get(0).getTown());
	}
}
