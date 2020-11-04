package unip.pim4s.pim4s.Security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import unip.pim4s.pim4s.Models.User;

@Component
public class JwtService implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterchain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		try {
			String path = request.getRequestURI();
			if (!path.equals("/authenticate")) {
				String token = request.getHeader("authorization").split(" ")[1];

				if (token == null)
					response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Não Autorizado!");

				request.setAttribute("user", JWT.decode(token));

			}
		} catch (Exception e) {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Não Autorizado!");
			SecurityContextHolder.clearContext();
		}

		filterchain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterconfig) throws ServletException {
	}

	public static String generateToken(User user) {
		String token = JWT.create().withSubject(user.toString())
				.withExpiresAt(new Date(System.currentTimeMillis() + 800_000)).sign(Algorithm.HMAC512("4546401477"));

		return token;
	}

}
