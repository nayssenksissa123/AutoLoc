package tn.esprit.autolocnayssenksissa.Service;

import tn.esprit.autolocnayssenksissa.domain.Reservation;
import java.util.List;

public interface IReservationService {
    Reservation ajouter(Reservation reservation);
    void supprimerReservation(long id);
    Reservation recupererReservation(long id);
    List<Reservation> recupererReservations();
    Reservation updateReservation(Reservation r);
}