package br.com.hslife.concurso.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="concursos")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Concurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    
    @Column(nullable = false, length = 1000)
    String titulo;

    @Column(nullable = false, length = 1000)
    String descricao;

    @Column(nullable = false, length = 1000)
    String link;

    @Column(length = 2, nullable = false)
    String uf;

    @Column(nullable = false)
    String hash;

    @Column(name="data_cadastro")
    LocalDateTime dataCadastro;

    @Column(length = 100)
    String cargos;

    @Column
    Double salario;

    @Column(name="nivel_escolaridade", length = 100)
    String nivelEscolaridade;

    @Column
    Integer vagas;

    @Column(name="vagas_cargos_salarios", length = 1000)
    String vagasCargosSalarios;

    @Column(name="periodo_inscricao")
    String periodoInscricao;

    @Column(name="data_termino_inscricao")
    LocalDate dataTerminoInscricao;

    @Column
    Boolean arquivado;

    public String toString() {
        return this.titulo + "\n\r" + this.descricao + "\n\r" + "UF: " + this.uf + "\n\r" + this.link + "\n\r" + this.vagasCargosSalarios + "\n\r" + this.periodoInscricao;
    }
}
