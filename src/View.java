import java.util.Scanner;

public class View{
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		
		Banco banco = new Banco();
		Agencia agencia = new Agencia(1);
		Funcionario funcionario = new Funcionario("Pedro","0000");
		agencia.adicionarFuncionario(funcionario);
		banco.adicionarAgencia(agencia);
		boolean run = true;
		int numCC = 1;
		int numCP = 1;
		
		while(run){
			System.out.println("[1] Terminal do Funcionário\n[2] Terminal do Cliente\n[3] Sair");
			int t = input.nextInt();
			switch(t){ // terminal do funcionário
				case 1:
					boolean run_t = true;
					while(run_t) {
						System.out.println("Insira seu login: ");
						String loginf = input.next();
						System.out.println("Insira sua senha: ");
						String senhaf = input.next();
						if(funcionario.getLoginFuncionario().equals(loginf) && funcionario.getSenhaFuncionario().equals(senhaf)) {
							boolean run_op = true;
							while(run_op) {
								System.out.println("[1] Cadastrar cliente\n[2] Criar Conta Corrente\n[3] Criar Conta Poupança\n[4] Desativar Conta\n[5] Sair");
								int opF = input.nextInt();
								switch(opF) {
									case 1: //cadastro
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
										System.out.println("Deseja finalizar o cadastro?\n[1] Sim\n[2] Não");
										int finalizar = input.nextInt();
										if(finalizar == 1) {
											Cliente cliente = new Cliente(nomeC, telefoneC, emailC, cpfC, senhaC);
											System.out.println("Cadastro efetado comm sucesso");
											agencia.adicionarCliente(cliente);
										}
										else {
											System.out.println("Cadastro Cancelado");
										}
										break;
										
									case 2: //criar conta corrente
										boolean ver1 = true;
										while(ver1) {
											System.out.println("Insira o CPF do Cliente cadastrado: ");
											String cpf = input.next();
											Cliente clienteC = agencia.buscaCliente(cpf);
											if(clienteC != null) {
												ContaCorrente contaC = new ContaCorrente(numCC, clienteC);
												contaC.ativarConta();
												clienteC.setContaCorrente(contaC);
												agencia.adicionarContaCorrente(contaC);
												System.out.println("Conta criada com sucesso\nNúmero da Conta: " + numCC);
												numCC++;
												ver1 = false;
											}
											else {
												System.out.println("CPF inválido\nDeseja Cancelar a operação?\n[1] Sim\n[2] Nao");
												int cancel = input.nextInt();
												if(cancel == 1) {
													ver1 = false;
												}
												else {
													continue;
												}
											}
										}
										break;
										
									case 3: //criar conta poupança
										boolean ver2 = true;
										while(ver2) {
											System.out.println("Insira o CPF do Cliente cadastrado: ");
											String cpfP = input.next();
											Cliente clienteP = agencia.buscaCliente(cpfP);
											if(clienteP != null) {
												ContaPoupanca contaP = new ContaPoupanca(numCP, clienteP);
												contaP.ativarConta();
												clienteP.setContaPoupanca(contaP);
												agencia.adicionarContaPoupanca(contaP);
												System.out.println("Conta criada com sucesso\nNúmero da Conta: " + numCP);
												numCP++;
												ver2 = false;
											}
											else {
												System.out.println("CPF inválido\nDeseja Cancelar a operação?\n[1] Sim\n[2] Nao");
												int cancel = input.nextInt();
												if(cancel == 1) {
													ver2 = false;
												}
												else {
													continue;
												}
											}
										}
										break;
									case 4: // desativar conta
										//System.out.println("[1]Desativar Conta Poupanca");
										break;
									case 5:
										run_op = false;
										run_t = false;
										break;
									default:
										System.out.println("Opcao Inválida");
										break;
								}
							}
						}
						else {
							System.out.println("Login ou senha incorretos");
							System.out.println("Deseja cancelar a operação?\n[1] Sim\n[2] Não");
							int cancLogin = input.nextInt();
							if(cancLogin == 1) {
								System.out.println("Operacao cancelada");
								run_t = false;
							}
							else {
								continue;
							}
						}
					}
					break;
					
				case 2: // terminal do cliente
					boolean ver = true;
					while(ver) {
						System.out.println("Insira seu CPF:");
						String cpf = input.next();
						System.out.println("Insira sua senha:");
						String senha = input.next();
						if(agencia.buscaCliente(cpf) != null) {
							if(agencia.buscaCliente(cpf).getSenha().equals(senha)){
								System.out.println("CPF e senha corretos");
								Cliente c = agencia.buscaCliente(cpf);
								boolean run_c = true;
								while(run_c) {
									System.out.println("[1] Conta Corrente\n[2] Conta Poupança\n[3] Sair");
									int opC = input.nextInt(); //opcao de conta
									switch(opC) {
										case 1:
											// conta corrente
											boolean cc_r = true; 
											while(cc_r){
												System.out.println("[1] Depositar\n[2] Sacar\n[3] Saldo\n[4] Transferencia\n[5] Sair");
												int opcoesCC = input.nextInt();
												switch(opcoesCC) {
													case 1: //depositar
															boolean verN1 = true;
															while(verN1) {
																System.out.println("Insira o número da sua Conta: ");
																int numero = input.nextInt();
																ContaCorrente cc = c.buscaContaCorrente(numero);
																if(cc != null) {
																	System.out.println("Insira o valor do depósito: ");
																	double valorD = input.nextDouble();
																	System.out.println("Finalizar a operação\n[1] Sim\n[2] Não");
																	int finalizar1 = input.nextInt();
																	if(finalizar1 == 1) {
																		cc.depositar(valorD);
																		System.out.println("Operação concluída com sucesso");
																		verN1 = false;
																	}
																	else {
																		System.out.println("Operação Cancelada");
																		verN1 = false;
																	}
																}
																else {
																	System.out.println("Numero da conta inválido");
																}
															}
															break;
														
													case 2: // sacar
															boolean verN2 = true;
															while(verN2) {
																System.out.println("Insira o número da sua Conta: ");
																int numero_s = input.nextInt();
																ContaCorrente cc_s = c.buscaContaCorrente(numero_s);
																if(cc_s != null) {
																	boolean r_saque = true;
																	while(r_saque) {
																		System.out.println("Insira o valor do saque: ");
																		double valorS = input.nextDouble();
																		if(valorS <= cc_s.getSaldo()) {
																			System.out.println("Finalizar a operação\n[1] Sim\n[2] Não");
																			int finalizar2 = input.nextInt();
																			if(finalizar2 == 1) {
																				cc_s.sacar(valorS);
																				System.out.println("Operação concluída com sucesso");
																				r_saque = false;
																			}
																			else {
																				System.out.println("Operação cancelada");
																				r_saque = false;
																			}
																		}
																		else{
																			System.out.println("Valor inválido");
																		}
																	}
																	System.out.println("Operação concluída com sucesso");
																	verN2 = false;
																}
																else {
																	System.out.println("Numero da conta inválido");
																}
															}
															break;
															
													case 3: // saldo
														boolean verN3 = true;
														while(verN3) {
															System.out.println("Insira o número da sua Conta: ");
															int numero_sa = input.nextInt();
															ContaCorrente cc_sa = c.buscaContaCorrente(numero_sa);
															if(cc_sa != null) {
																System.out.println("Seu Saldo é: "+ cc_sa.getSaldo());
																verN3 = false;
															}
															else {
																System.out.println("Numero da conta inválido");
																int cancelarSaldo = input.nextInt();
																if(cancelarSaldo == 1) {
																	verN3 = false;
																}
																else {
																	continue;
																}
															}
														}
														break;
														
													case 4: // transferencia
														boolean verN4 = true;
														while(verN4) {
															System.out.println("Insira o número da sua Conta: ");
															int numero_tt = input.nextInt();
															ContaCorrente cc_t = c.buscaContaCorrente(numero_tt);
															if(cc_t != null) {
																boolean vercpf = true;
																while(vercpf) {
																	System.out.println("Insira o CPF do titular da Conta destino: ");
																	String cpf_d = input.next();
																	Cliente cd = agencia.buscaCliente(cpf_d);
																	if(cd != null) {
																		boolean verND = true;
																		while(verND) {
																			System.out.println("Insira o número da Conta destino da transferência: ");
																			int numero_td = input.nextInt();
																			ContaCorrente ccd = cd.buscaContaCorrente(numero_td);
																			if(ccd != null) {
																				System.out.println("Insira o valor da transferência: ");
																				double valor_t = input.nextDouble();
																				if(valor_t >= cc_t.getSaldo()) {
																					System.out.println("Finalizar a operação\n[1] Sim\n[2] Não");
																					int finalizar3 = input.nextInt();
																					if(finalizar3 == 1) {
																						cc_t.transferenciaCcorrente(ccd, valor_t);
																						System.out.println("Transferencia efetuada com sucesso");
																						verND = false;
																						vercpf = false;
																						verN4 = false;
																					}
																					else {
																						System.out.println("Operação cancelada");
																						verND = false;
																						vercpf = false;
																						verN4 = false;
																					}
																				}
																				else {
																					System.out.println("Valor inválido");
																				}
																			}
																			else {
																				System.out.println("Número da conta destino inválido");
																			}
																		}
																	}
																	else {
																		System.out.println("CPF inválido");
																	}
																}
															}
															else {
																System.out.println("Numero da Conta inválido");
															}
														}
														break;
														
													case 5: // sair
														cc_r = false;
														break;
														
													default:
														System.out.println("Opcao Inválida");
														break;
												}
											}
											break;
										case 2:
											// conta Poupança
											boolean cp_r = true; 
											while(cp_r){
												System.out.println("[1] Depositar\n[2] Sacar\n[3] Saldo\n[4] Transferencia\n[5] Sair");
												int opcoesCP = input.nextInt();
												switch(opcoesCP) {
													case 1: //depositar
														boolean verN1 = true;
														while(verN1) {
															System.out.println("Insira o número da sua Conta: ");
															int numero = input.nextInt();
															ContaPoupanca cp = c.buscaContaPoupanca(numero);
															if(cp != null) {
																System.out.println("Insira o valor do depósito: ");
																double valorD = input.nextDouble();
																System.out.println("Finalizar a operação\n[1] Sim\n[2] Não");
																int finalizar4 = input.nextInt();
																if(finalizar4 == 1) {
																	cp.depositar(valorD);
																	System.out.println("Operação concluída com sucesso");
																	verN1 = false;
																}
																else {
																	System.out.println("Operação cancelada");
																	verN1 = false;
																}
															}
															else {
																System.out.println("Numero da conta inválido");
															}
														}
														break;
														
													case 2: // sacar
														boolean verN2 = true;
														while(verN2) {
															System.out.println("Insira o número da sua Conta: ");
															int numero_s = input.nextInt();
															ContaPoupanca cp_s = c.buscaContaPoupanca(numero_s);
															if(cp_s != null) {
																boolean r_saque = true;
																while(r_saque) {
																	System.out.println("Insira o valor do saque: ");
																	double valorS = input.nextDouble();
																	if(valorS <= cp_s.getSaldo()) {
																		System.out.println("Finalizar a operação\n[1] Sim\n[2] Não");
																		int finalizar5 = input.nextInt();
																		if(finalizar5 == 1) {
																			cp_s.sacar(valorS);
																			System.out.println("Operação concluída com sucesso");
																			r_saque = false;
																		}
																		else {
																			System.out.println("Operação cancelada");
																			r_saque = false;
																		}
																	}
																	else{
																		System.out.println("Valor inválido");
																	}
																}
															}
															else {
																System.out.println("Numero da conta inválido");
															}
														}
														break;
															
													case 3: // saldo
														boolean verN3 = true;
														while(verN3) {
															System.out.println("Insira o número da sua Conta: ");
															int numero_sa = input.nextInt();
															ContaPoupanca cp_sa = c.buscaContaPoupanca(numero_sa);
															if(cp_sa != null) {
																System.out.println("Seu Saldo é: "+ cp_sa.getSaldo());
																verN3 = false;
															}
															else {
																System.out.println("Numero da conta inválido");
																System.out.println("Cancelar operação?\n[1] Sim\n[2] Nao");
																int cancelarSaldo = input.nextInt();
																if(cancelarSaldo == 1) {
																	verN3 = false;
																}
																else {
																	continue;
																}
																
															}
														}
														break;
														
													case 4: // transferencia
														boolean verN4 = true;
														while(verN4) {
															System.out.println("Insira o número da sua Conta: ");
															int numero_tt = input.nextInt();
															ContaPoupanca cp_t = c.buscaContaPoupanca(numero_tt);
															if(cp_t != null) {
																boolean vercpf = true;
																while(vercpf) {
																	System.out.println("Insira o CPF do titular da Conta destino: ");
																	String cpf_d = input.next();
																	Cliente cd = agencia.buscaCliente(cpf_d);
																	if(cd != null) {
																		boolean verND = true;
																		while(verND) {
																			System.out.println("Insira o número da Conta destino da transferência: ");
																			int numero_td = input.nextInt();
																			ContaPoupanca cpd = cd.buscaContaPoupanca(numero_td);
																			if(cpd != null) {
																				System.out.println("Insira o valor da transferência: ");
																				double valor_t = input.nextDouble();
																				if(valor_t >= cp_t.getSaldo()) {
																					System.out.println("Deseja finalizar a operação?\n[1] Sim\n[2] Não");
																					int finalizarTrs = input.nextInt();
																					if(finalizarTrs == 1){ 
																						cp_t.transferenciaCpoupanca(cpd, valor_t);
																						System.out.println("Transferencia efetuada com sucesso");
																						verND = false;
																						vercpf = false;
																						verN4 = false;
																					}
																					else {
																						System.out.println("Operação cancelada");
																						verND = false;
																						vercpf = false;
																						verN4 = false;
																					}
																				}
																				else {
																					System.out.println("Valor inválido");
																				}
																			}
																			else {
																				System.out.println("Número da conta destino inválido");
																			}
																		}
																	}
																	else {
																		System.out.println("CPF inválido");
																	}
																}
															}
															else {
																System.out.println("Numero da Conta inválido");
															}
														}
														break;
														
													case 5: // sair
														cp_r = false;
														break;
														
													default:
														System.out.println("Opcao Inválida");
														break;
												}
											}
											break;
											
										case 3:
											run_c = false;
											break;
											
										default:
											System.out.println("Opção inválida");
											break;
									}
								}
								break;
							}
							else {
								System.out.println("CPF ou senha inválidos");
							}
						}
						else {
							System.out.println("CPF ou senha inválidos");
							ver = false;
						}
					}
					break;
					
				case 3:
					run = false;
					break;
					
				default:
					System.out.println("Opção inválida");
					break;
			}
		}
	}
}