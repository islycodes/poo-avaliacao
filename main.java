import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public class main {

    public static int menu() {
        int option = -1;
                //Solicita a entrada para o usuário
                try {String text = JOptionPane.showInputDialog (
                    null, 
                    "BEM VINDO A LANCHONETE P2             " +
                    " \n\n0. Sair                          " +
                    " \n1. Pizza de Abobrinha      R$ 15,00" + 
                    " \n2. Suco de Cenoura         R$  6,00" +
                    " \n3. Empada de Frango        R$ 17,50" +
                    " \n4. Sorvete de Abacaxi      R$ 12,00" +
                    " \n5. Risoto de limão         R$ 37,90" +
                    " \n6. Porção de Batata-frita  R$ 18,00" +
                    " \n7. Cone de Oreo            R$ 12,00" +
                    " \n8. Água                    R$  2,00" +
                    " \n9. Consultar Carrinho              " +
                    " \n                                   " +
                    " \nDigite uma opção: ", "Cardápio",
                    JOptionPane.PLAIN_MESSAGE);
                    
                    if(text == null) {
                        option = 0;
                    }

                    else
                    option = Integer.parseInt(text);
                }
                                                      
                    //Tratamento de erro, caso o usuário não insira um valor numérico
                        catch(HeadlessException | NumberFormatException e) {
                            JOptionPane.showMessageDialog (null, "O menu só funciona com a inserção de um valor númerico válido.", "Erro",
                                JOptionPane.ERROR_MESSAGE); 

                            }  

                return option;
    }

    public static void main(String[] args) {
        int option = -1, n = -1, m = -1;
        double carrinho = 0.00;

        while(option != 0) {
        
        option = menu();
    
                switch(option){
                
                    case 0: 
                    if(carrinho > 0) {
                        m = JOptionPane.showConfirmDialog (null, "Você participa do clube P2?", "CLUBE DE DESCONTO",
                        JOptionPane.YES_NO_OPTION);
                        if(m != 0) {
                            JOptionPane.showMessageDialog (null, "Pague sua conta de: R$ " + (carrinho), "CAIXA",
                            JOptionPane.WARNING_MESSAGE);
                            JOptionPane.showMessageDialog (null, "Deu tudo certo com seu pagamento, tenha uma Boa noite!", "Pagamento Autorizado",
                            JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog (null, "Pague sua conta de: R$ " + (carrinho) + " com 10% de desconto por participar do clube." + "\nTotal a ser pago: R$ " +
                            (carrinho - (0.1 * carrinho)), "CAIXA",
                            JOptionPane.WARNING_MESSAGE);
                            JOptionPane.showMessageDialog (null, "Deu tudo certo com seu pagamento, tenha uma Boa noite!", "Pagamento Autorizado",
                            JOptionPane.INFORMATION_MESSAGE);
                        }
                    } 


                    else {
                        n = JOptionPane.showConfirmDialog (null, "Deseja sair do programa?");
                        if(n != 0){
                            option = -1;
                        }
                    }
                    break;

                case 1: 
                    carrinho += 15;
                    break;
                    
                case 2:
                    carrinho +=6;
                    break;
                    
                case 3:
                    carrinho +=17.5;
                    break;
                    
                case 4:
                    carrinho +=12;
                    break;
                    
                case 5:
                    carrinho +=37.9;
                    break;

                case 6:
                    carrinho +=18;
                    break;
                                   
                case 7:
                    carrinho +=12;
                    break;

                case 8:
                    carrinho +=2;
                    break;

                case 9:
                JOptionPane.showMessageDialog (null, "Valor atual: R$ " + (carrinho), "Carrinho",
                JOptionPane.WARNING_MESSAGE);
                    break;
                
                default:
                    option = 0;
                }
            }
    }
}