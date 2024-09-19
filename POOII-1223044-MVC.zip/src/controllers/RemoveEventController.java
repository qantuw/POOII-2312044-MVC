package controllers;

import core.Controller;
import views.RemoveEventView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * * Created by Ethan
 * */

public class RemoveEventController extends Controller {

    //-----------------------------------------------------------------------
    //		Attributes
    //-----------------------------------------------------------------------
    private RemoveEventView removeEventView;

    @Override
    public void run() {

        DefaultTableModel model = new DefaultTableModel(getDataColumns(), getNameColumns());
        /*@Override
            public Class getColumnClass(int column) {
            return getValueAt(0, column).getClass();
            }*/
        JTable table = new JTable(model) {

            private static final long serialVersionUID = 1L;

            /*@Override
            public Class getColumnClass(int column) {
            return getValueAt(0, column).getClass();
            }*/
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    case 3:
                        return String.class;
                    case 4:
                        return String.class;
                    default:
                        return Boolean.class;
                }
            }
        };
        removeEventView = new RemoveEventView(this, table);
    }

    public RemoveEventView getView()
    {
        return removeEventView;
    }

    /**
     * Returns the names of the columns of the events list.
     *
     * @return Table metadata in a list
     */
    public Object[] getNameColumns()
    {
        // Aquí puede ser lectura de base datos o leer un archivo texto y llevarlo a un modelo
        return new Object[]{"Date", "Description", "Frequency", "E-mail", "Alarm", "Boolean"};
    }

    /**
     * Returns events list data.
     *
     * @return Table data in a list of lists (matrix)
     */
    public Object[][] getDataColumns()
    {
        Object[][] data = {
                {"04/23/2024", "Cumpleaños de un amigo 1", "diario", "gianny.romie@gmail.com", "OFF", false},
                {"04/23/2024", "Cumpleaños de un amigo 2", "diario", "gianny.romie@gmail.com", "OFF", true},
                {"04/23/2024", "Cumpleaños de un amigo 3", "diario", "gianny.romie@gmail.com", "OFF", true},
                {"04/23/2024", "Cumpleaños de un amigo 4", "diario", "gianny.romie@gmail.com", "OFF", false}
        };

        return data;
    }
}
