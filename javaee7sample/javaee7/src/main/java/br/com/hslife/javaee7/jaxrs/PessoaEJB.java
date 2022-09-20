/***
  
  	Copyright (c) 2016 Hércules S. S. José

    Este arquivo é parte do programa Java EE 7 Sample.
    

    Java EE 7 Sample é um software livre; você pode redistribui-lo e/ou 

    modificá-lo dentro dos termos da Licença Pública Geral Menor GNU como 

    publicada pela Fundação do Software Livre (FSF); na versão 2.1 da 

    Licença.
    

    Este programa é distribuído na esperança que possa ser útil, 

    mas SEM NENHUMA GARANTIA; sem uma garantia implícita de ADEQUAÇÂO a 
    
    qualquer MERCADO ou APLICAÇÃO EM PARTICULAR. Veja a Licença Pública 
    
    Geral Menor GNU em português para maiores detalhes.
    

    Você deve ter recebido uma cópia da Licença Pública Geral Menor GNU sob o 

    nome de "LICENSE.TXT" junto com este programa, se não, acesse o site do
    
    projeto no endereco https://github.com/herculeshssj/javaee7sample ou escreva 
    
    para a Fundação do Software Livre(FSF) Inc., 51 Franklin St, Fifth Floor, 
    
    Boston, MA  02110-1301, USA.
    

    Para mais informações sobre o programa Orçamento Doméstico e seu autor entre  

    em contato pelo e-mail herculeshssj@outlook.com, ou ainda escreva para 

    Hércules S. S. José, Av. Ministro Lafaeyte de Andrade, 1683 - Bl. 3 Apt 404, 

    Marco II - Nova Iguaçu, RJ, Brasil.

**/

package br.com.hslife.javaee7.jaxrs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Singleton;

@Singleton
public class PessoaEJB {
	
	private List<Pessoa> pessoaDB = new ArrayList<Pessoa>();
	
	@SuppressWarnings("deprecation")
	public PessoaEJB() {
		Pessoa p = new Pessoa();
		p.setId(pessoaDB.size());
		p.setNome("Pessoa de teste");
		p.setIdade(30);
		p.setDataNascimento(new Date(1980-1900, 0, 0));
		
		pessoaDB.add(p);
	}

	public void salvarPessoa(Pessoa pessoa) {
		pessoaDB.add(pessoa);
	}
	
	public void editarPessoa(Pessoa pessoa) {
		try {
			pessoaDB.set(pessoa.getId(), pessoa);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void removerPessoa(int id) {
		pessoaDB.remove(id);
	}
	
	public List<Pessoa> listarPessoas() {
		return pessoaDB;
	}
	
	public Pessoa buscarPessoa(int id) {
		return pessoaDB.get(id);
	}
	
	public int getNextID() {
		return pessoaDB.size();
	}
}
