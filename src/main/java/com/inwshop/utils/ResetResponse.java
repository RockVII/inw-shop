package com.inwshop.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

public class ResetResponse {

	public static HttpServletResponse execute(String jsonResponse, HttpServletResponse response,int status) throws IOException {

		response.setStatus(status);
		response.setContentType("application/json");
		response.getWriter().write(jsonResponse);
		response.getWriter().flush();
		response.getWriter().close();

		return response;
	}



}
