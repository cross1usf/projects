package cross1usf.firstproject.config.filters;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class JwtTokenFilter {


   /* private final JwtProvider jwtProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(!hasAuthorizationHeader(request)){
        filterChain.doFilter(request,response);
        return;
        }
        String header = request.getHeader("Authorization");

        String token = header.split("")[1].trim();


    }

    private boolean hasAuthorizationHeader(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        System.out.println("The header is" + header);
        if(header.isEmpty() || header.isBlank()){
            return false;
        }

        return true;
    }*/
}
