package In.Abdul.SpringSecurityJWT.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @GetMapping("/get")
    public String getName() {
        return "REST Controller is Working";
    }
}
