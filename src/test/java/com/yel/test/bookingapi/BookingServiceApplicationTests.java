package com.yel.test.bookingapi;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.yel.test.bookingapi.booking.models.Booking;

@SpringBootTest
@AutoConfigureMockMvc
class BookingServiceApplicationTests {
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void returnBookingByReservationNumber() throws Exception {
		
		mvc.perform(get("/bookings/klklklklklklk")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk())
			      .andExpect(content()
			      .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			      .andExpect(jsonPath("$.firstName", is("John")));
	}
	
	@Test
	public void shouldReturnRoomNotFound() throws Exception {
		
		LocalDate today = LocalDate.now().plusDays(1L);
		LocalDate todayPlusFour = today.plusDays(4L);
		System.out.println(today.toString());
		Booking booking = new Booking();
		booking.setFirstName("john");
		booking.setLastName("Rulina");
		booking.setPhoneNumber("0033893383833");
		booking.setEmail("test@test.k");
		booking.setCheckIn(today);
		booking.setCheckOut(todayPlusFour);
		booking.setRoomId(1);
		
		mvc.perform(post("/bookings")
				  .content(asJsonString(booking))
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isBadRequest())
			      .andExpect(content()
			      .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			      .andExpect(jsonPath("$.message", is("The staty can not be longer than 3 days")));
	}

	public String asJsonString(Object obj) throws JsonProcessingException {
	        ObjectMapper mapper = new ObjectMapper();
	        mapper.registerModule(new JavaTimeModule());
			mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	        String jsonContent = mapper.writeValueAsString(obj);
	        return jsonContent;
	}  
	
}
