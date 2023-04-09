package com.DB_Project;

import java.awt.print.Book;
import java.sql.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{
        Customer test3 = new Customer(new Integer(1234), "David Williom Todd", "256 Rideau st.", "Ottawa", new Integer(212121212), Date.valueOf("2023-04-08"));
        CustomerService customerService = new CustomerService();
        Employee test2 = new Employee(new Integer( 12345), "Gerald Horvid", "55 Bank st", "Ottawa", new Integer(666666666));
        EmployeeService employeeService = new EmployeeService();

        //customerService.updateCustomer(test3);
        customerService.createCustomer(test3);
        employeeService.createEmployee(test2);

        Booking test = new Booking(123, 581, 12345, 1234, Date.valueOf("2023-04-05"), Date.valueOf("2023-04-09"), "booking");
        BookingService bookingService = new BookingService();
        bookingService.createBooking(test);

        List<Booking> wow = bookingService.getBookings();
        List<Customer> david = customerService.getCustomers();
        List<Employee> notDavid = employeeService.getEmployees();

        //bookingService.deleteBooking(123);
        //customerService.deleteCustomer(1234);

        System.out.println(wow.get(0));
        System.out.println(david.get(0));
        System.out.println(notDavid.get(0));
    }
}
