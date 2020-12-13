package br.com.spassu.cliente;

public class Compras {
	
	private int id;
	   
	private String data_compra;
	   
	private float valor_compra;
	
	public Compras(){
		   
		   
	}
	
	public Integer getId(){
		   
		   return id;
	   }
	   
	   public void setId(int id){
	   
	       this.id = id;
	   }
	   
	   public String getDataCompra(){
	   
		   return data_compra;
	   }
	   
	   public void setDataCompra(String data_compra){
	   
		   this.data_compra = data_compra;
	   }
	   
	   public float getValorCompra(){
	   
		   return valor_compra;
	   }
	   
	   public void setValorCompra(float valor_compra){
	   
		   this.valor_compra = valor_compra;
	   }


}
