package modelo;

import java.util.ArrayList;

public class Mezcla {
  private ArrayList<Ingrediente> ingredientes;
  private ArrayList<Double> porcentajes;
  public static int contador = 0;

  public ArrayList<Ingrediente> getIngredientes() {
    return ingredientes;
  }

  public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
    this.ingredientes = ingredientes;
  }

  public ArrayList<Double> getPorcentajes() {
    return porcentajes;
  }

  public void setPorcentajes(ArrayList<Double> porcentajes) {
    this.porcentajes = porcentajes;
  }

  /** Busca al  ingrediente con mayor contenido de pc. **/
  public int buscaMayorPc(ArrayList<Ingrediente> ingredientes) {
    int i = 0;
    int mayor = 0;
    for (i = 1;i < ingredientes.size();i++) {
      if (ingredientes.get(i).getProteina() > ingredientes.get(mayor).getProteina()) {
    	  if (ingredientes.get(i).getClasificacion().equalsIgnoreCase("voluminoso")) {
              break; 
            } else {
            	mayor = i;
            }
      }
    }
    return mayor;
  }
  
  /** Busca al  ingrediente con menor contenido de pc. **/  
  public int buscaMenorrPc(ArrayList<Ingrediente> ingredientes) {
    int i = 0;
    int menor = 0;
    Boolean listo = false;
    for (i = 1;i < ingredientes.size();i++) {
      if (ingredientes.get(i).getProteina() < ingredientes.get(menor).getProteina()) {
        if (ingredientes.get(i).getClasificacion().equalsIgnoreCase("voluminoso")) {
          break; 
        } else {
          menor = i;
        }
      }
    }
    return menor;
  }
  
  /** Busca al  ingrediente con mayor contenido de em. **/
  public int buscaMayorEm(ArrayList<Ingrediente> ingredientes) { 
    int i = 0;
    int mayor = 0;
    for (i = 1;i < ingredientes.size();i++) {
      if (ingredientes.get(i).getEm() > ingredientes.get(mayor).getEm()) {
    	  if (ingredientes.get(i).getClasificacion().equalsIgnoreCase("voluminoso")) {
              break; 
            } else {
               mayor = i;
            }
      }
    }
    return mayor;
  }
  
  /** Busca al  ingrediente con menor contenido de em. **/
  public int buscaMenorEm(ArrayList<Ingrediente> ingredientes) {
    int i = 0; 
    int menor = 0;
    for (i = 1;i < ingredientes.size();i++) {
      if (ingredientes.get(i).getEm() < ingredientes.get(menor).getEm()) {
        if (ingredientes.get(i).getClasificacion().equalsIgnoreCase("voluminoso")) {
          break; 
        } else {
          menor = i;
        }
      }
    }
    return menor;
  }
  
  /** Busca al  ingrediente con mayor contenido de tnd. **/
  public int buscaMayorTnd(ArrayList<Ingrediente> ingredientes) {
    int i = 0;
    int mayor = 0;
    for (i = 1;i < ingredientes.size();i++) {
      if (ingredientes.get(i).getEm() > ingredientes.get(mayor).getEm()) {
        if (ingredientes.get(i).getClasificacion().equalsIgnoreCase("voluminoso")) {
          mayor = i;
        }
      }
    }
    return mayor;
  }
  
  /** Busca al  ingrediente con menor contenido de tnd. **/
  public int buscaMenorTnd(ArrayList<Ingrediente> ingredientes) {
    int i = 0;
    int menor = 0;
    for (i = 1;i < ingredientes.size();i++) {
      if (ingredientes.get(i).getTnd() < ingredientes.get(menor).getTnd()) {
        if (ingredientes.get(i).getClasificacion().equalsIgnoreCase("voluminoso")) {
          break;
        } else {
          menor = i;
        }
      }
    }
    return menor;
  }
  
  
  public ArrayList<Double> balancearPc(ArrayList<Ingrediente> ingres, Double requerimiento, ArrayList<Double> porcentajes) {
	  int menor = 0;
	  int mayor = 0;
	  int i = 0;
	  int vuelta = 0;
	  double pc = 0;
	  Boolean listo = false;
	  double total = ingres.size();
	  
	  Mezcla m = new Mezcla();
	  do {
		  for (i = 0;i < total;i++) {
		        pc = pc + ((porcentajes.get(i) * ingres.get(i).getProteina()) / 100);
		      }
		  if (pc < requerimiento) {
			  mayor = m.buscaMayorPc(ingres);
			  menor = m.buscaMenorrPc(ingres);
			  if ((porcentajes.get(mayor) > 10 && porcentajes.get(mayor) < 50)
					  || (porcentajes.get(menor) > 10 && porcentajes.get(menor) < 50)) {
				  porcentajes.set(mayor, porcentajes.get(mayor) + 0.5);
				  porcentajes.set(menor, porcentajes.get(menor) - 0.5);
			  }
			  
			  
		  } else {
			  if ( pc > (requerimiento +2)) {
				  mayor = m.buscaMayorPc(ingres);
				  menor = m.buscaMenorrPc(ingres);
				  if ((porcentajes.get(mayor) > 10 && porcentajes.get(mayor) < 50)
						  || (porcentajes.get(menor) > 10 && porcentajes.get(menor) < 50)) {
					  porcentajes.set(mayor, porcentajes.get(mayor) - 0.5);
					  porcentajes.set(menor, porcentajes.get(menor) + 0.5);
				  }
				  
			  } else {
				  listo = true;
			  }
		  }
		vuelta++;
	  } while (listo || vuelta <= 25);
	  
	  
	  
    return porcentajes;
  }
  public ArrayList<Double> balancearEm (ArrayList<Ingrediente> ingres, Double requerimiento, ArrayList<Double> porcentajes) {
	  int menor = 0;
	  int mayor = 0;
	  int i = 0;
	  int vuelta = 0;
	  double em = 0;
	  Boolean listo = false;
	  double total = ingres.size();
	  
	  Mezcla m = new Mezcla();
	  do {
		  for (i = 0;i < total;i++) {
		        em = em + ((porcentajes.get(i) * ingres.get(i).getProteina()) / 100);
		      }
		  if (em < requerimiento) {
			  mayor = m.buscaMayorEm(ingres);
			  menor = m.buscaMenorEm(ingres);
			  if ((porcentajes.get(mayor) > 10 && porcentajes.get(mayor) < 50)
					  || (porcentajes.get(menor) > 10 && porcentajes.get(menor) < 50)) {
				  porcentajes.set(mayor, porcentajes.get(mayor) + 0.5);
				  porcentajes.set(menor, porcentajes.get(menor) - 0.5);
			  }
			  
			  
		  } else {
			  if ( em > (requerimiento +2)) {
				  mayor = m.buscaMayorEm(ingres);
				  menor = m.buscaMenorEm(ingres);
				  if ((porcentajes.get(mayor) > 10 && porcentajes.get(mayor) < 50)
						  || (porcentajes.get(menor) > 10 && porcentajes.get(menor) < 50)) {
					  porcentajes.set(mayor, porcentajes.get(mayor) - 0.5);
					  porcentajes.set(menor, porcentajes.get(menor) + 0.5);
				  }
				  
			  } else {
				  listo = true;
			  }
		  }
		vuelta++;
	  } while (listo || vuelta <= 25);
	  
	  
	  
    return porcentajes;
  }
  
  public ArrayList<Double> balancearTnd(ArrayList<Ingrediente> ingres, Double requerimiento, ArrayList<Double> porcentajes) {
	  int menor = 0;
	  int mayor = 0;
	  int i = 0;
	  int vuelta = 0;
	  double tnd = 0;
	  Boolean listo = false;
	  double total = ingres.size();
	  
	  Mezcla m = new Mezcla();
	  do {
		  for (i = 0;i < total;i++) {
		        tnd = tnd + ((porcentajes.get(i) * ingres.get(i).getProteina()) / 100);
		      }
		  if (tnd < requerimiento) {
			  mayor = m.buscaMayorTnd(ingres);
			  menor = m.buscaMenorTnd(ingres);
			  if ((porcentajes.get(mayor) > 10 && porcentajes.get(mayor) < 50)
					  || (porcentajes.get(menor) > 10 && porcentajes.get(menor) < 50)) {
				  porcentajes.set(mayor, porcentajes.get(mayor) + 0.5);
				  porcentajes.set(menor, porcentajes.get(menor) - 0.5);
			  }
			  
			  
		  } else {
			  if ( tnd > (requerimiento +2)) {
				  mayor = m.buscaMayorTnd(ingres);
				  menor = m.buscaMenorTnd(ingres);
				  if ((porcentajes.get(mayor) > 10 && porcentajes.get(mayor) < 50)
						  || (porcentajes.get(menor) > 10 && porcentajes.get(menor) < 50)) {
					  porcentajes.set(mayor, porcentajes.get(mayor) - 0.5);
					  porcentajes.set(menor, porcentajes.get(menor) + 0.5);
				  }
				  
			  } else {
				  listo = true;
			  }
		  }
		vuelta++;
	  } while (listo || vuelta <= 25);

    return porcentajes;
  }
  
  
  public ArrayList<Double> balancear(ArrayList<Ingrediente> ingres, Animal animal, ArrayList<Double> porcentajes) {
    Mezcla m = new Mezcla();
    int i = 0;
    int total = ingres.size();
    double pc = 0;
    double em = 0;
    double tnd = 0;
    contador++;
    if (contador <= 200) {
      porcentajes = m.balancearPc(ingres, animal.getPc(), porcentajes);
        for (i = 0;i < total;i++) {
          pc = pc + ((porcentajes.get(i) * ingres.get(i).getProteina()) / 100);
        }
        if (pc < animal.getPc() || pc > (animal.getPc() + 2)) {
        	m.balancear(ingres, animal, porcentajes);
        } else {
        	 porcentajes = m.balancearEm(ingres, animal.getEm(), porcentajes);
             for (i = 0;i < total;i++) {
            	 pc = pc + ((porcentajes.get(i) * ingres.get(i).getProteina()) / 100);
                 em = em + ((porcentajes.get(i) * ingres.get(i).getProteina()) / 100);
               }
             if ((pc < animal.getPc() || pc > (animal.getPc() + 2)) 
            		 || em < animal.getEm() || em > (animal.getEm() + 2)) {
            	 m.balancear(ingres, animal, porcentajes);       	 
             } else {
            	 porcentajes = m.balancearTnd(ingres, animal.getEm(), porcentajes);
                 for (i = 0;i < total;i++) {
                	 pc = pc + ((porcentajes.get(i) * ingres.get(i).getProteina()) / 100);
                     em = em + ((porcentajes.get(i) * ingres.get(i).getEm()) / 100);
                     tnd = tnd + ((porcentajes.get(i) * ingres.get(i).getTnd()) / 100);
                 }
                 if ((pc < animal.getPc() || pc > (animal.getPc() + 2)) 
                		 || em < animal.getEm() || em > (animal.getEm() + 2)
                		 || tnd < animal.getTnd() || tnd > (animal.getTnd() + 2)) {
                	 m.balancear(ingres, animal, porcentajes);
                 }
             }
        }
    	
    }
    
    return porcentajes;
	  
  }

  /** Imprime los ingredientes contenidos en la mezcla. **/
  public void imprimeMezcla() {
    int i = 0;
    System.out.println("Ingrediente\t\tPorcentaje en mezcla");
    for (i = 0;i < ingredientes.size();i++) {
      System.out.println(ingredientes.get(i).getNombre() + "\t\t" + porcentajes.get(i));
    }
  }
  
}
