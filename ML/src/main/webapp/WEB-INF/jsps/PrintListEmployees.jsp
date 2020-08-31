<%@ page contentType="application/pdf"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page import="com.thanhduyen.springmybatis.util.*"%>

<%@ include file="../html/header.html"%>

	<%
		String dtSoureName = "employeeList";
		String reportName = "/report/EmployeeListReport.jrxml";
		
		PrintUtil printUtil = new PrintUtil();
		printUtil.printPdf(request, response, dtSoureName, reportName);
	%>
	
<%@ include file="../html/footer.html"%>