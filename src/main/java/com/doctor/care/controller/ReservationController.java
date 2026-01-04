package com.doctor.care.controller;


import com.doctor.care.model.Reservation;
import com.doctor.care.repo.ReservationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationRepository reservationRepository;

    public ReservationController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    // ✅ Display all reservations
    @GetMapping
    public String getAllReservations(Model model) {
        model.addAttribute("reservations", reservationRepository.findAll());
        return "reservations";
    }

    // ✅ Show add form
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "add-reservation";
    }

    @PostMapping("/save")
    public String saveReservation(@ModelAttribute Reservation reservation,
                                  RedirectAttributes redirectAttributes) {

        reservationRepository.save(reservation);

        redirectAttributes.addFlashAttribute(
                "successMessage",
                "Reservation added successfully"
        );

        return "redirect:/reservations";
    }
}
