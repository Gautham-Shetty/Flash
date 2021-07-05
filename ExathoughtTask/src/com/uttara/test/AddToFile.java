package com.uttara.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class AddToFile {

	public static boolean write(String input,String path) {

		Document document = null;
		PdfWriter pw = null;
		FileOutputStream fo = null;
		try {
            if(path==null|| path.trim().equals(""))
            {
			Date d = new Date();
			String filename = d.getYear() + "-" + d.getMonth() + "-" + d.getDay() + "-" + d.getHours() + "-"
					+ d.getMinutes() + "-" + d.getSeconds();
             path = "C:\\Users\\GOUTHAM\\Desktop\\" + filename + ".pdf";
            }
            
			
			document = new Document();
			fo = new FileOutputStream(path);
			pw = PdfWriter.getInstance(document, fo);
			document.open();
			Paragraph para = new Paragraph(input);
			document.add(para);

			return true;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return false;
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			return false;
		} finally {
			if (document != null)
				document.close();
			if (pw != null)
				pw.close();
			if (fo != null)
				try {
					fo.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					  System.out.println(e.getMessage());
				}
		}

	}

	public static void read(String path) {
		PdfReader pdfreader = null;
		try {

			File f = new File(path);
			if (f.exists() && f.isFile() && f.getName().endsWith(".pdf")) {

				pdfreader = new PdfReader(path);
				int pages = pdfreader.getNumberOfPages();

				for (int i = 1; i <= pages; i++) {
					String pagecontent = PdfTextExtractor.getTextFromPage(pdfreader, i);
					System.out.println(pagecontent);
				}

			} else {
				System.out.println("Give proper file path or file format that app can read");
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (pdfreader != null) {
				pdfreader.close();
			}
		}

	}

	public static Map<String, Integer> occuranceWord(String path) {
		Map<String, Integer> map = null;
		PdfReader pdfreader = null;
		try {
			map = new LinkedHashMap<String, Integer>();
			File f = new File(path);
			if (f.exists() && f.isFile() && f.getName().endsWith(".pdf")) {
				pdfreader = new PdfReader(path);
				int pages = pdfreader.getNumberOfPages();

				for (int i = 1; i <= pages; i++) {
					String pagecontent = PdfTextExtractor.getTextFromPage(pdfreader, i);
					String[] arr = pagecontent.split("");
					for (String s : arr) {
						if (map.get(s) == null) {
							map.put(s, 1);
						} else {
							int count = map.get(s);
							map.put(s, count + 1);
						}
					}
				}
				return map;
			} else {
				System.out.println("Give proper file path or file format that app can read");
				return map;
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());

			return map;
		} finally {
			if (pdfreader != null) {
				pdfreader.close();
			}
		}

	}
}
