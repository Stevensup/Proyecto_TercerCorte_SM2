package co.edu.unbosque.model;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Pdf {
    public static void guardarPDF(String filePath, JFrame ventana) {
        try {
            // Capturar la ventana en una imagen BufferedImage
            BufferedImage image = new BufferedImage(ventana.getWidth(), ventana.getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics = image.createGraphics();
            ventana.paint(graphics);

            // Guardar la imagen en un archivo PNG temporal
            File tempFile = File.createTempFile("screenshot", ".png");
            ImageIO.write(image, "png", tempFile);

            // Crear el documento PDF
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);

            // Cargar la imagen en el documento PDF
            PDImageXObject imageObject = PDImageXObject.createFromFileByContent(tempFile, document);
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.drawImage(imageObject, 0, 0, page.getMediaBox().getWidth(), page.getMediaBox().getHeight());
            contentStream.close();

            // Guardar el documento PDF
            document.save(filePath);
            document.close();

            // Eliminar el archivo PNG temporal
            tempFile.delete();

            JOptionPane.showMessageDialog(null, "El gráfico se ha guardado en formato PDF correctamente.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al guardar el gráfico en formato PDF: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

	public static void guardarPDF(String filePath, String string) {
		// TODO Auto-generated method stub
		
	}
}
