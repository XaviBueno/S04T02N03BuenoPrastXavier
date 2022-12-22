
package cat.itacademy.barcelonactiva.BuenoPrast.Xavier.s04.t02.n03.model.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.BuenoPrast.Xavier.s04.t02.n03.model.domain.Fruita;
import cat.itacademy.barcelonactiva.BuenoPrast.Xavier.s04.t02.n03.model.repository.FruitaRepository;

@Service
public class FruitaService {
	
	@Autowired
	private FruitaRepository fruitaRepository;


	public Fruita addFruita(Fruita fruita) {
		
				
		return fruitaRepository.save(fruita);
	}
	
	public Fruita updateFruita(int id,String nom, int quantitat) {
		
		Fruita fruita=fruitaRepository.findById(id).orElse(null);
		
		if(fruita!=null) {
			fruita.setNom(nom);
			fruita.setQuantitatQuilos(quantitat);
			fruitaRepository.save(fruita);
		}
		
		return fruita;
	}

	
	public void deleteFruita(int id) {
		
		  fruitaRepository.deleteById(id);
		
	}

	
	public Fruita getOneFruita(int id) {
				
		return  fruitaRepository.findById(id).orElse(null);
	}

	
	public List<Fruita> getAllFruites() {
		return fruitaRepository.findAll();
	}

}
