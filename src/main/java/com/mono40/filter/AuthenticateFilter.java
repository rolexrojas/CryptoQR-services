package com.mono40.filter;

import com.mono40.CryptoQRMain;
import com.mono40.controller.PartnerBankResource;
import com.mono40.controller.ServiceReportController;
import com.mono40.controller.SignInController;
import com.mono40.controller.SignUpController;
import com.mono40.domain.CarServiceInformation;
import com.mono40.domain.Maintenance;
import com.mono40.types.GeneralErrorDTO;
import com.mono40.types.SignInDTO;
import com.mono40.types.SignUpDTO;
import com.mono40.types.SysError;
import com.mono40.util.JwtManager;
import com.mono40.util.Messages;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;
import com.mono40.controller.*;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class AuthenticateFilter extends GenericFilterBean {

    @Autowired
    private JwtManager jwtManager;

    @Autowired
    private Messages messages;

    private Logger logger = Logger.getLogger(AuthenticateFilter.class);


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String uri = ((HttpServletRequest) request).getRequestURI();

        if (needFilter(uri)) {

            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            String resolvedToken = resolveToken(httpServletRequest);

            if (resolvedToken == null) {

                HttpServletResponse servletResponse = (HttpServletResponse) response;
                servletResponse.setStatus(HttpStatus.SC_UNAUTHORIZED);

            } else {

                try {

                    jwtManager.validToken(resolvedToken);

                    chain.doFilter(request, response);

                } catch (ExpiredJwtException e) {
                    String claims = (String) e.getClaims().getSubject();
                    logger.error("Expiration token exception, token invalid accountid "+claims+". "+e);
                    HttpServletResponse servletResponse = (HttpServletResponse) response;
                    servletResponse.setContentType("application/json");
                    servletResponse.setStatus(HttpStatus.SC_UNAUTHORIZED);
                    SysError sysError = new SysError("0520", messages.get("session_expired"));
                    GeneralErrorDTO cryptoQrError = new GeneralErrorDTO(sysError);
                    servletResponse.getWriter().write(cryptoQrError.toString());
                    servletResponse.getWriter().flush();
                    servletResponse.getWriter().close();

                } catch (JwtException e) {
                    logger.error(e);
                    HttpServletResponse servletResponse = (HttpServletResponse) response;
                    servletResponse.setContentType("application/json");
                    servletResponse.setStatus(HttpStatus.SC_UNAUTHORIZED);
                    SysError error = new SysError();
                    error.setCode("0004");
                    error.setDescription(messages.get("invalid_user_or_password"));
                    GeneralErrorDTO cryptoQrError = new GeneralErrorDTO(error);
                    servletResponse.getWriter().write(cryptoQrError.toString());
                    servletResponse.getWriter().flush();
                    servletResponse.getWriter().close();
                }

            }

        } else {

            chain.doFilter(request, response);
        }


    }

    private boolean needFilter(String uri) {

        Set<String> paths = new HashSet<>();

        try {

            // path to version
            paths.add(linkTo(methodOn(CryptoQRMain.class).version()).toUri().getPath());
            // path to sign in
            paths.add(linkTo(methodOn(SignInController.class).signIn(new SignInDTO())).toUri().getPath());
            paths.add(linkTo(methodOn(ServiceReportController.class).reportMaintenanceEncrypt(new String(), new String(), new String(), new String(), new String(), new String(), new Maintenance())).toUri().getPath());
            paths.add(linkTo(methodOn(SignUpController.class).signUp(new String(), new String(), new String(), new SignUpDTO())).toUri().getPath());


            // path to banks
            paths.add(linkTo(methodOn(PartnerBankResource.class).banks()).toUri().getPath());
            // path to partners
           // paths.add(linkTo(methodOn(PaymentResource.class).partners()).toUri().getPath());
            // path to email verification
            //paths.add(linkTo(methodOn(EmailVerificationController.class).verify("")).toUri().getPath());
           // paths.add(linkTo(methodOn(ValidateEmailController.class).sendEmailCode("", "")).toUri().getPath());
            //paths.add(linkTo(methodOn(ValidateEmailController.class).checkValidationCode(new CheckEmailCodeRequest())).toUri().getPath());
            // path to forgot password
            //paths.add(linkTo(methodOn(AccountController.class).forgotPassword("")).toUri().getPath());
            // path to reset password pin
           //paths.add(linkTo(methodOn(AccountController.class).resetPasswordPin(null)).toUri().getPath());
            // path to request activation code
            paths.add(linkTo(methodOn(SignUpController.class).requestActivationCode(null)).toUri().getPath());
            // path to verify activation code
            paths.add(linkTo(methodOn(SignUpController.class).verifyActivationCode(null)).toUri().getPath());
            // path to fingerPrintSignIn
            //paths.add(linkTo(methodOn(SignInController.class).fingerPrintSignIn(new TokenModel())).toUri().getPath());

            // path affiliation information
            //paths.add(linkTo(methodOn(CustomerInfoController.class).registrationInformation(new InformationRequest())).toUri().getPath());
            /*
            // path to fingerPrintSignIn
            paths.add(linkTo(methodOn(SignInController.class).fingerPrintSignIn(new TokenModel())).toUri().getPath());
               */
            if  (uri.startsWith("/api/cryptoqr/api"))
                return false;

            if  (uri.equalsIgnoreCase("/api/cryptoqr/signup") || uri.equalsIgnoreCase("/api/cryptoqr/signin"))
                return false;

            String msisdn = uri.replace("/api/cryptoqr/customer/", "");
            msisdn = msisdn.replace("/status", "");
            paths.add(linkTo(methodOn(CustomerInfoController.class).getStatus(new String(),new String(),new String(),new Long(msisdn))).toUri().getPath());

        } catch (NumberFormatException e) {
            logger.warn("warning in number for customer status caught.");
        } catch (Exception e) {
            logger.error(e);
        }

        return !paths.contains(uri);
    }

    private String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }
}
