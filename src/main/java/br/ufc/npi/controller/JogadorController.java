package br.ufc.npi.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.npi.bean.Jogador;
import br.ufc.npi.service.JogadorService;

@RestController
@RequestMapping(value="/jogadores")
public class JogadorController {
	
	@Autowired
	JogadorService service;
	
	@CrossOrigin(origins = "http://localhost:8000")
	@RequestMapping(value="/listar", method = RequestMethod.GET)
	public List<Jogador> findOne() {
		List<Jogador> jogador = service.getTodosJogadores();
		return jogador;
	}
	
	@CrossOrigin(origins = "http://localhost:8000")
	@RequestMapping(path="/salvar", method=RequestMethod.POST, consumes ="application/json")
	public String salvarTime(@RequestBody Jogador jogador) {
		service.salvarJogador(jogador);
		return "redirect:http://localhost:8000/view2";
	}
	
	@CrossOrigin(origins = "http://localhost:8000")
	@RequestMapping(path="/{idJogador}", method=RequestMethod.DELETE)
	public String removerJogadorDoTime(@PathVariable("idJogador") Integer idJogador) {
		service.delJogadorDoTime(idJogador);
		return "redirect:http://localhost:8000/view2";
	 }
	
	@CrossOrigin(origins = "http://localhost:8000")
	@RequestMapping(path="/editar", method=RequestMethod.PUT)
	public String editarJogadorDoTime(@RequestBody Jogador jogador) {
		service.editJogadorDoTime(jogador);
		return "redirect:http://localhost:8000/view2";
	 }
}
