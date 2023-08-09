package challenge;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TravelCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Obtener los datos del usuario
        System.out.print("Ingrese el destino de la vacación: ");
        String destinoM = scanner.nextLine();
        String destino = destinoM.toLowerCase();
        if (!validardestino(destino)) {
            System.out.println("El destino ingresado no es válido.Por favor ingrese uno correcto");
            return;
        }

        System.out.print("Ingrese el número de viajeros: ");
        int numViajeros;
        try {
            numViajeros = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("El número de viajeros ingresado no es válido.Por favor ingrese un dato correcto");
            return;
        }

        System.out.print("Ingrese la duración de la vacación en días: ");
        int duracion ;
        try {
            duracion = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("La duración ingresada no es válida.Por favor ingrese un dato correcto");
            return;
        }
        
        System.out.print("Desea ingresar un paquete opcional? S/N ");
        String adicional = null;
        try {
        	
        	String respuesta = scanner.nextLine();
        	String respuesta1 = respuesta.toUpperCase();
    
        	if(respuesta1.compareTo("N")==0) {
        		adicional = null;
        		System.out.println("Sin paquetes adicionales");
        	}
        	
        	if(respuesta1.compareTo("S")==0) {
        		System.out.print("Ingrese el paquete opcional que desea agregar: ");
        		adicional = scanner.nextLine();
        		System.out.println("Paquete " + adicional + " agregado exitosamente.");
        	}
        	
        }
        
        catch(Exception e) {
        	System.out.println("Escriba una respuesta valida");
        }
        

        
        TravelVacation travel = new TravelVacation();
        travel.setDias(duracion);
        travel.setPasajeros(numViajeros);
        travel.setOpcional(adicional);
        Country destination = new Country();
        destination.setNombre(destino);

    
        int costoTotal = calcularCostoTotal(travel, destination);

    
        if (numViajeros>80) {
            System.out.println("El paquete de vacaciones no está disponible para grupos de más de 80 personas.");
        } else {
            System.out.println("El costo total de la vacación es: $" + costoTotal);
        }
    }

    public static int calcularCostoTotal(TravelVacation travel, Country country) {
    	Map<String, Integer> opcionales = new HashMap<String, Integer>();
    	opcionales.put("All-Inclusive", 200);
    	opcionales.put("Adventure Activities", 150);
    	opcionales.put("Spa and Wellness", 100);
		
    	int costoTotal = 1000;
        int costoParis = 500;
        int costoNuevaYork=600;

        int numViajeros = travel.getPasajeros();
        int duracion = travel.getDias();
        String destino = country.getNombre();
        
        if (destino.equals("paris")) {
            costoTotal += costoParis ;
            
        }
        if (destino.equals("nueva york")){
        	costoTotal += costoNuevaYork ;
        } 

        if (4<=numViajeros && numViajeros<= 10) {
            costoTotal -= (costoTotal * 0.10) ;
        } 
        if (numViajeros > 10) {
            costoTotal -= (costoTotal * 0.20);
        }

        if (duracion < 7) {
            costoTotal += 200;
        }

        if (duracion > 30 || numViajeros == 2) {
            costoTotal -= 200;
        }

        if (numViajeros > 80) {
        	System.out.println("El paquete no esta disponible para grupos de mas de 80 personas y su grupo es de  $" + numViajeros);
        }
        
        if(travel.getOpcional() != null) {
			
			if( opcionales.containsKey(travel.getOpcional()) ) {
				int add = opcionales.get( travel.getOpcional() );
				int cost = travel.getPasajeros() * add;
				costoTotal = costoTotal + cost;
				
				System.out.print("paquete " + travel.getOpcional() + " (+$" + add + " por pasajero) = $" + costoTotal + "\n");
			}
		}

        return costoTotal;
    }
    public static boolean validardestino(String input) {
        String letras = "^[a-zA-Z\\s]+$";
        return input.matches(letras);
    }
}
