package br.unisinos.jurimobile.model.entity.mock;

import br.unisinos.jurimobile.model.entity2.Advogado;
import br.unisinos.jurimobile.model.entity2.Processo;
import br.unisinos.jurimobile.model.entity2.ProcessoMovimento;
import br.unisinos.jurimobile.model.entity2.ProcessoParticipante;

public class TransformMockToEntity {

	public static Processo transformTo(ProcessoMock mock){
		Processo processo = new Processo();
		
		processo.setNumero(mock.getNumero());
		processo.setAssunto(mock.getAssunto());
		processo.setSituacao(mock.getSituacao());
		processo.setComarca(mock.getComarca());
		processo.setOrgaoJulgador(mock.getOrgaoJulgador());
		processo.setDataDistribuicao(mock.getDataDistribuicao());
		
		return processo;
		
	}
	
	public static ProcessoParticipante transformTo(ProcessoParticipanteMock mock){
		ProcessoParticipante processoParticipante = new ProcessoParticipante();
		
		processoParticipante.setNome(mock.getNome()); 
		processoParticipante.setTipoParticipacao(mock.getTipoParticipacao());
		processoParticipante.setTipoParticipante(mock.getTipoParticipante()); 

		return processoParticipante;
	}
	
	public static Advogado transformTo(AdvogadoMock mock){
		Advogado advogado = new Advogado();
		
		advogado.setNome(mock.getNome());
		advogado.setNumeroOAB(mock.getNumeroOAB());

		return advogado;
	}
	
	
	public static ProcessoMovimento transformTo(ProcessoMovimentoMock mock){
		ProcessoMovimento movimento = new ProcessoMovimento();
		
		movimento.setDataMovimentacao(mock.getDataMovimentacao());
		movimento.setDescricao(mock.getDescricao());
		movimento.setCodigoMovimentoCNJ(mock.getCodMovimentoCNJ());
		movimento.setTextoAjuda(mock.getTextoAjuda());

		return movimento;
	}
}
