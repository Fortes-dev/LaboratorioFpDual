package pdfExample.pdf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class IText5pdfCreator {

	public Document createDocument(File file) throws IOException, URISyntaxException, DocumentException {
		Document document = new Document();
		try (FileOutputStream fileStream = new FileOutputStream(file)) {
			PdfWriter pdfWriter = PdfWriter.getInstance(document, fileStream);

			pdfWriter.setEncryption("user".getBytes(), "12".getBytes(), PdfWriter.ALLOW_PRINTING,
					PdfWriter.ENCRYPTION_AES_256);
			document.open();
			Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 22, BaseColor.CYAN);
			Chunk chunk = new Chunk("Practicando pdfs con los panitas V2\n", font);
			Phrase phrase = new Phrase(chunk);

			document.add(phrase);
			
			Font fontSecond = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK);
			Phrase phraseSecond = new Phrase("Practicando pdfs con los panitas V3", fontSecond);
			
			document.add(phraseSecond);
			
			Path path = Paths.get(getClass().getResource("/img/ok.png").toURI());
			Image img = Image.getInstance(path.toAbsolutePath().toString());
			img.scalePercent(20);
			document.add(img);
			
			PdfPTable table = new PdfPTable(3);
			addTableHeader(table);
			addRows(table);
			addCustomRows(table);

			document.add(table);

			document.close();
		}

		return document;
	}
	
	private void addTableHeader(PdfPTable table) {
		Stream.of("column header 1", "column header 2", "column header 3").forEach(columnTitle -> {
			PdfPCell header = new PdfPCell();
			header.setBackgroundColor(BaseColor.LIGHT_GRAY);
			header.setBorderWidth(2);
			header.setPhrase(new Phrase(columnTitle));
			table.addCell(header);
		});
	}

	private void addRows(PdfPTable table) {
		table.addCell("row 1, col 1");
		table.addCell("row 1, col 2");
		table.addCell("row 1, col 3");
	}
	
	private void addCustomRows(PdfPTable table) throws URISyntaxException, BadElementException, IOException {
		Path path = Paths.get(getClass().getResource("/img/ok.png").toURI());
		Image img = Image.getInstance(path.toAbsolutePath().toString());
		img.scalePercent(10);

		PdfPCell imageCell = new PdfPCell(img);
		table.addCell(imageCell);

		PdfPCell horizontalAlignCell = new PdfPCell(new Phrase("row 2, col 2"));
		horizontalAlignCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(horizontalAlignCell);

		PdfPCell verticalAlignCell = new PdfPCell(new Phrase("row 2, col 3"));
		verticalAlignCell.setVerticalAlignment(Element.ALIGN_BOTTOM);
		table.addCell(verticalAlignCell);
	}
	
	
	public static void main(String[] args)
			throws MalformedURLException, IOException, URISyntaxException, DocumentException {
		new IText5pdfCreator().createDocument(new File("C:\\Users\\carlos.fortes.medina\\Documents\\temp2.pdf"));
	}
}
