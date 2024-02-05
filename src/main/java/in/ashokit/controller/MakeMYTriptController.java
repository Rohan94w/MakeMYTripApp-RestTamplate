package in.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.bindings.Passenger;
import in.ashokit.bindings.Ticket;
import in.ashokit.service.MakeMyTripService;

@Controller
public class MakeMYTriptController {

	@Autowired
	private MakeMyTripService service;
	
	@PostMapping("/ticket")
	public String ticketBooking(@ModelAttribute("p") Passenger p, Model model) {
		
		Ticket bookTicket = service.bookTicket(p);
		model.addAttribute("msg", "Yor ticket is Booked"+bookTicket.getTickitNo());
		return "bookTicket";
	}
	
	@GetMapping("/book-ticket")
	public String bookTicket(Model model) {
		
		model.addAttribute("p", new Passenger());
		return "bookTicket";
		
	}
	
	@GetMapping("/")
	public String index(Model model) {
		
		List<Ticket> allTickets = service.getAllTickets();
		
		model.addAttribute("tickets", allTickets);
		return "index";
		
	}
}
