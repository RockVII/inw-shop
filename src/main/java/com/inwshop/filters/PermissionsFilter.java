package com.inwshop.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inwshop.DTO.ResponseDTO;
import com.inwshop.serializations.GetStringfy;
import com.inwshop.serializations.GetStringfyFromGson;
import com.inwshop.utils.Error;
import com.inwshop.utils.ResetResponse;
import com.inwshop.utils.UserDetailsLogged;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.util.NestedServletException;

@Component
@Order(3)
public class PermissionsFilter extends OncePerRequestFilter {


	@Autowired
	private UserDetailsLogged userDetails;

	@Autowired
	private Error error;

	@Autowired
	private CheckPublicEndPoints checkPublic;

	private GetStringfy getStringfy = new GetStringfyFromGson();

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		if (checkPublic.execute(request.getRequestURI())){
			filterChain.doFilter(request, response);
			return;
		}

		try {

			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
					new UsernamePasswordAuthenticationToken(userDetails,"",userDetails.getAuthorities());
			System.out.println("tunning1");
			usernamePasswordAuthenticationToken
					.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			System.out.println("tunning2");
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			System.out.println("tunning3");
			filterChain.doFilter(request, response);
			System.out.println("tunning4");
			return;

		}
		catch (NestedServletException ex) {
			error.setError( "No tunco debe tener un id", null);
			System.out.println(ex.getMessage()+" miau");
		}

		ResponseDTO resp = new ResponseDTO(HttpStatus.UNAUTHORIZED.value(), "", null, error);
		response = ResetResponse.execute(getStringfy.execute(resp, ResponseDTO.class), response,HttpStatus.UNAUTHORIZED.value());

		return;

	}



}
