package views;

import controllers.RemoveEventController;
import core.Model;
import core.View;
import models.Frequency;
import models.SchedulerEvent;
import models.SchedulerUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveEventView extends JPanel implements View {

    private final RemoveEventController removeEventController;
    private final JTable table;

    public RemoveEventView(RemoveEventController removeEventController, JTable table)
    {
        this.removeEventController = removeEventController;
        this.table = table;

        make_frame();
    }

    @Override
    public void update(Model model, Object data) {
        //TODO
    }

    /**
     * Creates view's frame.
     */
    private void make_frame()
    {
        setLayout(new BorderLayout());

        JPanel btnPnl = new JPanel(new BorderLayout());
        JPanel topBtnPnl = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        JPanel bottombtnPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton cancelButton = new JButton("Cancel");

        topBtnPnl.add(new JButton("Seleccionar Todos"));
        bottombtnPnl.add(cancelButton);
        bottombtnPnl.add(new JButton("Remover"));

        btnPnl.add(topBtnPnl, BorderLayout.NORTH);
        btnPnl.add(bottombtnPnl, BorderLayout.CENTER);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Añadiendo la Tabla + 3 Botones
        add(table.getTableHeader(), BorderLayout.NORTH);
        add(table, BorderLayout.CENTER);
        add(btnPnl, BorderLayout.SOUTH);



    }
}
