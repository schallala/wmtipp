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

import de.toabels.wmtipp.model.types.UserRoleType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    private UserSessionController userSession;

    private static final String AJAX_REDIRECT_XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
        + "<partial-response><redirect url=\"%s\"></redirect></partial-response>";

    private Map<UserRoleType, List<String>> accessMap;

    public AuthenticationFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        initAccessMap();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {

            // check whether session variable is set
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;
            HttpSession session = req.getSession(false);
            userSession = session != null ? (UserSessionController) session.getAttribute("userSessionCtrl") : null;
            String loginURL = req.getContextPath() + PageEnum.HOME.getOutcome();
            //  allow user to proccede if url is login.xhtml or user logged in or user is accessing any page in //public folder
            boolean loggedIn = (session != null) && (userSession.getCurrentUser() != null);
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
                if(loginRequest || resourceRequest || checkAccess(req, userSession)){
                    chain.doFilter(req, res); // So, just continue request.
                }else {
                    res.sendRedirect(loginURL); // So, just perform standard synchronous redirect.
                }
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
    
    private boolean checkAccess(HttpServletRequest request, UserSessionController userSession){
        if(userSession == null){
            return false;
        }
        UserRoleType currentRole = userSession.getCurrentUser().getPlayerContext().get(0).getUserRole();
        if(userSession.isSystemAdmin()){
            return true;
        }
        return accessMap.get(currentRole).contains(request.getServletPath());
    }

    private Map<UserRoleType, List<String>> initAccessMap() {
        accessMap = new HashMap<>();
        // read access rights for role ADMIN
        List<String> adminPageList = new ArrayList<>();
           
        adminPageList.add(PageEnum.EDIT_COMMUNITY.getOutcome());
        adminPageList.add(PageEnum.EDIT_PLAYER.getOutcome());
        adminPageList.add(PageEnum.EDIT_ROUND.getOutcome());
        adminPageList.add(PageEnum.EDIT_TIPS.getOutcome());
        accessMap.put(UserRoleType.ADMIN, adminPageList); 

        // read access rights for role USER
        List<String> userPageList = new ArrayList<>();
        userPageList.add(PageEnum.EDIT_PLAYER.getOutcome());
        userPageList.add(PageEnum.EDIT_TIPS.getOutcome());
        accessMap.put(UserRoleType.USER, userPageList);

        // SYSTEM_ADMIN has access to everything
        return accessMap;
    }

}
