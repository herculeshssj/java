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

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.hslife.javaee7.jpa.PessoaDAO;

@Path("pessoa")
public class PessoaResource {
	
	//@Inject
	//private PessoaEJB pessoaEJB;
	
	@Inject
	private PessoaDAO pessoaDAO;
	
	@GET
	@Path("teste")
	@SuppressWarnings("deprecation")
	public Response teste() {
		Pessoa p = new Pessoa();
		p.setId(1);
		p.setNome("Pessoa de teste");
		p.setIdade(30);
		p.setDataNascimento(new Date(1980-1900, 0, 0));
		
		return Response.ok(p, MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Produces("application/json")
	public List<Pessoa> findAll() {
		//return pessoaEJB.listarPessoas();
		return pessoaDAO.get();
	}

	@GET
	@Path("{id}")
	@Produces("application/json")
	public Pessoa findByID(@PathParam("id") int id) {
		//return pessoaEJB.buscarPessoa(id);
		return pessoaDAO.getPessoa(id);
	}
	
	@POST
	@Consumes("application/json")
	public Response save(Pessoa pessoa) {
		//pessoa.setId(pessoaEJB.getNextID());
		//pessoaEJB.salvarPessoa(pessoa);
		pessoaDAO.save(pessoa);
		return Response.ok().build();
	}
	
	@PUT
	@Consumes("application/json")
	public Response update(Pessoa pessoa) {
		//pessoaEJB.editarPessoa(pessoa);
		pessoaDAO.update(pessoa);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("{id}")
	public Response remove(@PathParam("id") int id) {
		//pessoaEJB.removerPessoa(id);
		pessoaDAO.remove(id);
		return Response.ok().build();
	}
}
