package br.ufg.inf.es.sifa.controller.util;

import java.io.FileOutputStream;
import java.io.IOException;

import br.ufg.inf.es.sifa.model.Processo;
import br.ufg.inf.es.sifa.model.Servidor;
import br.ufg.inf.es.sifa.model.Unidade;
import br.ufg.inf.es.sifa.model.dao.ServidorDAO;
import br.ufg.inf.es.sifa.model.dao.UnidadeDAO;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@SuppressWarnings("deprecation")
public class GeradorPDF {
	
	final static String SIFA = "SIFA";
	private Processo processo;
	
	public GeradorPDF() {
		
	}
	
	public GeradorPDF(Processo processo) {
		this.processo = processo;
	}
	
	public void criarDocumento() {
		String diretorioRaiz = System.getProperty("user.home");
		String fs = System.getProperty("file.separator");
		String nomeDoArquivo = diretorioRaiz + fs + SIFA + fs + processo.getId() + " - " + processo.getDataInsercao().toString();
		
		// criação do documento
		Document document = new Document();
		try {

			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(nomeDoArquivo));
			writer.setEncryption(PdfWriter.STRENGTH128BITS, "PDFSifa", "sifa",
					PdfWriter.AllowCopy | PdfWriter.AllowPrinting);
			document.open();

			document.add(new Paragraph(getCorpoPDF()));
			document.addKeywords("sifa");
			document.addCreator("InsideSoft TI");
			document.addAuthor("SIFA");

		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		document.close();
	}

	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}
	
	private String getCorpoPDF() {
		String corpoPdf = "";
		UnidadeDAO uDao = new UnidadeDAO();
		Unidade unidade = uDao.buscaPorID(processo.getIdUnidade());
		
		ServidorDAO sDao = new ServidorDAO();
		Servidor servidor = sDao.buscaPorID(processo.getIdServidor());
		
		corpoPdf = "Unidade: " + unidade.getNome() + " - " + unidade.getDescricao();
		corpoPdf = "\n\n";
		corpoPdf = "Data de criação: " + processo.getDataInsercao().toString();
		corpoPdf = "\n\n";
		corpoPdf = "Servidor: " + servidor.getMatricula() + " - " + servidor.getNome();
		corpoPdf = "\n\n";
		corpoPdf = processo.getDescricao();
		
		return corpoPdf;
	}
}
