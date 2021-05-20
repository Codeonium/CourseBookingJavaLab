package com.codeclan.example.CourseBooking.repositories;

import com.codeclan.example.CourseBooking.models.Course;
import com.codeclan.example.CourseBooking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

//    List<Customer> findByCourse(Course course);

    List<Customer> findByBookingsCustomerName(String customerName);


}
