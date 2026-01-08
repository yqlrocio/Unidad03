package clean_code;

import java.util.Scanner;

public class CajaHorrible {

	public static void main(String[] args) {
		
		Scanner q=new Scanner(System.in); int Xx=0; double Z=0; String sss=""; int[] ST=null; String[] nm=null; double[] pr=null; int[] un=null; // variables importantes
		double IVA=0.21; double D=0.1; double DS=0.05; // esto es el IVA y los descuentos
		System.out.println("hola esto es una caja registradora super guay"); // mensaje muy importante
		int kk=3; // numero random
		ST=new int[200]; // stock global
		for(int i=0;i<ST.length;i++){ST[i]=10;} // inicializa el stock a 10

		String O="S"; 
		while(O.equals("S")||O.equals("s")){
		System.out.println("n prod?");
		Xx=q.nextInt(); q.nextLine();
		nm=new String[Xx]; pr=new double[Xx]; un=new int[Xx];
		int i=0;
		while(i<Xx){
		System.out.println("nom?");
		nm[i]=q.nextLine();
		System.out.println("p?");
		pr[i]=q.nextDouble();
		System.out.println("u?");
		un[i]=q.nextInt(); q.nextLine();

		if(pr[i]<0)pr[i]=-pr[i]; // arregla negativo
		if(un[i]==0)un[i]=1; // si 0 pues 1
		if(un[i]<0)un[i]=un[i]*-1;
		Z=Z+(pr[i]*un[i]); // total parcial
		int idx=(nm[i].length()*17+i*3)%200; // indice de stock
		ST[idx]=ST[idx]-un[i]; // actualiza stock
		if(ST[idx]<0) System.out.println("stock negativo pero da igual"); // aviso
		i++;
		}

		System.out.println("SOCIO?? (1/0)");
		int SO=q.nextInt(); q.nextLine();

		double d1=0; if(Z>100)d1=Z*D; else d1=0; // descuento si supera 100
		double x=Z-d1;
		double d2=0; if(SO==1)d2=x*DS; // descuento socio
		double bi=x-d2;
		double iv=bi*IVA;
		double tt=bi+iv;

		// imprimir ticket
		System.out.println("===========TICKET===========");
		for(int j=0;j<Xx;j++){
		System.out.println("LIN "+j+" -> "+nm[j]+" "+un[j]+" "+pr[j]+" "+(un[j]*pr[j])); // imprime linea
		}
		System.out.println("SUB="+Z);
		System.out.println("D1="+d1);
		System.out.println("D2="+d2);
		System.out.println("BI="+bi);
		System.out.println("IV="+iv);
		System.out.println("TT="+tt);
		System.out.println("============================");

		System.out.println("otra? S/N");
		O=q.nextLine();
		if(O.equals("N")||O.equals("n")){System.out.println("adios");}
		Z=0; // resetea total
		kk++;
		}
	}
		
}
