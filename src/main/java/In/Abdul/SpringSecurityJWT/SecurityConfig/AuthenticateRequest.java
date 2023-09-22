package In.Abdul.SpringSecurityJWT.SecurityConfig;


import lombok.Data;

@Data
public class AuthenticateRequest {
    private String uname;
    private String password;
}
