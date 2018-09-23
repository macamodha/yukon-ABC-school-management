package com.chulan.schoolmanagement.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.chulan.schoolmanagement.dao.EnrollStudentDao;
import com.chulan.schoolmanagement.dao.GradeDao;
import com.chulan.schoolmanagement.model.EnrollStudent;
import com.chulan.schoolmanagement.model.Grade;
import com.chulan.schoolmanagement.service.ReportService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @author chulan Service implementation class of the Reports 
 */

@Service("reportService")
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
public class ReportServiceImpl implements ReportService {

	@Autowired
    ServletContext context;
	
	// to get the available grades
	@Autowired
	GradeDao gradeDao;

	// to get the Results of courses students are engaged;
	@Autowired
	EnrollStudentDao enrollStudentDao;

	// get the active data lists to use inside different
	// methods
	public List<EnrollStudent> activeEnrollStudentList() {
		return enrollStudentDao.getAll().stream().filter(x -> x.getStatus().equals("A")).collect(Collectors.toList());
	}

	@Override
	public String getAll(Map<String, Object> map) {

		// Find report generation eligible courses
		map.put("courseList", enrollStudentDao.getDistinctActiveCourses());
		
		return "report/list";
	}

	@Override
	public String details(Long cId, Map<String, Object> map,HttpServletRequest request, HttpServletResponse response) {

		String reportName = "", pdfFileName = "";
		// get the active enroll student list for the selected course
		List<EnrollStudent> esList = enrollStudentDao.getAll().stream()
				.filter(x -> x.getCourse().getCrsId() == cId && x.getStatus().equals("A")).collect(Collectors.toList());

		// get the gradeDefinitions
		List<Grade> gListInternal = gradeDao.getAll().stream().filter(x -> x.getGradeType().equals("I"))
				.collect(Collectors.toList());
		List<Grade> gListExternal = gradeDao.getAll().stream().filter(x -> x.getGradeType().equals("E"))
				.collect(Collectors.toList());

		// assign grades to status field -because that field is not using for any
		// purpose when the report is to be generated
		for (EnrollStudent enrStud : esList) {

			// set report name
			if (reportName.equals("")) {
				
				pdfFileName ="report.pdf";
				reportName = "Individual Student Report for " + enrStud.getCourse().getcName() + " in "
						+ enrStud.getCourse().getSemester().getSemDescr();
			}
			// internal grading system
			if (enrStud.getStudent().getStudentType().equals("I")) {
				for (Grade grade : gListInternal) {
					if (grade.getUpperValue() >= enrStud.getFinalMarks()
							&& grade.getLowerValue() <= enrStud.getFinalMarks()) {
						// grade sets in the status field
						enrStud.setStatus(grade.getgName());
					}
				}
			}
			// External grading system
			else if (enrStud.getStudent().getStudentType().equals("E")) {
				for (Grade grade : gListExternal) {
					if (grade.getUpperValue() >= enrStud.getFinalMarks()
							&& grade.getLowerValue() <= enrStud.getFinalMarks()) {
						// grade sets in the status field
						enrStud.setStatus(grade.getgName());
					}
				}
			}
		}
		// create pdf
		try {
			
			createPdf(esList, reportName,pdfFileName);
			downloader(request,response,pdfFileName,map);
			
		} catch (FileNotFoundException e) {
			
			map.put("errorMsg","Error:- " + e.getMessage());
		} catch (DocumentException e) {
			
			map.put("errorMsg","Error:- " + e.getMessage());
		}
		return "report/list";
	}

	public void createPdf(List<EnrollStudent> esList, String reportName,String pdfFileName)
			throws FileNotFoundException, DocumentException {
		Document document = new Document();
		
		String downloadFolder = context.getRealPath("/WEB-INF/pdf");
        File file = new File(downloadFolder + File.separator + pdfFileName);
		
		@SuppressWarnings("unused")
		PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(file.getPath()));
		document.open();

		Paragraph companyName = new Paragraph();
		companyName.add("ABC Company");
		companyName.setAlignment(Element.ALIGN_CENTER);

		Paragraph heading = new Paragraph();
		heading.add(reportName);
		heading.setAlignment(Element.ALIGN_CENTER);

		Paragraph space = new Paragraph();
		space.add(" ");
		space.setAlignment(Element.ALIGN_CENTER);

		PdfPTable table = new PdfPTable(5);
		table.addCell("No");
		table.addCell("Student Name");
		table.addCell("Student Type");
		table.addCell("Final Marks");
		table.addCell("Grade");

		int mCount = 0;
		for (EnrollStudent es : esList) {
			mCount += 1;

			table.addCell(String.valueOf(mCount));
			table.addCell(es.getStudent().getfName() + " " + es.getStudent().getlName());
			table.addCell(es.getStudent().getStudentType().equals("I") ? "Internal" : "External");
			table.addCell(String.valueOf(es.getFinalMarks()));
			table.addCell(es.getStatus());
		}
		document.add(companyName);
		document.add(heading);
		document.add(space);
		document.add(table);
		document.close();
		pdfWriter.close();
	}
	
	public void downloader(HttpServletRequest request, HttpServletResponse response, String fileName,Map<String, Object> map) {
    try {
    	
        String downloadFolder = context.getRealPath("/WEB-INF/pdf");
            File file = new File(downloadFolder + File.separator + fileName);
 
            if (file.exists()) {
                String mimeType = context.getMimeType(file.getPath());
 
                if (mimeType == null) {
                    mimeType = "application/octet-stream";
                }
 
                response.setContentType(mimeType);
                response.addHeader("Content-Disposition", "attachment; filename=" + fileName);
                response.setContentLength((int) file.length());
 
                OutputStream os = response.getOutputStream();
                FileInputStream fis = new FileInputStream(file);
                byte[] buffer = new byte[4096];
                int b = -1;
 
                while ((b = fis.read(buffer)) != -1) {
                    os.write(buffer, 0, b);
                }
 
                fis.close();
                os.close();
            } else {
            	map.put("errorMsg","Requested " + fileName + " file not found!!");
        }
    } catch (IOException e) {
    	map.put("errorMsg","Error:- " + e.getMessage());
    }
}
}
