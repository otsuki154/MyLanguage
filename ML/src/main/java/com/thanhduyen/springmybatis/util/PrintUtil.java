package com.thanhduyen.springmybatis.util;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PrintUtil {

	public void printPdf(HttpServletRequest request, HttpServletResponse response, String dsName, String reportName)
			throws Exception {
		try {

			@SuppressWarnings("unchecked")
			List<Map<String, ?>> dataSource = (List<Map<String, ?>>) request.getAttribute(dsName);

			JRDataSource jrDataSource = new JRBeanCollectionDataSource(dataSource);

			HttpSession session = request.getSession();

			String jrxmlFile = session.getServletContext().getRealPath(reportName);
			InputStream input = new FileInputStream(new File(jrxmlFile));

			JasperReport jasperReport = JasperCompileManager.compileReport(input);

			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, jrDataSource);

			JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());

			response.getOutputStream().flush();
			response.getOutputStream().close();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
