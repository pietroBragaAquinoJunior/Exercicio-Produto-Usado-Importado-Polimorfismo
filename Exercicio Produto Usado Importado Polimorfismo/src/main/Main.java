package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Produto;
import entidades.ProdutoImportado;
import entidades.ProdutoUsado;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		/* Programa recebe informações referentes à produtos usados importados e comuns */
		/* Armazena e exibe as informações */
		/* Exercício em java para treinamento de Herança e Polimorfismo e outros conceitos básicos */
		
		List<Produto> produtos = new ArrayList<>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Número de produtos: ");
		int nProdutos = sc.nextInt();
		
		for(int i=0;i<nProdutos;i++) {
			System.out.println("Informações do produto #"+i);
			System.out.print("Produto comum, usado ou importado? (c,u,i): ");
			char ch = sc.next().charAt(0);
			if(ch == 'c') {
				System.out.print("Nome: ");
				String nome = sc.next();
				System.out.print("Preço: ");
				Double preco = sc.nextDouble();
				Produto produto = new Produto(nome,preco);
				produtos.add(produto);
			}else if(ch == 'u') {
				System.out.print("Nome: ");
				String nome = sc.next();
				System.out.print("Preço: ");
				Double preco = sc.nextDouble();
				System.out.print("Data de fabricação: ");
				Date dataFabricacao = sdf.parse(sc.next());
				Produto produto = new ProdutoUsado(nome,preco,dataFabricacao);
				produtos.add(produto);
			} else if (ch == 'i') {
				System.out.print("Nome: ");
				String nome = sc.next();
				System.out.print("Preço: ");
				Double preco = sc.nextDouble();
				System.out.print("Taxa alfandegária: ");
				Double taxaAlfandega = sc.nextDouble();
				Produto produto = new ProdutoImportado(nome,preco,taxaAlfandega);
				produtos.add(produto);
			} else {
				System.out.println("Não existe essa possibilidade.");
			}
		
		}
		
		for(Produto p : produtos) {
			System.out.println(p.etiquetaPreco());
		}
		
		sc.close();

	}

}
