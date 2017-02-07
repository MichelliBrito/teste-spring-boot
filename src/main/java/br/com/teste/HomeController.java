package br.com.teste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.enviadorEmail.EmailService;
import br.com.teste.model.Convidado;
import br.com.teste.repository.ConvidadoRepository;


@Controller
public class HomeController {

	@Autowired
	private ConvidadoRepository repository;
	
	
	@RequestMapping("/teste")
    public String index() {
        return "index";
    }
	
	@RequestMapping("/listaconvidados")
	public String listaConvidados(Model model){
		Iterable<Convidado> convidados = repository.findAll();
	    model.addAttribute("convidados", convidados);
	    return "listaconvidados";
	}
	
	@RequestMapping(value= "/salvar", method = RequestMethod.POST)
	public String salvar(Convidado convidado){
		repository.save(convidado);
		EmailService email = new EmailService();
		email.enviar(convidado.getNome(), convidado.getEmail());
		return "redirect:/listaconvidados";
	}
	
	@RequestMapping(value= "/deletar", method = RequestMethod.GET)
	public String deletar(@RequestParam("convidado") Convidado convidado){
		repository.delete(convidado);
		return "redirect:/listaconvidados";
	}
}
