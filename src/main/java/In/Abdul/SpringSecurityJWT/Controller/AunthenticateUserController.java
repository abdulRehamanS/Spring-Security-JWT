package In.Abdul.SpringSecurityJWT.Controller;


import In.Abdul.SpringSecurityJWT.SecurityConfig.AuthenticateRequest;
import In.Abdul.SpringSecurityJWT.SecurityConfig.JwtUtil;
import In.Abdul.SpringSecurityJWT.SecurityConfig.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;

@RestController
public class AunthenticateUserController {


    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private MyUserService myUserService;
    @Autowired
    private AuthenticationManager authManager;

    @PostMapping("/authenticate")
    public String authenticate(@RequestBody AuthenticateRequest request) throws Exception {

        try {

            authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUname(), request.getPassword()));
        } catch (Exception e) {
            throw new Exception("Invalid Authentication");
        }

        UserDetails userDetails = myUserService.loadUserByUsername(request.getUname());

        String token = jwtUtil.generateToken(userDetails);
        return token;
    }
}
