package modelo;

import java.util.ArrayList;

public class prueba {

	public static void main(String[] args) {
		Animal animal = new Animal();
		ArrayList<Ingrediente> ingredientes = new ArrayList <Ingrediente>();
		ArrayList<Double> porcentajes = new ArrayList<Double>();
		double pInicial = 0;
		int i = 0;
		Mezcla mezcla = new Mezcla();
		Ingrediente aux = new Ingrediente();
		Ingrediente aux2 = new Ingrediente();
		Ingrediente aux3 = new Ingrediente();
		Ingrediente aux4 = new Ingrediente();
		Ingrediente aux5 = new Ingrediente();
		
		
		aux3.setNombre("Grano de maíz");
		aux3.setClasificacion("energetico");
		aux3.setProteina(8.8);
		aux3.setEm(3275);
		aux3.setTnd(79);
		ingredientes.add(aux3);
		
		aux4.setNombre("Grano de centeno");
		aux4.setClasificacion("energetico");
		aux4.setProteina(11.9);
		aux4.setEm(3079);
		aux4.setTnd(75);
		ingredientes.add(aux4);
		
		aux.setNombre("Alfalfa");
		aux.setClasificacion("voluminoso");
		aux.setProteina(20.6);
		aux.setEm(2029);
		aux.setTnd(50);
		ingredientes.add(aux);
		
		aux5.setNombre("Melaza de remolacha");
		aux5.setClasificacion("proteínico");
		aux5.setProteina(6.7);
		aux5.setEm(0);
		aux5.setTnd(0);
		ingredientes.add(aux5);
		
		aux2.setNombre("Pasto");
		aux2.setClasificacion("voluminoso");
		aux2.setProteina(5.2);
		aux2.setEm(0);
		aux2.setTnd(12);
		ingredientes.add(aux2);

		animal.setEspecie("vaca");
		animal.setEtapa("amamantando");
		animal.setPeso(500);
		animal.setPc(364);
		animal.setTnd(3.7);
		animal.setEm(14.2);
		pInicial = 100 / ingredientes.size();
		for (i = 0;i < ingredientes.size();i++) {
			porcentajes.add(pInicial);
		}
		
		System.out.println("guardé animal e ingredientes");
		porcentajes = mezcla.balancear(ingredientes, animal, porcentajes);
		mezcla.setIngredientes(ingredientes);
		mezcla.setPorcentajes(porcentajes);
		
		mezcla.imprimeMezcla();
	}
}
