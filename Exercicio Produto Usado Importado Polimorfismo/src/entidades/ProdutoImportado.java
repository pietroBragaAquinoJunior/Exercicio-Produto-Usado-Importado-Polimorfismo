package entidades;

public class ProdutoImportado extends Produto {

	private Double taxaAlfandega;
	
	public ProdutoImportado() {
		super();
	}

	public ProdutoImportado(String nome, Double preco, Double taxaAlfandega) {
		super(nome, preco);
		this.taxaAlfandega = taxaAlfandega;
	}

	public Double getTaxaAlfandega() {
		return taxaAlfandega;
	}

	public void setTaxaAlfandega(Double taxaAlfandega) {
		this.taxaAlfandega = taxaAlfandega;
	}
	
	public Double precoTotal() {
		return taxaAlfandega + super.getPreco();
	}
	
	@Override
	public String etiquetaPreco() {
		return super.getNome()+ "R$ " +String.format("%.2f", precoTotal())+" (Taxa alfandegária: R$"+taxaAlfandega+")";
	}
	
}
