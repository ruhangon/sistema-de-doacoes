package br.unisul.doacoes.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.unisul.doacoes.domain.Doacao;
import br.unisul.doacoes.services.DoacaoService;

@RestController
@RequestMapping(value="/doacoes")
public class DoacaoResource {
	@Autowired
	private DoacaoService service;

	@RequestMapping(value = "/{nomeDoacao}/nomeDoacao", method = RequestMethod.GET)
    public ResponseEntity<Doacao> find(@PathVariable String nomeDoacao) {
            Doacao obj = service.findByNomeDoacao(nomeDoacao);
            return ResponseEntity.ok().body(obj);
    }
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Doacao> find(@PathVariable Integer id) {
		Doacao obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Doacao obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdDoacao())
				.toUri();	
		return ResponseEntity.created(uri).build();
	}
	 @RequestMapping(value="/{id}", method=RequestMethod.PUT)
	    public ResponseEntity<Void> update(@RequestBody Doacao obj, @PathVariable Integer id){
	        obj.setIdDoacao(id);
	        obj = service.update(obj);
	        return ResponseEntity.noContent().build();
	}
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Doacao id) {
       service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
