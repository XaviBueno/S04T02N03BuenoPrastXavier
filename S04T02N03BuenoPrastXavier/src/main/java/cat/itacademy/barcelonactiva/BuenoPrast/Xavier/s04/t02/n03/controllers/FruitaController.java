/**
 * 
 */
package cat.itacademy.barcelonactiva.BuenoPrast.Xavier.s04.t02.n03.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.BuenoPrast.Xavier.s04.t02.n03.model.domain.Fruita;
import cat.itacademy.barcelonactiva.BuenoPrast.Xavier.s04.t02.n03.model.services.FruitaService;

@RestController
@RequestMapping("/fruita")
public class FruitaController {
	
	@Autowired  
	private FruitaService fruitaServices;
	
	@PostMapping("/add")
	public ResponseEntity<Fruita> add(@RequestBody  Fruita fruita) {
		Fruita myFruita =new Fruita();
		ResponseEntity<Fruita> resposta;
		
		try {
			myFruita= fruitaServices.addFruita(fruita);
			resposta =new ResponseEntity<>(myFruita,HttpStatus.CREATED);
		}catch(Exception e) {
		  resposta = new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resposta;
				
	}
	@DeleteMapping("/delete/{id}")
	public  ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		
		ResponseEntity<HttpStatus> resposta;
		try {
			fruitaServices.deleteFruita(id);
			resposta=new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch(Exception e){
			resposta=new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
			
		
		return resposta;
		
	}
	
	@GetMapping("/getAll")
	
	public ResponseEntity<List<Fruita>> getAll(){
		
		ResponseEntity<List<Fruita>> resposta;
		try {
			List<Fruita> fruites=new ArrayList<Fruita>();
			fruites= fruitaServices.getAllFruites();
			
			if (fruites.isEmpty()){
				resposta= new  ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			else
			{
				resposta= new  ResponseEntity<>(fruites,HttpStatus.OK);
			}
		}catch(Exception e) {
			
			resposta= new  ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resposta;
		
	}
	
	@GetMapping("/getOne/{id}")
	
	public ResponseEntity<Fruita> getOne(@PathVariable("id") int id){
		ResponseEntity<Fruita> resposta;
		Fruita fruita=new Fruita();
		
		try {
			fruita=fruitaServices.getOneFruita(id);
			resposta =new ResponseEntity<>(fruita,HttpStatus.OK);
			
			
		}catch(Exception e){
			resposta= new  ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resposta;
	}

	
	@PutMapping("/update")
	
	public ResponseEntity<Fruita> update(@RequestBody Fruita fruita)
	
	{
		ResponseEntity<Fruita> resposta;
		int id=fruita.getId();
		String nom=fruita.getNom();
		int quantitat=fruita.getQuantitatQuilos();
		Fruita myFruita=fruitaServices.updateFruita(id,nom,quantitat);
		if(myFruita!=null) {
			resposta=new ResponseEntity<>(myFruita,HttpStatus.OK);
		}
		else
		{
			resposta=new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
		return resposta;
	}
	

	
	
	
	
	

}
