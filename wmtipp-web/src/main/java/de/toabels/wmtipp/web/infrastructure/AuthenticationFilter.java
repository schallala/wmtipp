/*
 * Copyright (C) 2018 abels
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.toabels.wmtipp.web.infrastructure;

import java.io.IOException;
import javax.faces.application.ResourceHandler;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author abels
 */
@WebFilter(filterName = "AuthenticationFilter", urlPatterns = {"*.xhtml", "*.jsf", "*.html"})
public class AuthenticationFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationFilter.class);

    private static final String AJAX_REDIRECT_XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
        + "<partial-response><redirect url=\"%s\"></redirect></partial-response>";

    public AuthenticationFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {

            // check whether session variable is set
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;
            HttpSession session = req.getSession(false);
            String loginURL = req.getContextPath() + "/home.jsf";
            //  allow user to proccede if url is login.xhtml or user logged in or user is accessing any page in //public folder
            boolean loggedIn = (session != null) && (session.getAttribute("username") != null);
            boolean loginRequest = req.getRequestURI().equals(loginURL);
            boolean resourceRequest = req.getRequestURI().startsWith(req.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER + "/");
            boolean ajaxRequest = "partial/ajax".equals(req.getHeader("Faces-Request"));

            if (loggedIn || loginRequest || resourceRequest) {
                // Prevent browser from caching restricted resources. See also https://stackoverflow.com/q/4194207/157882
                if (!resourceRequest) { 
                    res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
                    res.setHeader("Pragma", "no-cache"); // HTTP 1.0.
                    res.setDateHeader("Expires", 0); // Proxies.
                }

                chain.doFilter(req, res); // So, just continue request.
            } else if (ajaxRequest) {
                res.setContentType("text/xml");
                res.setCharacterEncoding("UTF-8");
                res.getWriter().printf(AJAX_REDIRECT_XML, loginURL); // So, return special XML response instructing JSF ajax to send a redirect.
            } else {
                res.sendRedirect(loginURL); // So, just perform standard synchronous redirect.
            }
        } catch (IOException | ServletException ex) {
            logger.error(ex.getMessage());
        }
    } //doFilter

    @Override
    public void destroy() {

    }
}
