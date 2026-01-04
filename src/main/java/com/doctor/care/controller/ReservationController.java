package com.doctor.care.controller;


import com.doctor.care.model.Reservation;
import com.doctor.care.repo.ReservationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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


    // ✅ Display all reservations with pagination
    @GetMapping
    public String getAllReservations(
            Model model,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        // Use Spring Pageable
        PageRequest pageable = PageRequest.of(page, size);
        Page<Reservation> reservationPage = reservationRepository.findAll(pageable);

        model.addAttribute("reservations", reservationPage.getContent());
        model.addAttribute("reservationPage", reservationPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", size);

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
