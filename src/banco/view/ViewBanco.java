package banco.view;

import banco.model.Agencia;
import banco.model.Banco;
import banco.model.Cliente;
import banco.model.ContaBancaria;
import banco.model.ContaCorrente;
import banco.model.ContaPoupanca;
import banco.model.Funcionario;
import java.util.Scanner;

public class ViewBanco {
	
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		Banco banco = new Banco();
		int numeroAgencia = 1;
		Agencia agencia = new Agencia(numeroAgencia);
		banco.adicionarAgencia(agencia);
		Funcionario funcionario = null;
		int numCC = 1;
		int numCP = 1;
		boolean run = true;
		
		while(run){
			System.out.println("[1] Terminal do Funcionário\n[2] Terminal do Cliente\n[0] Sair");
			String opcao = input.next();
			switch(opcao) {
				case "0":
					run = false;
					break;
				
				case "1":
					System.out.println("Insira seu login: ");
					String loginf = input.next();
					System.out.println("Insira sua senha: ");
					String senhaf = input.next();
					if(funcionario != null && (funcionario.getLoginFuncionario().equals(loginf) && funcionario.getSenhaFuncionario().equals(senhaf))) {
						boolean run_tf = true;
						while(run_tf) {
							System.out.println("\n[1] Cadastrar cliente\n[2] Criar Conta Corrente\n[3] Criar Conta Poupança\n[4] Desativar Conta\n[0] Sair\n");
							int opF = input.nextInt();
							switch(opF) {
								case 0:
									run_tf = false;
									break;
								
								case 1:
									System.out.println("Nome do Cliente: ");
									String nomeC = input.next();
									System.out.println("Telefone do Cliente: ");
									String telefoneC = input.next();
									System.out.println("Email do Cliente: ");
									String emailC = input.next();
									System.out.println("CPF do Cliente: ");
									String cpfC = input.next();
									System.out.println("Senha do Cliente: ");
									String senhaC = input.next();
									System.out.println("\nDeseja finalizar o cadastro?\n[1] Sim\n[2] Não\n");
									int finalizar = input.nextInt();
									if(finalizar == 1) {
										Cliente cliente = new Cliente(nomeC, telefoneC, emailC, cpfC, senhaC);
										System.out.println("\n<Cadastro efetuado com sucesso>\n");
										agencia.adicionarCliente(cliente);
									}
									else {
										System.out.println("\n<Cadastro cancelado>\n");
										break;
									}
									break;
									
								case 2:
									System.out.println("Insira o CPF do Cliente cadastrado: ");
									String cpf = input.next();
									Cliente clienteC = agencia.buscaCliente(cpf);
									if(clienteC != null) {
										ContaCorrente contaC = new ContaCorrente(numCC, clienteC, 0);
										contaC.ativarConta();
										clienteC.setConta(contaC);
										agencia.adicionarConta(contaC);
										System.out.println("\n<Conta criada com sucesso>\n\nNúmero da Conta: " + numCC+"\n");
										numCC++;
									}
									else {
										System.out.println("\n<CPF inválido>\n");
										break;
									}
									break;
									
								case 3:
									System.out.println("Insira o CPF do Cliente cadastrado: ");
									String cpfP = input.next();
									Cliente clienteP = agencia.buscaCliente(cpfP);
									if(clienteP != null) {
										ContaPoupanca contaP = new ContaPoupanca(numCP, clienteP, 0);
										contaP.ativarConta();
										clienteP.setConta(contaP);
										agencia.adicionarConta(contaP);
										System.out.println("\n<Conta criada com sucesso>\n\nNúmero da Conta: " + numCP+"\n");
										numCP++;
									}
									else {
										System.out.println("\n<CPF inválido>\n");
										break;
									}
									break;
									
								case 4:
									//falta terminar
									break;
									
								default:
									System.out.println("\n<Opção inválida>\n");
									break;
							}
						}
					}
					else {
						System.out.println("\n<Login ou Senha inválidos>\n");
						break;
					}
					break;
					
				case "2":
					System.out.println("Insira seu CPF:");
					String cpf = input.next();
					System.out.println("Insira sua senha:");
					String senha = input.next();
					if((agencia.buscaCliente(cpf) != null) && (agencia.buscaCliente(cpf).getSenha().equals(senha))) {
						boolean run_tc = true;
						while(run_tc) {
							System.out.println("\n[1] Conta Corrente\n[2] Conta Poupança\n[0] Sair\n");
							Cliente c = agencia.buscaCliente(cpf);
							int opC = input.nextInt();
							switch(opC) {
								case 0:
									run_tc = false;
									break;
								
								case 1:
									boolean cc_run = true;
									while(cc_run) {
										System.out.println("\n[1] Depositar\n[2] Sacar\n[3] Saldo\n[4] Transferencia\n[0] Sair\n");
										int opcoesCC = input.nextInt();
										switch(opcoesCC) {
											case 0:
												cc_run = false;
												break;
											
											case 1: //depositar
												System.out.println("Insira o número da sua Conta: ");
												int numero = input.nextInt();
												ContaCorrente cc = (ContaCorrente)c.buscaConta(numero);
												if(cc != null) {
													System.out.println("Insira o valor do depósito: ");
													double valorD = input.nextDouble();
													System.out.println("\nFinalizar a operação\n[1] Sim\n[2] Não\n");
													int finalizar1 = input.nextInt();
													if(finalizar1 == 1) {
														cc.depositar(valorD);
														System.out.println("\n<Operação concluída com sucesso>\n");
													}
													else {
														System.out.println("\n<Operação cancelada>\n");
														break;
													}
												}
												else {
													System.out.println("\n<Número de Conta inválido>\n");
													break;
												}
												break;
											
											case 2: //sacar
												System.out.println("Insira o número da sua Conta: ");
												int numeroS = input.nextInt();
												ContaCorrente ccS = (ContaCorrente)c.buscaConta(numeroS);
												if(ccS != null) {
													System.out.println("Insira o valor do saque: ");
													double valorS = input.nextDouble();
													if(valorS <= ccS.getSaldo()) {
														System.out.println("\nFinalizar a operação\n[1] Sim\n[2] Não\n");
														int finalizar1 = input.nextInt();
														if(finalizar1 == 1) {
															ccS.sacar(valorS);
															System.out.println("\n<Operação concluída com sucesso>\n");
														}
														else {
															System.out.println("\n<Operação cancelada>\n");
															break;
														}
													}
													else {
														System.out.println("\n<Valor inválido>\n");
														break;
													}
									
												}
												else {
													System.out.println("\n<Número de Conta inválido>\n");
													break;
												}
												break;
												
											case 3: // saldo
												System.out.println("Insira o número da sua Conta: ");
												int numeroSa = input.nextInt();
												ContaCorrente ccSa = (ContaCorrente)c.buscaConta(numeroSa);
												if(ccSa != null) {
													System.out.println("\nSeu Saldo é: "+ ccSa.getSaldo()+"\n");
												}
												else {
													System.out.println("\n<Número de Conta inválido>\n");
													break;
												}
												break;
											
											case 4: //transferencia
												System.out.println("Insira o número da sua Conta: ");
												int numeroT = input.nextInt();
												ContaCorrente ccT = (ContaCorrente)c.buscaConta(numeroT);
												if(ccT != null) {
													System.out.println("\nInsira o CPF do titular da Conta destino: ");
													String cpf_d = input.next();
													Cliente cd = agencia.buscaCliente(cpf_d);
													if(cd != null) {
														System.out.println("\nInsira o número da Conta destino da transferência: ");
														int numero_td = input.nextInt();
														ContaCorrente ccd = (ContaCorrente)cd.buscaConta(numero_td);
														if(ccd != null) {
															System.out.println("\nInsira o valor da transferência: ");
															double valor_t = input.nextDouble();
															if(valor_t <= ccT.getSaldo()) {
																System.out.println("\nFinalizar a operação\n[1] Sim\n[2] Não\n");
																int finalizar3 = input.nextInt();
																if(finalizar3 == 1) {
																	ccT.transferencia(ccd, valor_t);
																	System.out.println("\n<Transferencia efetuada com sucesso>\n");
																}
																else {
																	System.out.println("\n<Operação cancelada>\n");
																	break;
																}
															}
															else {
																System.out.println("\n<Valor inválido>\n");
																break;
															}
																
														}
														else {
															System.out.println("\n<Número de Conta inválido>\n");
															break;
														}
													}
													else {
														System.out.println("\n<CPF inválido>\n");
														break;
													}
												}
												else {
													System.out.println("\n<Número de Conta inválido>\n");
													break;
												}
												break;
											
											default:
												System.out.println("\n<Opção inválida>\n");
												break;
											
										}
									}
									break;
								
								case 2:
									boolean cp_run = true;
									while(cp_run) {
										System.out.println("\n[1] Depositar\n[2] Sacar\n[3] Saldo\n[4] Transferencia\n[0] Sair\n");
										int opcoesCP = input.nextInt();
										switch(opcoesCP) {
											case 0:
												cp_run = false;
												break;
											
											case 1:
												System.out.println("Insira o número da sua Conta: ");
												int numero = input.nextInt();
												ContaPoupanca cp = (ContaPoupanca)c.buscaConta(numero);
												if(cp != null) {
													System.out.println("Insira o valor do depósito: ");
													double valorD = input.nextDouble();
													System.out.println("\nFinalizar a operação\n[1] Sim\n[2] Não\n");
													int finalizar1 = input.nextInt();
													if(finalizar1 == 1) {
														cp.depositar(valorD);
														System.out.println("\n<Operação concluída com sucesso>\n");
													}
													else {
														System.out.println("\n<Operação cancelada>\n");
														break;
													}
												}
												else {
													System.out.println("\n<Número de Conta inválido>\n");
													break;
												}
												break;
											
											case 2:
												System.out.println("Insira o número da sua Conta: ");
												int numeroS = input.nextInt();
												ContaPoupanca cpS = (ContaPoupanca)c.buscaConta(numeroS);
												if(cpS != null) {
													System.out.println("Insira o valor do saque: ");
													double valorS = input.nextDouble();
													if(valorS <= cpS.getSaldo()) {
														System.out.println("\nFinalizar a operação\n[1] Sim\n[2] Não\n");
														int finalizar1 = input.nextInt();
														if(finalizar1 == 1) {
															cpS.sacar(valorS);
															System.out.println("\n<Operação concluída com sucesso>\n");
														}
														else {
															System.out.println("\n<Operação cancelada>\n");
															break;
														}
													}
													else {
														System.out.println("\n<Valor inválido>\n");
														break;
													}
									
												}
												else {
													System.out.println("\n<Número de Conta inválido>\n");
													break;
												}
												break;
												
											case 3:
												System.out.println("Insira o número da sua Conta: ");
												int numeroSa = input.nextInt();
												ContaPoupanca cpSa = (ContaPoupanca)c.buscaConta(numeroSa);
												if(cpSa != null) {
													System.out.println("\nSeu Saldo é: "+ cpSa.getSaldo()+"\n");
												}
												else {
													System.out.println("\n<Número de Conta inválido>\n");
													break;
												}
												break;
											
											case 4:
												System.out.println("Insira o número da sua Conta: ");
												int numeroT = input.nextInt();
												ContaPoupanca cpT = (ContaPoupanca)c.buscaConta(numeroT);
												if(cpT != null) {
													System.out.println("\nInsira o CPF do titular da Conta destino: ");
													String cpf_d = input.next();
													Cliente cd = agencia.buscaCliente(cpf_d);
													if(cd != null) {
														System.out.println("\nInsira o número da Conta destino da transferência: ");
														int numero_td = input.nextInt();
														ContaPoupanca cpd = (ContaPoupanca)cd.buscaConta(numero_td);
														if(cpd != null) {
															System.out.println("\nInsira o valor da transferência: ");
															double valor_t = input.nextDouble();
															if(valor_t >= cpT.getSaldo()) {
																System.out.println("\nFinalizar a operação\n[1] Sim\n[2] Não\n");
																int finalizar3 = input.nextInt();
																if(finalizar3 == 1) {
																	cpT.transferenciaCpoupanca(cpd, valor_t);
																	System.out.println("\n<Transferencia efetuada com sucesso>\n");
																}
																else {
																	System.out.println("\n<Operação cancelada>\n");
																	break;
																}
															}
																
														}
														else {
															System.out.println("\n<Número de Conta inválido>\n");
															break;
														}
													}
													else {
														System.out.println("\n<CPF inválido>\n");
														break;
													}
												}
												else {
													System.out.println("\n<Número de Conta inválido>\n");
													break;
												}
												break;
											
											default:
												System.out.println("\n<Opção inválida>\n");
												break;
											
										}
									}
									break;
								
								default:
									System.out.println("\n<Opção inválida>\n");
									break;
							}
						}
					}
					else {
						System.out.println("\n<CPF ou Senha inválidos>\n");
						break;
					}
					break;
					
				case "admin":
					System.out.println("\n-----Terminal do administrador-----\n");
					System.out.println("Cadastrar funcionário");
					System.out.println("\nlogin:");
					String loginF = input.next();
					System.out.println("senha:");
					String senhaF = input.next();
				    funcionario = new Funcionario(loginF, senhaF);
					banco.adicionarFuncionario(funcionario);
					System.out.println("\n<Cadastro Concluido>\n");
					break;
					
				default:
					System.out.println("\n<Opção inválida>\n");
					break;
			}
		}
	}
}
