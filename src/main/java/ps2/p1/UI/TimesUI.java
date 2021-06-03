package ps2.p1.UI;

import java.util.List;

import ps2.p1.dao.Time;
import ps2.p1.dao.TimesDao;
import ps2.utils.DialogoGui;

public class TimesUI {
	private TimesDao dao;

	public TimesUI(TimesDao dao) {
		super();
		this.dao = dao;
	}

	private void opcaoCriarTabela() {
		try {
			dao.createTable();
			DialogoGui.mostrar("Tabela criada!");
		} catch (Exception ex) {
			ex.printStackTrace();
			DialogoGui.mostrar("Falha na operação! Veja as mensagens no Console!");
		}
	}

	private void opcaoApagarTabela() {
		try {
			dao.dropTable();
			DialogoGui.mostrar("Tabela apagada!");
		} catch (Exception ex) {
			ex.printStackTrace();
			DialogoGui.mostrar("Falha na operação! Veja as mensagens no Console!");
		}
	}

	private void opcaoCadastrar() {
		try {
			String nome = DialogoGui.lerString("Nome:");
			String mascote = DialogoGui.lerString("Mascote: ");
			String treinador = DialogoGui.lerString("Treinador: ");
			long qtd = DialogoGui.lerInteiroLongo("Quantidade de torcedores: ");
			long id = dao.create(nome, mascote, treinador, qtd);
			DialogoGui.mostrar("Time criado com id " + id);
		} catch (Exception ex) {
			ex.printStackTrace();
			DialogoGui.mostrar("Falha na operação! Veja as mensagens no Console!");
		}
	}

	private void opcaoConsultar() {
		try {
			String msg = "Time:\n";
			List<Time> times = dao.read();
			for (Time t : times) {
				msg += "ID: " + t.getId() + " - ";
				msg += "NOME: " + t.getNome() + " - ";
				msg += "MASCOTE: " + t.getMascote() + " - ";
				msg += "TREINADOR: " + t.getTreinador() + " - ";
				msg += "QUANTIDADE DE TORCEDORES: " + t.getQtd() + "\n";
			}
			DialogoGui.mostrar(msg);
		} catch (Exception ex) {
			ex.printStackTrace();
			DialogoGui.mostrar("Falha na operação! Veja as mensagens no Console!");
		}
	}

	private void opcaoAlterar() {
		try {
			long id = DialogoGui.lerInteiroLongo("ID do time a ser alterado:");
			Time t = dao.readById(id);
			if (t != null) {
				String nome = DialogoGui.lerString("Novo valor para o nome: ");
				String mascote = DialogoGui.lerString("Novo valor para o mascote: ");
				String treinador = DialogoGui.lerString("Novo valor para o treinador: ");
				long qtd = DialogoGui.lerInteiroLongo("Novo valor para quantidade de torcedores: ");
				
				t.setNome(nome);
				t.setMascote(mascote);
				t.setTreinador(treinador);
				t.setQtd(qtd);
				dao.update(t);
				DialogoGui.mostrar("Time atualizado com sucesso!");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			DialogoGui.mostrar("Falha na operação! Veja as mensagens no Console!");
		}
	}

	private void opcaoApagar() {
		try {
			long id = DialogoGui.lerInteiroLongo("ID do time a ser apagado:");
			dao.delete(id);
			DialogoGui.mostrar("Time removido com sucesso!");
		} catch (Exception ex) {
			ex.printStackTrace();
			DialogoGui.mostrar("Falha na operação! Veja as mensagens no Console!");
		}
	}

	public void dialogar() {
		boolean sair = false;
		while (!sair) {
			int op = DialogoGui.menu("Cadastrar", "Consultar", "Alterar", "Apagar",
					"Criar tabela", "Apagar tabela", "Sair");
			if (op == 1) {
				opcaoCadastrar();
			} else if (op == 2) {
				opcaoConsultar();
			} else if (op == 3) {
				opcaoAlterar();
			} else if (op == 4) {
				opcaoApagar();
			} else if (op == 5) {
				opcaoCriarTabela();
			} else if (op == 6) {
				opcaoApagarTabela();
			} else  if (op == 7) {
				sair = true;
			}
		}
		DialogoGui.mostrar("Fim do programa!");
	}
}
