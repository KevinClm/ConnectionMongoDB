package org.example;

import com.mongodb.client.*;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class modificar {
    private JTextField notaModificadaTF;
    public JPanel modificar;
    private JButton actualizarButton;
    private JTextField estudianteTF;
    private JButton buscarButton;
    private JRadioButton nota2RB;
    private JRadioButton nota1RB;

    public modificar() {
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
                MongoDatabase database = mongoClient.getDatabase("Calificaciones");
                MongoCollection<Document> collection = database.getCollection("Tercero");
                Document busqueda = new Document("nombre", estudianteTF.getText());
                FindIterable<Document> resultado = collection.find(busqueda);
                if(resultado.equals(0)){

                }
            }
        });
    }
}
