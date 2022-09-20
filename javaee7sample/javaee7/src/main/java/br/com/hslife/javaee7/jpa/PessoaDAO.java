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

package br.com.hslife.javaee7.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.hslife.javaee7.jaxrs.Pessoa;

@Stateless
public class PessoaDAO {

	@PersistenceContext(unitName="javaeePU")
	EntityManager em;
	
	public void save(Pessoa pessoa) {
		em.persist(new PessoaEntity(pessoa));
	}
	
	public void update(Pessoa pessoa) {
		PessoaEntity pessoaEntity = em.find(PessoaEntity.class, pessoa.getId());
		pessoaEntity.setPessoa(pessoa);
		em.merge(pessoaEntity);
	}
	
	public void remove(Integer id) {
		PessoaEntity pessoaEntity = em.find(PessoaEntity.class, id);
		em.remove(pessoaEntity);
	}
	
	@SuppressWarnings("unchecked")
	public List<Pessoa> get() {
		List<PessoaEntity> pessoasEntity = em.createQuery("SELECT p FROM PessoaEntity p").getResultList();
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		for (PessoaEntity pe : pessoasEntity) {
			pessoas.add(pe.getPessoa());
		}
		
		return pessoas;
	}
	
	public Pessoa getPessoa(Integer id) {
		PessoaEntity pessoaEntity = em.find(PessoaEntity.class, id);
		return pessoaEntity.getPessoa();
	}
}
