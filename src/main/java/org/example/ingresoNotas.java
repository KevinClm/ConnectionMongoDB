package org.example;

import com.mongodb.client.*;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ingresoNotas {
    public JPanel insertar;
    private JTextField nota1TF;
    private JTextField nota2TF;
    private JButton button1;
    private JTextField materiaTF;
    private JTextField nombreTF;
    private JButton ModificarBTN;

    public ingresoNotas() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
                MongoDatabase database = mongoClient.getDatabase("Calificaciones");
                MongoCollection<Document> collection = database.getCollection("Tercero");
                Document document = new Document("Nombre", nombreTF.getText())
                        .append("Materia", materiaTF.getText())
                        .append("Nota 1", nota1TF.getText())
                        .append("Nota 2", nota2TF.getText());
                collection.insertOne(document);
                System.out.println("Datos insertados");
                nombreTF.setText("");
                materiaTF.setText("");
                nota1TF.setText("");
                nota2TF.setText("");
            }
        });
        ModificarBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.dispose();
                JFrame modificarV = new JFrame("Modificar");
                modificarV.setContentPane(new modificar().modificar);
                modificarV.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                modificarV.setSize(500, 500);
                modificarV.setLocationRelativeTo(null);
                modificarV.setVisible(true);
            }
        });
    }
}
