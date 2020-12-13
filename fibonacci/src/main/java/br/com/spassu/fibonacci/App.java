package br.com.spassu.fibonacci;

import java.util.Scanner;

import br.com.spassu.fibonacci.service.FibonacciService;

public class App {
	
  int nro;	

  public static void main(String[] args) {
    FibonacciService fibonacciService = new FibonacciService();
    
    Scanner scan = new Scanner(System.in);
    String line = scan.nextLine();
   
    
    System.out.println(
      fibonacciService.getSequence(
        Integer.valueOf(line)
      )
    );
    
    scan.close();
  }
  
  private void fibo() {
	  FibonacciService fiboService = new FibonacciService();
	  
	  System.out.println("\nInforme um número inteiro:\n");
	  nro = Integer.parseInt(System.console().readLine());
	  for (int i = 0; i <= nro; i++) {
		  if(i < nro) {
			  System.out.println(
					  fiboService.getSequence(i)+", " 	      
			  );
		  }else {
			  System.out.println(
					  fiboService.getSequence(i)+"." 	      
			  );
		  }
	  }
	  
	  
  }
  
}
