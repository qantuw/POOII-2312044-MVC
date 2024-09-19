package controllers;

import java.io.IOException;
import javax.swing.JOptionPane;
import models.Guest;
import models.GuestIO;
import views.RegisterGuestView;

public class RegisterGuestController {

    private RegisterGuestView view;
    private GuestIO guestIO;

    public RegisterGuestController() {
        guestIO = new GuestIO();
    }

    public void run() {
        view = new RegisterGuestView(this);
    }

    public void registerGuest(Guest guest) {
        try {
            guestIO.saveGuest(guest);
            JOptionPane.showMessageDialog(view, "Invitado registrado con éxito.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(view, "Error al registrar el invitado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public RegisterGuestView getView() {
        return view;
    }
}
