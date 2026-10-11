package tn.esprit.autolocnayssenksissa.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolocnayssenksissa.Repository.ReservationRepository;
import tn.esprit.autolocnayssenksissa.domain.Reservation;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService implements IReservationService {

    private final ReservationRepository reservationRepo;

    @Override
    public Reservation ajouter(Reservation reservation) {
        return reservationRepo.save(reservation);
    }

    @Override
    public void supprimerReservation(long id) {
        reservationRepo.deleteById(id);
    }

    @Override
    public Reservation recupererReservation(long id) {
        return reservationRepo.findById(id).orElse(null);
    }

    @Override
    public List<Reservation> recupererReservations() {
        return reservationRepo.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation r) {
        return reservationRepo.save(r);
    }
}