package controller;

import model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.ReservationService;

import java.util.List;
import java.util.Optional;

@RestController
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    @RequestMapping(value = "/reservations",method = RequestMethod.GET)
    public List getAllReservation(){
        return reservationService.getAllReservations();
    }
    @RequestMapping(value = "/reservations/id",method = RequestMethod.GET)
    public Optional<Reservation> getReservation(@PathVariable Long  id){
        return reservationService.getReservation(id);
    }
    @RequestMapping(value = "/reservations/create",method = RequestMethod.POST)
    public void addReservation(@RequestBody Reservation reservation){
        reservationService.addReservation(reservation);
    }
    @RequestMapping(value = "/reservations/update",method = RequestMethod.PUT)
    public void updateReservation(@RequestBody Reservation reservation,@PathVariable Long id){
        reservationService.updateReservation(id,reservation);
    }
    @RequestMapping(value = "reservations/delete",method = RequestMethod.DELETE)
    public void deleteReservation(@PathVariable Long id){
        reservationService.deleteReservation(id);
    }


}
