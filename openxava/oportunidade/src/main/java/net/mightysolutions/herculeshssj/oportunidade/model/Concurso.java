package net.mightysolutions.herculeshssj.oportunidade.model;

import java.time.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.model.*;

import lombok.*;

@Entity
@Table(name="concursos")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Tab(properties = "titulo, descricao, uf, arquivado")
public class Concurso extends Identifiable {
    
    @Column(nullable = false)
    @ReadOnly
    String titulo;

    @Column(nullable = false)
    @ReadOnly
    @Stereotype("MEMO")
    String descricao;

    @Column(nullable = false)
    @ReadOnly
    @Stereotype("WEBURL")
    String link;

    @Column(length = 2, nullable = false)
    @ReadOnly
    String uf;

    @Column(nullable = false)
    @ReadOnly
    String hash;

    @Column(name="data_cadastro")
    @Stereotype("DATETIME")
    LocalDateTime dataCadastro;

    @Column
    @ReadOnly
    String cargos;

    @Column
    @ReadOnly
    Double salario;

    @Column(name="nivel_escolaridade")
    @ReadOnly
    String nivelEscolaridade;

    @Column
    @ReadOnly
    Integer vagas;

    @Column(name="vagas_cargos_salarios")
    @ReadOnly
    String vagasCargosSalarios;

    @Column(name="periodo_inscricao")
    @ReadOnly
    String periodoInscricao;

    @Column(name="data_termino_inscricao")
    @ReadOnly
    LocalDate dataTerminoInscricao;

    @Column
    @ReadOnly
    Boolean arquivado;

    public String toString() {
        return this.titulo + "\n\r" + this.descricao + "\n\r" + "UF: " + this.uf + "\n\r" + this.link + "\n\r" + this.vagasCargosSalarios + "\n\r" + this.periodoInscricao;
    }
}
