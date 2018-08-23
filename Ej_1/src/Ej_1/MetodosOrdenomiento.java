package Ej_1;

import java.util.Random;

public class MetodosOrdenomiento {

	
	
	
	public static void main(String[] args) {
		
		String [] arreglo = new String[10];
		
		llenarArregloCadena(arreglo);
		System.out.println("Arreglo desordenado");
		
		for (String string : arreglo) {
			System.out.print(" " + string);
		}
		
		ordenamientoShell(arreglo);
		System.out.println();
		
		System.out.println("Arreglo ordenado shell");
		
		for (String string : arreglo) {
			System.out.print(" "+string);
		}
		System.out.println();
		System.out.println("Arreglo ordenado por insercion");
		ordenamientoPorInsercion(arreglo);
		
		for (String string : arreglo) {
			System.out.print(" "+string);
		}
		
		System.out.println();
		System.out.println("Arreglo ordenado por quiqsort");
		
		quicksort(arreglo, 0, arreglo.length);
		
		for (String string : arreglo) {
			System.out.print(" "+string);
		}
		
	}
	
	
	public static void llenarArregloCadena(String a[]) {
		Random letraAleatoria = new Random();
		for (int i = 0; i < a.length; i++) {
			a[i] = " " 	+ (char)(65+letraAleatoria.nextInt(26))
						+(char)(65+letraAleatoria.nextInt(26))
						+(char)(65+letraAleatoria.nextInt(26));
		}
	}
	
	public static void llenarArregloDouble(Double a[]) {
		Random numeroAleatorio = new Random();
		for (int i = 0; i < a.length; i++) {
			a[i] = 1 + numeroAleatorio.nextDouble();
		}
	}
	
	public static void llenarArregloEnteros(Integer a[]) {
		Random numeroAleatorio = new Random(); 
		for (int i = 0; i < a.length; i++) {
			a[i] = 1 + numeroAleatorio.nextInt(100);
		}
	}
	
	public static <T extends Comparable<? super T>>
	void quicksort(T[] a,int left,int right) {
		
		int i,j;
		T tmp;
		i=left;
		j=right;
		
		do {
			while(a[j].compareTo(a[i])>0 && j>i) j--;
				
			if(i<j) {
				tmp = a[i];
				a[i]= a[j];
				a[j]=tmp;
				i++;
			}
			
			
			while(a[i].compareTo(a[j])<0&&i<j)
				i++;
			if(i<j) {
				tmp = a[i];
				a[i]= a[j];
				a[j]= tmp;
				j--;
			}
		}while(i<j);
		if(left<j)
			quicksort(a, left, j-1);
		if(i<right)
			quicksort(a, i+1, right);
	}
		
	
	public static <T extends Comparable<? super T>> 
	void ordenamientoShell(T[] a){
		int gap,i,j;
		T temp;
		for (gap = a.length/2; gap > 0;gap /=2) {
			for (i = gap; i < a.length; i++) {
				for (j = i-gap;j>=0 && a[j].compareTo(a[j+gap])>0;j-=gap) {
					temp = a[j];
					a[j]=a[j+gap];
					a[j+gap]=temp;
				}
			}
		}	
	}
	
	 
	
	public static <AnyType extends Comparable<? super AnyType>> 
	void ordenamientoPorInsercion(AnyType [] a) {
		for (int p = 1; p < a.length; p++) {
			
			AnyType tmp = a[p];
			int j = p;
			
			for(;j>0&&tmp.compareTo(a[j-1])<0;j--) {
				a[j]=a[j-1];
				a[j-1]=tmp;
			}
		}
	}

}
