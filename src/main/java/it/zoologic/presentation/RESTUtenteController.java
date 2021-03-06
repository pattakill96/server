package it.zoologic.presentation;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.zoologic.business.ZoologyService;
import it.zoologic.common.spring.security.JWTTokenUtil;
import it.zoologic.common.spring.security.UserDetailsImpl;
import it.zoologic.domain.Utente;

@RestController
@RequestMapping("/api")
public class RESTUtenteController {

	@Value("${jwt.header}")
	private String tokenHeader;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JWTTokenUtil jwtTokenUtil;

	@Autowired
	private ZoologyService ZoologyService;

	@PostMapping("/login")
	public UtenteResponse login(@RequestBody AuthenticationRequest authenticationRequest, HttpServletResponse response) throws AuthenticationException {
		// Effettuo l'autenticazione
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Genero Token e lo inserisco nell'header di risposta
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String token = jwtTokenUtil.generateToken(userDetails);
		response.setHeader(tokenHeader, token);

		// Ritorno l'utente
		return new UtenteResponse(((UserDetailsImpl) userDetails).getUtente());
	}

	@GetMapping("/verifyToken")
	public UtenteResponse verifyToken(){
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return new UtenteResponse(((UserDetailsImpl) userDetails).getUtente());
	}

	@PostMapping("/utente/update")
	public UtenteResponse updateProfilo(@RequestBody Utente utente) {
		Utente nuovoUtente = ZoologyService.updateProfilo(utente);		
		return new UtenteResponse(nuovoUtente);
	}

	@GetMapping("/utenti")
	public List<Utente> list() {
		return ZoologyService.findAllUtenti();
	}

	@PostMapping("/utente")
	public void createUtente(@RequestBody Utente utente) {
		ZoologyService.createUtente(utente);		
	}

	
}
