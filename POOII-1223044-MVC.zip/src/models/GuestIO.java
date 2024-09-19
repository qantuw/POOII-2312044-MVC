package models;

import java.io.*;

public class GuestIO {

    private static final String FILE_PATH = "invitados.txt";

    public void saveGuest(Guest guest) throws IOException {
        try ( BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            bw.write(guest.toString());
            bw.newLine();
        }
    }
}
